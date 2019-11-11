package com.victoryw.refactor.test.framework.core;

import com.victoryw.refactor.test.framework.core.ObjectComparator;
import com.victoryw.refactor.test.framework.core.ObjectCopier;
import com.victoryw.refactor.test.framework.core.object.compare.sample.ComplexClass;
import com.victoryw.refactor.test.framework.core.object.compare.sample.SimpleClass;
import com.victoryw.refactor.test.framework.core.object.compare.sample.SimpleClassCopy;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.joor.Reflect.on;

class ObjectComparatorTest {

    private ObjectComparator objectComparator;

    @BeforeEach
    void setUp() {
        objectComparator = new ObjectComparator();
    }

    @Test
    void should_be_equal_when_the_objects_reference_to_same_address() {
        //GIVEN
        SimpleClass simpleClass = new SimpleClass(5);

        //WHEN THEN
        objectComparator.assertValueEqual(simpleClass, simpleClass);
    }

    @Test
    void should_be_equal_when_objects_contains_the_same_field_value() {
        //GIVEN
        final int innerValue = 5;
        SimpleClass simpleClass = new SimpleClass(innerValue);
        SimpleClass other = new SimpleClass(innerValue);

        //WHEN THEN
        objectComparator.assertValueEqual(simpleClass, other);
    }

    @Test
    void should_be_not_equal_when_objects_contains_the_different_field_value() {
        //GIVEN
        SimpleClass source = new SimpleClass(5);
        SimpleClass other = new SimpleClass(4);


        //When
        final Throwable throwable = catchThrowable(() -> {
            objectComparator.assertValueEqual(source, other);
        });

        //Then
        assertThat(throwable).isInstanceOf(AssertionError.class);
    }

    @Test
    void should_be_equal_when_the_objects_contains_the_same_value_and_create_by_reflect() {
        //GIVEN
        final int innerValue = 5;
        SimpleClass simpleClass = new SimpleClass(innerValue);
        final Object other = on(simpleClass.getClass()).create(innerValue).get();

        //WHEN THEN
        objectComparator.assertValueEqual(simpleClass, other);
    }

    @Test
    void should_be_equal_when_the_objects_from_the_object_copy() {
        //GIVEN
        SimpleClass simpleClass = new SimpleClass(5);
        final ObjectCopier objectCopier = new ObjectCopier(Thread.currentThread().getContextClassLoader());
        final Object other = objectCopier.copyObjectToTargetClassLoader(simpleClass);

        //WHEN THEN
        objectComparator.assertValueEqual(simpleClass, other);
    }

    @Test
    void should_be_not_equal_when_the_objects_from_different_class() {
        //GIVEN
        final int innerValue = 5;
        SimpleClass source = new SimpleClass(innerValue);
        SimpleClassCopy other = new SimpleClassCopy(innerValue);

        //WHEN THEN
        objectComparator.assertValueEqual(source, other);
    }

    @Test
    void should_be_equal_when_the_objects_contains_deep_equal_field() {
        //GIVEN
        final int value = 5;
        ComplexClass complexClass = new ComplexClass(value);
        ComplexClass other = new ComplexClass(value);

        //WHEN THEN
        objectComparator.assertValueEqual(complexClass, other);
    }

    @Test
    void should_be_not_equal_when_the_objects_contains_deep_not_equal_field() {
        //GIVEN
        ComplexClass source = new ComplexClass(5);
        ComplexClass other = new ComplexClass(4);

        //When
        final Throwable throwable = catchThrowable(() -> {
            objectComparator.assertValueEqual(source, other);
        });

        //Then
        assertThat(throwable).isInstanceOf(AssertionError.class);
    }

    @Test
    void should_be_equal_when_the_list_contain_value_equal_elements() {
        //GIVEN
        final int value = 5;
        final int innerValue = 4;
        List source = new ArrayList();
        source.add(new ComplexClass(value));
        source.add(new SimpleClass(innerValue));
        List sourceParent = Lists.newArrayList(source);

        List other = new ArrayList();
        other.add(new ComplexClass(value));
        other.add(new SimpleClass(innerValue));
        List otherParent = Lists.newArrayList(source);


        //WHEN THEN
        objectComparator.assertValueEqual(sourceParent, otherParent);
    }


    @Test
    void should_be_not_equal_when_the_list_contain_value_equal_elements() {
        //GIVEN
        final int value = 5;
        final int innerValue = 4;
        List source = new ArrayList();
        source.add(new ComplexClass(innerValue));
        source.add(new SimpleClass(value));


        List other = new ArrayList();
        other.add(new ComplexClass(value));
        other.add(new SimpleClass(innerValue));



        //When
        final Throwable throwable = catchThrowable(() -> {
            objectComparator.assertValueEqual(source, other);
        });

        //Then
        assertThat(throwable).isInstanceOf(AssertionError.class);
    }


}

