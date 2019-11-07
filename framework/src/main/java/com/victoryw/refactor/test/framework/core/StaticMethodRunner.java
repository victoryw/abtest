package com.victoryw.refactor.test.framework.core;

import org.joor.Reflect;

import static org.joor.Reflect.on;

public class StaticMethodRunner {
    private final ClassLoader baseLineProjectClassLoader;
    private String className;

    public StaticMethodRunner(final ClassLoader baseLineProjectClassLoader) {
        this.baseLineProjectClassLoader = baseLineProjectClassLoader;
    }

    public Object run(String methodName) {
        final Reflect on = on(this.className, this.baseLineProjectClassLoader);
        return on.call(methodName).get();
    }

    public void init(String className) {
        this.className = className;
    }
}
