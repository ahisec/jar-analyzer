/*
 * GPLv3 License
 *
 * Copyright (c) 2023-2025 4ra1n (Jar Analyzer Team)
 *
 * This project is distributed under the GPLv3 license.
 *
 * https://github.com/jar-analyzer/jar-analyzer/blob/master/LICENSE
 */

package me.n1ar4.jar.analyzer.el;

import me.n1ar4.jar.analyzer.core.reference.MethodReference;
import org.objectweb.asm.Type;

public class ResObj {
    private final String className;
    private final MethodReference.Handle method;
    private final int lineNumber;

    public ResObj(MethodReference.Handle m, String className, int lineNumber) {
        this.className = className;
        this.method = m;
        this.lineNumber = lineNumber;
    }

    public String getClassName() {
        return this.className;
    }

    public MethodReference.Handle getMethod() {
        return this.method;
    }

    private int getNumFromDesc() {
        Type methodType = Type.getMethodType(this.method.getDesc());
        return methodType.getArgumentTypes().length;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String toString() {
        String outputFormat = "%s %s (params:%d)";
        return String.format(outputFormat,
                className,
                method.getName(),
                getNumFromDesc());
    }
}
