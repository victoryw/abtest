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
//        System.setProperty(cbsConfigFilePath, cbsRefactorConfigPath);
    }

    private static void setSystemEnvConfigToBaselineEnv(ProjectConfigruation configuration, BaseLineUtilityFacade baseLineUtilityFacade) {
//        System.setProperty(configuration.getProjectConfigFilePath(),
//                configuration.getProjectBaseLineConfigPath());
//        BaseLineUtilityFactory.loadBaseLineConfig(baseLineUtilityFacade,
//                configuration.getProjectEnvClassPath(),
//                configuration.getProjectReloadConfig());
    }

    public static BaseLineUtilityFacade createFacade(ProjectConfigruation configuration) {
        final ClassLoader classLoader = createClassLoader(configuration.getProjectBaseLinePath(),
                configuration.getProjectBaseLineDependenciesPath());
        final BaseLineUtilityFacade baseLineUtilityFacade = new BaseLineUtilityFacade(classLoader);

        setSystemEnvConfigToBaselineEnv(configuration, baseLineUtilityFacade);

        setSystemPropertiesToRefactorEnv(configuration.getProjectConfigFilePath(),
                configuration.getProjectRefactorConfigPath());

        return baseLineUtilityFacade;
    }
}
