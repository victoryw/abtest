package com.victoryw.refactor.test.framework.core.object.instnce.method.runner.sample;

import java.io.InvalidObjectException;

public class ThrowRuntimeExceptionObj {
    public void toThrow() {
        throw  new NoSuchFieldError();
    }
}
