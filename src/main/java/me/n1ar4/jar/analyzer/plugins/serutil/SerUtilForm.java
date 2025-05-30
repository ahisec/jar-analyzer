/*
 * GPLv3 License
 *
 * Copyright (c) 2023-2025 4ra1n (Jar Analyzer Team)
 *
 * This project is distributed under the GPLv3 license.
 *
 * https://github.com/jar-analyzer/jar-analyzer/blob/master/LICENSE
 */

package me.n1ar4.jar.analyzer.plugins.serutil;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import me.n1ar4.dbg.utils.HexUtil;
import me.n1ar4.jar.analyzer.gui.MainForm;
import me.n1ar4.jar.analyzer.starter.Const;
import me.n1ar4.log.LogManager;
import me.n1ar4.log.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class SerUtilForm {
    private static final Logger logger = LogManager.getLogger();
    private JPanel masterPanel;
    private JTextField serFileText;
    private JButton fileBtn;
    private JTextArea serArea;
    private JRadioButton hexRadio;
    private JRadioButton baseRadio;
    private JButton analyzeBtn;
    private JLabel serFileLabel;
    private JLabel serHexBaseLabel;
    private JPanel serHexBasePanel;
    private JScrollPane serScroll;
    private JLabel actionLabel;

    private static SerUtilForm instance;

    public SerUtilForm() {
        this.hexRadio.setSelected(true);
        this.fileBtn.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.setDialogTitle("select a serialization file");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(this.masterPanel);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                serFileText.setText(selectedFile.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(this.masterPanel, "please select a file");
            }
        });
        this.analyzeBtn.addActionListener(e -> {
            String fileName = serFileText.getText();
            byte[] serData;
            if (fileName != null && !fileName.isEmpty()) {
                try {
                    serData = Files.readAllBytes(Paths.get(fileName));
                    if (hexRadio.isSelected()) {
                        serArea.setText(HexUtil.bytesToHex(serData));
                    } else {
                        serArea.setText(Base64.getEncoder().encodeToString(serData));
                    }
                } catch (Exception ex) {
                    logger.error("read file error: {}", ex.toString());
                    JOptionPane.showMessageDialog(this.masterPanel, "read file error");
                    return;
                }
            } else {
                String areaData = serArea.getText();
                if (areaData == null || areaData.isEmpty()) {
                    logger.error("data is null");
                    JOptionPane.showMessageDialog(this.masterPanel, "data is null");
                    return;
                }
                areaData = areaData.trim();
                if (hexRadio.isSelected()) {
                    serData = HexUtil.hexStringToBytes(areaData);
                } else if (baseRadio.isSelected()) {
                    serData = Base64.getDecoder().decode(areaData);
                } else {
                    return;
                }
            }
            SerUtil.show(serData);
        });
    }

    public static void start() {
        JFrame frame = new JFrame(Const.SerUtilForm);
        instance = new SerUtilForm();
        frame.setContentPane(instance.masterPanel);

        frame.pack();

        frame.setLocationRelativeTo(MainForm.getInstance().getMasterPanel());

        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        masterPanel = new JPanel();
        masterPanel.setLayout(new GridLayoutManager(4, 3, new Insets(3, 3, 3, 3), -1, -1));
        serFileLabel = new JLabel();
        serFileLabel.setText("Serialization Data File");
        masterPanel.add(serFileLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        final Spacer spacer1 = new Spacer();
        masterPanel.add(spacer1, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        serFileText = new JTextField();
        masterPanel.add(serFileText, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        fileBtn = new JButton();
        fileBtn.setText("Chose File");
        masterPanel.add(fileBtn, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        serHexBaseLabel = new JLabel();
        serHexBaseLabel.setText("Serializatrion Hex/Base64");
        masterPanel.add(serHexBaseLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        serHexBasePanel = new JPanel();
        serHexBasePanel.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        masterPanel.add(serHexBasePanel, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        serScroll = new JScrollPane();
        serHexBasePanel.add(serScroll, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(400, 200), null, null, 0, false));
        serArea = new JTextArea();
        serArea.setLineWrap(true);
        serScroll.setViewportView(serArea);
        hexRadio = new JRadioButton();
        hexRadio.setText("HEX DATA");
        serHexBasePanel.add(hexRadio, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        baseRadio = new JRadioButton();
        baseRadio.setText("BASE64 DATA");
        serHexBasePanel.add(baseRadio, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        actionLabel = new JLabel();
        actionLabel.setText("Actions");
        masterPanel.add(actionLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        analyzeBtn = new JButton();
        analyzeBtn.setText("Analyze");
        masterPanel.add(analyzeBtn, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(hexRadio);
        buttonGroup.add(baseRadio);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return masterPanel;
    }

}
