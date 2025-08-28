/*
 * GPLv3 License
 *
 * Copyright (c) 2023-2025 4ra1n (Jar Analyzer Team)
 *
 * This project is distributed under the GPLv3 license.
 *
 * https://github.com/jar-analyzer/jar-analyzer/blob/master/LICENSE
 */

package me.n1ar4.jar.analyzer.core.asm;

import me.n1ar4.jar.analyzer.core.reference.AnnoReference;
import me.n1ar4.jar.analyzer.core.reference.ClassReference;
import me.n1ar4.jar.analyzer.core.reference.MethodReference;
import me.n1ar4.jar.analyzer.starter.Const;
import org.objectweb.asm.*;

import java.util.*;

public class DiscoveryClassVisitor extends ClassVisitor {
    private Integer version;
    private Integer access;
    private String name;
    private String superName;
    private String[] interfaces;
    private boolean isInterface;
    private List<ClassReference.Member> members;
    private ClassReference.Handle classHandle;
    private Set<AnnoReference> annotations;
    private final Set<ClassReference> discoveredClasses;
    private final Set<MethodReference> discoveredMethods;
    private final String jarName;
    private final Integer jarId;

    public DiscoveryClassVisitor(Set<ClassReference> discoveredClasses,
                                 Set<MethodReference> discoveredMethods,
                                 String jarName, Integer jarId) {
        super(Const.ASMVersion);
        this.discoveredClasses = discoveredClasses;
        this.discoveredMethods = discoveredMethods;
        this.jarName = jarName;
        this.jarId = jarId;
    }

    @Override
    public void visit(int version, int access, String name,
                      String signature, String superName, String[] interfaces) {
        this.version = version;
        this.access = access;
        this.name = name;
        this.superName = superName;
        this.interfaces = interfaces;
        this.isInterface = (access & Opcodes.ACC_INTERFACE) != 0;
        this.members = new ArrayList<>();
        this.classHandle = new ClassReference.Handle(name);
        annotations = new HashSet<>();
        super.visit(version, access, name, signature, superName, interfaces);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        AnnoReference annoReference = new AnnoReference();
        annoReference.setAnnoName(descriptor);
        annoReference.setVisible(visible);
        annotations.add(annoReference);
        return super.visitAnnotation(descriptor, visible);
    }

    public FieldVisitor visitField(int access, String name, String desc,
                                   String signature, Object value) {
        Type type = Type.getType(desc);
        String typeName;
        if (type.getSort() == Type.OBJECT || type.getSort() == Type.ARRAY) {
            typeName = type.getInternalName();
        } else {
            typeName = type.getDescriptor();
        }
        String realValue;
        if (value instanceof String) {
            realValue = (String) value;
        } else {
            realValue = String.valueOf(value);
        }
        members.add(new ClassReference.Member(name, access, realValue, desc, signature, new ClassReference.Handle(typeName)));
        return super.visitField(access, name, desc, signature, value);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
                                     String signature, String[] exceptions) {
        boolean isStatic = (access & Opcodes.ACC_STATIC) != 0;
        Set<AnnoReference> mAnno = new HashSet<>();
        MethodReference methodReference = new MethodReference(
                classHandle, name, desc, isStatic, mAnno, access, -1, jarName, jarId);
        discoveredMethods.add(methodReference);
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        return new DiscoveryMethodAdapter(Const.ASMVersion, mv, mAnno, methodReference);
    }

    @Override
    public void visitEnd() {
        ClassReference classReference = new ClassReference(
                version,
                access,
                name,
                superName,
                Arrays.asList(interfaces),
                isInterface,
                members,
                annotations,
                jarName,
                jarId);
        discoveredClasses.add(classReference);
        super.visitEnd();
    }
}
