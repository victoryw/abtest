package com.victoryw.refactor.test.framework.core;

import org.joor.ReflectException;

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

    private Object run(String methodName, final Object[] parameters) {
        final Object[] args = Arrays.stream(parameters)
                .map(this.copier::copyObjectToTargetClassLoader).toArray();

        final Object resultInSample = on(this.instanceInOtherClassLoader).
                call(methodName, args).get();

        return this.copier.copyObjectToCurrentClassLoader(resultInSample);
    }

    public Object run(String methodName) throws Throwable {
        try {
            return this.run(methodName, new Object[]{});
        } catch (ReflectException exception) {
            if(exception.getCause() == null) {
                throw exception;
            }

            if(exception.getCause().getCause() == null) {
                throw exception.getCause();
            }

            throw exception.getCause().getCause();
        }
    }
}
