/*
 * GPLv3 License
 *
 * Copyright (c) 2023-2025 4ra1n (Jar Analyzer Team)
 *
 * This project is distributed under the GPLv3 license.
 *
 * https://github.com/jar-analyzer/jar-analyzer/blob/master/LICENSE
 */

package me.n1ar4.jar.analyzer.core;

import me.n1ar4.jar.analyzer.analyze.spring.SpringService;
import me.n1ar4.jar.analyzer.config.ConfigEngine;
import me.n1ar4.jar.analyzer.config.ConfigFile;
import me.n1ar4.jar.analyzer.core.asm.FixClassVisitor;
import me.n1ar4.jar.analyzer.core.asm.StringClassVisitor;
import me.n1ar4.jar.analyzer.core.reference.ClassReference;
import me.n1ar4.jar.analyzer.core.reference.MethodReference;
import me.n1ar4.jar.analyzer.engine.CoreEngine;
import me.n1ar4.jar.analyzer.engine.CoreHelper;
import me.n1ar4.jar.analyzer.entity.ClassFileEntity;
import me.n1ar4.jar.analyzer.gui.MainForm;
import me.n1ar4.jar.analyzer.gui.ModeSelector;
import me.n1ar4.jar.analyzer.gui.util.LogUtil;
import me.n1ar4.jar.analyzer.gui.util.MenuUtil;
import me.n1ar4.jar.analyzer.starter.Const;
import me.n1ar4.jar.analyzer.utils.CoreUtil;
import me.n1ar4.jar.analyzer.utils.DirUtil;
import me.n1ar4.jar.analyzer.utils.IOUtil;
import me.n1ar4.log.LogManager;
import me.n1ar4.log.Logger;
import org.objectweb.asm.ClassReader;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.*;

public class CoreRunner {
    private static final Logger logger = LogManager.getLogger();

    private static boolean quickMode = false;

    public static void run(Path jarPath, Path rtJarPath, boolean fixClass, JDialog dialog) {
        // 2024-12-30
        // 非 CLI 才会弹窗
        if (!AnalyzeEnv.isCli) {
            // 2024-07-05 不允许太大的 JAR 文件
            long totalSize = 0;
            List<String> beforeJarList = new ArrayList<>();
            if (Files.isDirectory(jarPath)) {
                beforeJarList.addAll(DirUtil.GetFiles(jarPath.toAbsolutePath().toString()));
            } else {
                beforeJarList.add(jarPath.toAbsolutePath().toString());

            }
            if (rtJarPath != null) {
                beforeJarList.add(rtJarPath.toAbsolutePath().toString());
            }
            for (String s : beforeJarList) {
                if (s.toLowerCase().endsWith(".jar") ||
                        s.toLowerCase().endsWith(".war") ||
                        // 2025/06/26 统计大小时丢失 JAR 文件
                        s.toLowerCase().endsWith(".class")) {
                    totalSize += Paths.get(s).toFile().length();
                }
            }

            int totalM = (int) (totalSize / 1024 / 1024);

            int chose;
            if (totalM > 1024) {
                // 对于大于 1G 的 JAR 输入进行提示
                chose = JOptionPane.showConfirmDialog(MainForm.getInstance().getMasterPanel(),
                        "<html>加载 JAR/WAR 总大小 <strong>" + totalM + "</strong> MB<br>" +
                                "文件内容过大，可能产生巨大的临时文件和数据库，可能非常消耗内存<br>" +
                                "请确认是否要继续进行分析" +
                                "</html>");
            } else if (totalM == 0) {
                chose = JOptionPane.showConfirmDialog(MainForm.getInstance().getMasterPanel(),
                        "加载 JAR/WAR 总大小不足 1MB 是否继续");
            } else {
                chose = JOptionPane.showConfirmDialog(MainForm.getInstance().getMasterPanel(),
                        "加载 JAR/WAR 总大小 " + totalM + " MB 是否继续");
            }
            if (chose != 0) {
                MainForm.getInstance().getStartBuildDatabaseButton().setEnabled(true);
                return;
            }

            // 2025/04/06 FEAT
            // 允许选择标准模式和快速模式两种方式
            int res = ModeSelector.show();
            switch (res) {
                case 0:
                    JOptionPane.showMessageDialog(null, "你必须选择一种模式");
                    MainForm.getInstance().getStartBuildDatabaseButton().setEnabled(true);
                    return;
                case 1:
                    quickMode = false;
                    logger.info("use std mode");
                    break;
                case 2:
                    quickMode = true;
                    logger.info("use quick mode");
                    break;
                default:
                    logger.error("unknown mode");
                    MainForm.getInstance().getStartBuildDatabaseButton().setEnabled(true);
                    return;
            }

            if (dialog != null) {
                new Thread(() -> dialog.setVisible(true)).start();
            }

            MainForm.getInstance().getStartBuildDatabaseButton().setEnabled(false);
        }

        Map<String, Integer> jarIdMap = new HashMap<>();

        List<ClassFileEntity> cfs;
        MainForm.getInstance().getBuildBar().setValue(10);
        if (Files.isDirectory(jarPath)) {
            logger.info("input is a dir");
            LogUtil.info("input is a dir");
            List<String> files = DirUtil.GetFiles(jarPath.toAbsolutePath().toString());
            if (rtJarPath != null) {
                files.add(rtJarPath.toAbsolutePath().toString());
                LogUtil.info("analyze with rt.jar file");
            }
            MainForm.getInstance().getTotalJarVal().setText(String.valueOf(files.size()));
            for (String s : files) {
                if (s.toLowerCase().endsWith(".jar") ||
                        s.toLowerCase().endsWith(".war")) {
                    DatabaseManager.saveJar(s);
                    jarIdMap.put(s, DatabaseManager.getJarId(s).getJid());
                }
            }
            cfs = CoreUtil.getAllClassesFromJars(files, jarIdMap);
        } else {
            logger.info("input is a jar file");
            LogUtil.info("input is a jar");

            List<String> jarList = new ArrayList<>();
            if (rtJarPath != null) {
                jarList.add(rtJarPath.toAbsolutePath().toString());
                MainForm.getInstance().getTotalJarVal().setText("2");
                LogUtil.info("analyze with rt.jar file");
            } else {
                MainForm.getInstance().getTotalJarVal().setText("1");
            }

            MainForm.getInstance().getTotalJarVal().setText("1");
            jarList.add(jarPath.toAbsolutePath().toString());
            for (String s : jarList) {
                DatabaseManager.saveJar(s);
                jarIdMap.put(s, DatabaseManager.getJarId(s).getJid());
            }
            cfs = CoreUtil.getAllClassesFromJars(jarList, jarIdMap);
        }
        // BUG CLASS NAME
        for (ClassFileEntity cf : cfs) {
            String className = cf.getClassName();
            if (!fixClass) {
                int i = className.indexOf("classes");
                if (className.contains("BOOT-INF") || className.contains("WEB-INF")) {
                    // 从 BOOT-INF/classes 开始取
                    // 从 WEB-INF/classes 开始取
                    className = className.substring(i + 8);
                }
                // 如果 i 小于 0 (不包含 classes 目录) 直接设置
                cf.setClassName(className);
            } else {
                // fix class name
                Path parPath = Paths.get(Const.tempDir);
                FixClassVisitor cv = new FixClassVisitor();
                ClassReader cr = new ClassReader(cf.getFile());
                cr.accept(cv, Const.AnalyzeASMOptions);
                // get actual class name
                Path path = parPath.resolve(Paths.get(cv.getName()));
                File file = path.toFile();
                // write file
                if (!file.getParentFile().mkdirs()) {
                    logger.error("fix class mkdirs error");
                }
                className = file.getPath() + ".class";
                try {
                    IOUtil.copy(new ByteArrayInputStream(cf.getFile()),
                            new FileOutputStream(className));
                } catch (FileNotFoundException ignored) {
                    logger.error("fix path copy bytes error");
                }
                cf.setClassName(className);
                cf.setPath(Paths.get(className));
            }
        }

        MainForm.getInstance().getBuildBar().setValue(15);
        AnalyzeEnv.classFileList.addAll(cfs);
        logger.info("get all class");
        LogUtil.info("get all class");
        DatabaseManager.saveClassFiles(AnalyzeEnv.classFileList);
        MainForm.getInstance().getBuildBar().setValue(20);
        DiscoveryRunner.start(AnalyzeEnv.classFileList, AnalyzeEnv.discoveredClasses,
                AnalyzeEnv.discoveredMethods, AnalyzeEnv.classMap,
                AnalyzeEnv.methodMap, AnalyzeEnv.stringAnnoMap);
        DatabaseManager.saveClassInfo(AnalyzeEnv.discoveredClasses);
        MainForm.getInstance().getBuildBar().setValue(25);
        DatabaseManager.saveMethods(AnalyzeEnv.discoveredMethods);
        MainForm.getInstance().getBuildBar().setValue(30);
        logger.info("analyze class finish");
        LogUtil.info("analyze class finish");
        for (MethodReference mr : AnalyzeEnv.discoveredMethods) {
            ClassReference.Handle ch = mr.getClassReference();
            if (AnalyzeEnv.methodsInClassMap.get(ch) == null) {
                List<MethodReference> ml = new ArrayList<>();
                ml.add(mr);
                AnalyzeEnv.methodsInClassMap.put(ch, ml);
            } else {
                List<MethodReference> ml = AnalyzeEnv.methodsInClassMap.get(ch);
                ml.add(mr);
                AnalyzeEnv.methodsInClassMap.put(ch, ml);
            }
        }
        MainForm.getInstance().getBuildBar().setValue(35);
        MethodCallRunner.start(AnalyzeEnv.classFileList, AnalyzeEnv.methodCalls);
        MainForm.getInstance().getBuildBar().setValue(40);

        if (!quickMode) {
            AnalyzeEnv.inheritanceMap = InheritanceRunner.derive(AnalyzeEnv.classMap);
            MainForm.getInstance().getBuildBar().setValue(50);
            logger.info("build inheritance");
            LogUtil.info("build inheritance");
            Map<MethodReference.Handle, Set<MethodReference.Handle>> implMap =
                    InheritanceRunner.getAllMethodImplementations(AnalyzeEnv.inheritanceMap, AnalyzeEnv.methodMap);
            DatabaseManager.saveImpls(implMap);
            MainForm.getInstance().getBuildBar().setValue(60);

            // 2024/09/02
            // 自动处理方法实现是可选的
            // 具体参考 doc/README-others.md
            if (MenuUtil.enableFixMethodImpl()) {
                // 方法 -> [所有子类 override 方法列表]
                for (Map.Entry<MethodReference.Handle, Set<MethodReference.Handle>> entry :
                        implMap.entrySet()) {
                    MethodReference.Handle k = entry.getKey();
                    Set<MethodReference.Handle> v = entry.getValue();
                    // 当前方法的所有 callee 列表
                    HashSet<MethodReference.Handle> calls = AnalyzeEnv.methodCalls.get(k);
                    // 增加所有的 override 方法
                    calls.addAll(v);
                }
            } else {
                logger.warn("enable fix method impl/override is recommend");
            }

            DatabaseManager.saveMethodCalls(AnalyzeEnv.methodCalls);
            MainForm.getInstance().getBuildBar().setValue(70);
            logger.info("build extra inheritance");
            LogUtil.info("build extra inheritance");
            for (ClassFileEntity file : AnalyzeEnv.classFileList) {
                try {
                    StringClassVisitor dcv = new StringClassVisitor(AnalyzeEnv.strMap, AnalyzeEnv.classMap, AnalyzeEnv.methodMap);
                    ClassReader cr = new ClassReader(file.getFile());
                    cr.accept(dcv, Const.AnalyzeASMOptions);
                } catch (Exception ex) {
                    logger.error("string analyze error: {}", ex.toString());
                }
            }

            MainForm.getInstance().getBuildBar().setValue(80);
            DatabaseManager.saveStrMap(AnalyzeEnv.strMap, AnalyzeEnv.stringAnnoMap);

            SpringService.start(AnalyzeEnv.classFileList, AnalyzeEnv.controllers, AnalyzeEnv.classMap, AnalyzeEnv.methodMap);
            DatabaseManager.saveSpringController(AnalyzeEnv.controllers);

            OtherWebService.start(AnalyzeEnv.classFileList,
                    AnalyzeEnv.interceptors,
                    AnalyzeEnv.servlets, AnalyzeEnv.filters, AnalyzeEnv.listeners);
            DatabaseManager.saveSpringInterceptor(AnalyzeEnv.interceptors);
            DatabaseManager.saveServlets(AnalyzeEnv.servlets);
            DatabaseManager.saveFilters(AnalyzeEnv.filters);
            DatabaseManager.saveListeners(AnalyzeEnv.listeners);

            MainForm.getInstance().getBuildBar().setValue(90);
        } else {
            MainForm.getInstance().getBuildBar().setValue(70);
            DatabaseManager.saveMethodCalls(AnalyzeEnv.methodCalls);
        }

        logger.info("build database finish");
        LogUtil.info("build database finish");

        long fileSizeBytes = getFileSize();
        String fileSizeMB = formatSizeInMB(fileSizeBytes);
        MainForm.getInstance().getDatabaseSizeVal().setText(fileSizeMB);
        MainForm.getInstance().getBuildBar().setValue(100);
        MainForm.getInstance().getStartBuildDatabaseButton().setEnabled(false);

        MainForm.getInstance().getEngineVal().setText("RUNNING");
        MainForm.getInstance().getEngineVal().setForeground(Color.GREEN);

        MainForm.getInstance().getLoadDBText().setText(Const.dbFile);

        ConfigFile config = MainForm.getConfig();
        if (config == null) {
            config = new ConfigFile();
        }
        config.setTotalMethod(MainForm.getInstance().getTotalMethodVal().getText());
        config.setTotalClass(MainForm.getInstance().getTotalClassVal().getText());
        config.setTotalJar(MainForm.getInstance().getTotalJarVal().getText());
        config.setTempPath(Const.tempDir);
        config.setDbPath(Const.dbFile);
        config.setJarPath(MainForm.getInstance().getFileText().getText());
        config.setDbSize(fileSizeMB);
        config.setLang("en");
        MainForm.setConfig(config);
        MainForm.setEngine(new CoreEngine(config));

        if (MainForm.getInstance().getAutoSaveCheckBox().isSelected()) {
            ConfigEngine.saveConfig(config);
            logger.info("auto save finish");
            LogUtil.info("auto save finish");
        }

        MainForm.getInstance().getFileTree().refresh();

        // GC
        AnalyzeEnv.classFileList.clear();
        AnalyzeEnv.discoveredClasses.clear();
        AnalyzeEnv.discoveredMethods.clear();
        AnalyzeEnv.methodsInClassMap.clear();
        AnalyzeEnv.classMap.clear();
        AnalyzeEnv.methodMap.clear();
        AnalyzeEnv.methodCalls.clear();
        AnalyzeEnv.strMap.clear();
        if (!quickMode) {
            AnalyzeEnv.inheritanceMap.getInheritanceMap().clear();
            AnalyzeEnv.inheritanceMap.getSubClassMap().clear();
        }
        AnalyzeEnv.controllers.clear();
        System.gc();

        // DISABLE WHITE/BLACK LIST
        MainForm.getInstance().getClassBlackArea().setEditable(false);
        MainForm.getInstance().getClassWhiteArea().setEditable(false);

        CoreHelper.refreshSpringC();
        CoreHelper.refreshSpringI();
        CoreHelper.refreshServlets();
        CoreHelper.refreshFilters();
        CoreHelper.refreshLiteners();

        if (dialog != null) {
            dialog.setVisible(false);
            dialog.dispose();
        }
    }

    private static long getFileSize() {
        File file = new File(Const.dbFile);
        return file.length();
    }

    private static String formatSizeInMB(long fileSizeBytes) {
        double fileSizeMB = (double) fileSizeBytes / (1024 * 1024);
        return String.format("%.2f MB", fileSizeMB);
    }
}
