/*
 * GPLv3 License
 *
 * Copyright (c) 2023-2025 4ra1n (Jar Analyzer Team)
 *
 * This project is distributed under the GPLv3 license.
 *
 * https://github.com/jar-analyzer/jar-analyzer/blob/master/LICENSE
 */

package com.n1ar4.agent.transform;


import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;


public class CoreTransformer implements ClassFileTransformer {

    private final String targetClass;

    public byte[] data;

    public CoreTransformer(String targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    @SuppressWarnings("all")
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) {
        className = className.replace("/", ".");
        if (className.equals(targetClass)) {
            System.out.println("[*] GET BYTECODE : " + className);
            data = new byte[classfileBuffer.length + 1];
            System.arraycopy(classfileBuffer, 0, data, 0, classfileBuffer.length);
        }
        return classfileBuffer;
    }
}