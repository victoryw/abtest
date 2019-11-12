package com.victoryw.refactor.test.framework.facade;

import com.victoryw.ab.test.Sample;
import com.victoryw.refactor.test.framework.core.InstanceMethodRunner;
import com.victoryw.refactor.test.framework.core.StaticMethodRunner;
import org.junit.jupiter.api.Test;
import org.xeustechnologies.jcl.exception.JclException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void createFacadeInstanceMethod() throws Throwable {
        //Given
        BaseLineUtilityFacade baseLineUtilityFacade = BaseLineUtilityFactory.createFacade(new TestConfiguration());
        //When
        Sample sample = new Sample();
        final InstanceMethodRunner instanceMethodRunner = baseLineUtilityFacade.createInstanceMethodRunner();
        //Then
        instanceMethodRunner.init(sample);
        assertEquals("baseline", instanceMethodRunner.run("example"));
        assertEquals("refactor", sample.example());
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

    @Test
    void should_throw_exception_when_jar_missing() {
        //Given
        final TestConfiguration configuration = new TestConfiguration();
        configuration.setBaseLineJarPath("./error/path");
        final JclException jclException = assertThrows(JclException.class, () -> {
            BaseLineUtilityFacade baseLineUtilityFacade = BaseLineUtilityFactory.createFacade(configuration);
        });
        assertEquals(jclException.getMessage(), "File/Path does not exist");
    }

    @Test
    void should_throw_exception_when_dependency_path_missing() {
        //Given
        final TestConfiguration configuration = new TestConfiguration();
        configuration.setBaseLineDependencePath("./error/path");
        final JclException jclException = assertThrows(JclException.class, () -> {
            BaseLineUtilityFacade baseLineUtilityFacade = BaseLineUtilityFactory.createFacade(configuration);
        });
        assertEquals(jclException.getMessage(), "File/Path does not exist");
    }
}