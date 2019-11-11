package com.victoryw.refactor.test.framework.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectCopierTest {
    @Test void should_copy_the_obj_to_another() {
        ObjectCopier copier = new ObjectCopier(this.getClass().getClassLoader());
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest("get",
                "/api/a");

        final Object theTargetObject = copier.copyObjectToTargetClassLoader(httpServletRequest);

        assertEquals(theTargetObject.getClass(), MockHttpServletRequest.class);
    }
}
