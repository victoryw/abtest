package com.victoryw.refactor.test.framework.core;

import com.victoryw.refactor.test.framework.core.object.instnce.method.runner.sample.ThrowRuntimeExceptionObj;
import org.joor.ReflectException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class InstanceMethodRunnerTest {

    @Test
    void should_throw_actual_exception_when_invoke_failed() {
        ObjectCopier objectCopier = mock(ObjectCopier.class);
        given(objectCopier.copyObjectToTargetClassLoader(anyObject())).willReturn(new ThrowRuntimeExceptionObj());

        InstanceMethodRunner instanceMethodRunner = new InstanceMethodRunner(objectCopier);
        instanceMethodRunner.init(null);
        assertThrows(NoSuchFieldError.class, () -> {
            instanceMethodRunner.run("toThrow");
        });
    }
}