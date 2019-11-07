package com.victoryw.refactor.test.framework.facade;

import com.victoryw.refactor.test.framework.core.InstanceMethodRunner;
import com.victoryw.refactor.test.framework.core.StaticMethodRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseLineUtilityFactoryTest {

    @Test
    void createFacade() {
        //Given
        BaseLineUtilityFacade baseLineUtilityFacade = BaseLineUtilityFactory.createFacade(new TestConfiguration());
        //When
        final StaticMethodRunner staticMethodRunner = baseLineUtilityFacade.createStaticMethodRunner();
        staticMethodRunner.init("com.victoryw.baseline.code");
        Object getConfigFilePath = staticMethodRunner.run("getConfig");
        //Then
        assertEquals("./misc_base_line/app_config/", getConfigFilePath);
    }
}