package com.victoryw.refactor.test.framework.facade;

import com.victoryw.refactor.test.framework.core.StaticMethodRunner;
import org.xeustechnologies.jcl.JarClassLoader;

import java.util.Arrays;

public class BaseLineUtilityFactory {
    private static void loadBaseLineConfig(BaseLineUtilityFacade baseLineUtilityFacade, String cbsEnvClassPath, String cbsReloadConfig) {
        final StaticMethodRunner staticMethodRunner = baseLineUtilityFacade.createStaticMethodRunner();
        staticMethodRunner.init(cbsEnvClassPath);
        staticMethodRunner.run(cbsReloadConfig);
    }

    private static ClassLoader createClassLoader(String cbsBaseLinePath, String cbsBaseLineDependenciesPath) {
        JarClassLoader baseLineProjectClassLoader = new JarClassLoader();
        baseLineProjectClassLoader.addAll(Arrays.asList(cbsBaseLinePath, cbsBaseLineDependenciesPath));
        return baseLineProjectClassLoader;
    }

    private static void setSystemPropertiesToRefactorEnv(String cbsConfigFilePath, String cbsRefactorConfigPath) {
        System.setProperty(cbsConfigFilePath, cbsRefactorConfigPath);
    }

    private static void setSystemEnvConfigToBaselineEnv(CbsConfigruation configuration, BaseLineUtilityFacade baseLineUtilityFacade) {
        System.setProperty(configuration.getCbsConfigFilePath(),
                configuration.getCbsBaseLineConfigPath());
        BaseLineUtilityFactory.loadBaseLineConfig(baseLineUtilityFacade,
                configuration.getCbsEnvClassPath(),
                configuration.getCbsReloadConfig());
    }

    public static BaseLineUtilityFacade createFacade(CbsConfigruation configuration) {
        final ClassLoader classLoader = createClassLoader(configuration.getCbsBaseLinePath(),
                configuration.getCbsBaseLineDependenciesPath());
        final BaseLineUtilityFacade baseLineUtilityFacade = new BaseLineUtilityFacade(classLoader);

        setSystemEnvConfigToBaselineEnv(configuration, baseLineUtilityFacade);

        setSystemPropertiesToRefactorEnv(configuration.getCbsConfigFilePath(),
                configuration.getCbsRefactorConfigPath());

        return baseLineUtilityFacade;
    }
}
