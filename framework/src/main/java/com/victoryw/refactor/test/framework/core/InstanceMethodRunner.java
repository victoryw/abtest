package com.victoryw.refactor.test.framework.core;

import java.util.Arrays;

import static org.joor.Reflect.on;

public class InstanceMethodRunner {
    private final ObjectCopier copier;
    private Object instanceInOtherClassLoader;

    public InstanceMethodRunner(final ObjectCopier copier) {
        this.copier = copier;
    }

    public void init(final Object sourceInstance) {
        this.instanceInOtherClassLoader = this.copier.copyObjectToTargetClassLoader(sourceInstance);
    }

    public Object run(String methodName, final Object[] parameters) {
        final Object[] args = Arrays.stream(parameters)
                .map(this.copier::copyObjectToTargetClassLoader).toArray();

        final Object resultInSample = on(this.instanceInOtherClassLoader).
                call(methodName, args).get();

        return this.copier.copyObjectToCurrentClassLoader(resultInSample);
    }

    public Object run(String methodName) {
        return this.run(methodName, new Object[]{});
    }
}
