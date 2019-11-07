package com.victoryw.refactor.test.framework.facade;

import com.victoryw.ab.test.Sample;
import com.victoryw.refactor.test.framework.core.StaticMethodRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseLineUtilityFactoryTest {

    @Test
    void createFacadeNoDeps() {
        //Given
        BaseLineUtilityFacade baseLineUtilityFacade = BaseLineUtilityFactory.createFacade(new TestConfiguration());
        //When
        final StaticMethodRunner staticMethodRunner = baseLineUtilityFacade.createStaticMethodRunner();
        staticMethodRunner.init("com.victoryw.ab.test.Sample");
        Object baseLineResult = staticMethodRunner.run("example1");
        final String refactorResult = Sample.example1();

        //Then
        assertEquals("baseline", baseLineResult);
        assertEquals("refactor", refactorResult);
    }

    @Test
    void createFacadeDeps() {
        //Given
        BaseLineUtilityFacade baseLineUtilityFacade = BaseLineUtilityFactory.createFacade(new TestConfiguration());
        //When
        final StaticMethodRunner staticMethodRunner = baseLineUtilityFacade.createStaticMethodRunner();
        staticMethodRunner.init("com.victoryw.ab.test.Sample");
        Object baseLineResult = staticMethodRunner.run("example2");
        //Then
        assertEquals("21_baseline", baseLineResult);
    }
}