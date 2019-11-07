package com.victoryw.refactor.test.framework.facade;

import org.xeustechnologies.jcl.JarClassLoader;

import java.util.Arrays;

public class BaseLineUtilityFactory {

    private static ClassLoader createClassLoader(String cbsBaseLinePath, String cbsBaseLineDependenciesPath) {
        System.setProperty("jcl.suppressMissingResourceException", String.valueOf(false));
        JarClassLoader baseLineProjectClassLoader = new JarClassLoader();

        baseLineProjectClassLoader.addAll(Arrays.asList(cbsBaseLinePath, cbsBaseLineDependenciesPath));
        return baseLineProjectClassLoader;
    }

    public static BaseLineUtilityFacade createFacade(ProjectConfigruation configuration) {
        final ClassLoader classLoader = createClassLoader(configuration.getProjectBaseLinePath(),
                configuration.getProjectBaseLineDependenciesPath());
        return new BaseLineUtilityFacade(classLoader);
    }
}
