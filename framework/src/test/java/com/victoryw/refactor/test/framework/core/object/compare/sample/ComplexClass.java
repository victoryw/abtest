package com.victoryw.refactor.test.framework.core.object.compare.sample;

public class ComplexClass {
    private final SimpleClass simpleClass;

    public ComplexClass(int value) {
        this.simpleClass = new SimpleClass(value);
    }
}
