package com.victoryw.refactor.test.framework.core;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectComparator {

    public void assertValueEqual(final Object obj1, final Object obj2) {
        if (obj1 == null && obj2 == null){
            return;
        }
        assertThat(obj1).isEqualToComparingFieldByFieldRecursively(obj2);
    }
}
