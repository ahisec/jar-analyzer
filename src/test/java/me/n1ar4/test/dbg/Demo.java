/*
 * GPLv3 License
 *
 * Copyright (c) 2023-2025 4ra1n (Jar Analyzer Team)
 *
 * This project is distributed under the GPLv3 license.
 *
 * https://github.com/jar-analyzer/jar-analyzer/blob/master/LICENSE
 */

package me.n1ar4.test.dbg;

public class Demo {
    // main class: me.n1ar4.test.dbg.Demo
    // -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                Hello hello = new Hello();
                hello.hello(i);
                Thread.sleep(500);
            }
        } catch (Exception ignored) {
        }
    }
}