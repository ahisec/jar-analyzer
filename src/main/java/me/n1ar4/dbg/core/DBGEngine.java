/*
 * GPLv3 License
 *
 * Copyright (c) 2023-2025 4ra1n (Jar Analyzer Team)
 *
 * This project is distributed under the GPLv3 license.
 *
 * https://github.com/jar-analyzer/jar-analyzer/blob/master/LICENSE
 */

package me.n1ar4.dbg.core;

import com.sun.jdi.*;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.request.BreakpointRequest;
import com.sun.jdi.request.ClassPrepareRequest;
import com.sun.jdi.request.StepRequest;
import me.n1ar4.log.LogManager;
import me.n1ar4.log.Logger;

import java.util.List;
import java.util.Map;

public class DBGEngine {
    private static final Logger logger = LogManager.getLogger();
    public static final String HOST = "localhost";
    public static final String TRANSPORT = "dt_socket";
    private final String targetHost;
    private final String targetPort;
    private final String transport;
    private VirtualMachine vm;

    public VirtualMachine getVm() {
        return vm;
    }

    public DBGEngine(String targetPort) {
        this(HOST, targetPort, TRANSPORT);
    }

    public DBGEngine(String host,
                     String port,
                     String transport) {
        this.targetHost = host;
        this.targetPort = port;
        this.transport = transport;
    }

    public boolean init() {
        VirtualMachineManager vmm = Bootstrap.virtualMachineManager();
        AttachingConnector connector = null;
        for (AttachingConnector c : vmm.attachingConnectors()) {
            if (c.transport().name().equals(this.transport)) {
                connector = c;
                break;
            }
        }
        if (connector == null) {
            throw new RuntimeException("connector not found");
        }
        Map<String, Connector.Argument> arguments = connector.defaultArguments();
        arguments.get("hostname").setValue(this.targetHost);
        arguments.get("port").setValue(this.targetPort);
        arguments.get("timeout").setValue("10000");
        try {
            vm = connector.attach(arguments);
            if (vm != null) {
                logger.info("connect target jvm success");
                return true;
            }
        } catch (Exception ex) {
            logger.error("can not attach jvm: {}", ex.toString());
        }
        return false;
    }

    public void createBreakpoint(String className,
                                 String methodName,
                                 String methodDesc) {
        List<ReferenceType> classes = this.vm.classesByName(className);
        if (classes.isEmpty()) {
            logger.warn("class not found: {}", className);
            return;
        }
        ReferenceType targetClass = classes.get(0);
        List<Method> methods = targetClass.methodsByName(methodName);
        if (methods.isEmpty()) {
            logger.warn("method not found: {}", methodName);
            return;
        }
        Method targetMethod = null;
        if (methodDesc == null) {
            for (Method m : methods) {
                logger.info("add break point {} {} {}",
                        targetClass.name(), m.name(), m.signature());
                this.vm.eventRequestManager().createBreakpointRequest(
                        m.location()).enable();
            }
        } else {
            for (Method method : methods) {
                if (method.signature().equals(methodDesc)) {
                    targetMethod = method;
                }
            }
        }
        if (targetMethod == null) {
            logger.warn("method not found: {}", methodName);
            return;
        }
        logger.info("add break point {} {} {}",
                targetClass.name(), targetMethod.name(), targetMethod.signature());
        this.vm.eventRequestManager().createBreakpointRequest(
                targetMethod.location()).enable();
    }

    public StepRequest createStepIntoCodeRequest(ThreadReference thread) {
        logger.info("create step in: {}", thread.name());
        return this.vm.eventRequestManager().createStepRequest(
                thread,
                StepRequest.STEP_MIN,
                StepRequest.STEP_INTO);
    }

    public StepRequest createStepOverCodeRequest(ThreadReference thread) {
        logger.info("create step over: {}", thread.name());
        return this.vm.eventRequestManager().createStepRequest(
                thread,
                StepRequest.STEP_MIN,
                StepRequest.STEP_OVER);
    }

    public StepRequest createStepOutCodeRequest(ThreadReference thread) {
        logger.info("create step out: {}", thread.name());
        return this.vm.eventRequestManager().createStepRequest(
                thread,
                StepRequest.STEP_MIN,
                StepRequest.STEP_OUT);
    }

    public BreakpointRequest createBreakpointLoc(Location location) {
        logger.info("create break point location: {}", location);
        return this.vm.eventRequestManager().createBreakpointRequest(location);
    }

    public ClassPrepareRequest createClassPrepareRequest(String className) {
        logger.info("create class prepare: {}", className);
        ClassPrepareRequest cpr = this.vm.eventRequestManager().createClassPrepareRequest();
        cpr.addClassFilter(className);
        return cpr;
    }
}
