/*
 * GPLv3 License
 *
 * Copyright (c) 2023-2025 4ra1n (Jar Analyzer Team)
 *
 * This project is distributed under the GPLv3 license.
 *
 * https://github.com/jar-analyzer/jar-analyzer/blob/master/LICENSE
 */

package me.n1ar4.jar.analyzer.starter;

import me.n1ar4.jar.analyzer.utils.ColorUtil;
import me.n1ar4.jar.analyzer.utils.IOUtils;

import java.io.InputStream;

public class Logo {
    public static void print() {
        System.out.println(ColorUtil.green("     ____.               _____                .__                              \n" +
                "    |    |____ _______  /  _  \\   ____ _____  |  | ___.__.________ ___________ \n" +
                "    |    \\__  \\\\_  __ \\/  /_\\  \\ /    \\\\__  \\ |  |<   |  |\\___   // __ \\_  __ \\\n" +
                "/\\__|    |/ __ \\|  | \\/    |    \\   |  \\/ __ \\|  |_\\___  | /    /\\  ___/|  | \\/\n" +
                "\\________(____  /__|  \\____|__  /___|  (____  /____/ ____|/_____ \\\\___  >__|   \n" +
                "              \\/              \\/     \\/     \\/     \\/           \\/    \\/       "));
        System.out.printf(ColorUtil.yellow("Jar Analyzer %s") + " @ " +
                ColorUtil.red("4ra1n (https://github.com/4ra1n)") + "\n", Const.version);
        System.out.printf(ColorUtil.blue("Project Address") + " -> " + "%s\n\n", Const.projectUrl);

        InputStream is = Logo.class.getClassLoader().getResourceAsStream("thanks.txt");
        if (is != null) {
            try {
                byte[] data = IOUtils.readAllBytes(is);
                String a = new String(data);
                String[] splits = a.split("\n");
                if (splits.length > 1) {
                    System.out.println(ColorUtil.green("感谢以下贡献者（排名不分先后）"));
                }
                System.out.println(a);
            } catch (Exception ignored) {
            }
        }
    }
}
