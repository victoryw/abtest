package com.victoryw.refactor.test.framework.facade;

import com.victoryw.refactor.test.framework.core.InstanceMethodRunner;
import com.victoryw.refactor.test.framework.core.ObjectComparator;
import com.victoryw.refactor.test.framework.core.ObjectCopier;
import com.victoryw.refactor.test.framework.core.StaticMethodRunner;


public class BaseLineUtilityFacade {
    private ClassLoader baseLineProjectClassLoader;
    private ObjectCopier copier;

    BaseLineUtilityFacade(ClassLoader classLoader) {

        this.baseLineProjectClassLoader = classLoader;

        this.copier = new ObjectCopier(baseLineProjectClassLoader);
    }

    public InstanceMethodRunner createInstanceMethodRunner() {
        return new InstanceMethodRunner(copier);
    }

    public StaticMethodRunner createStaticMethodRunner() {
        return new StaticMethodRunner(this.baseLineProjectClassLoader);
    }

    public ObjectComparator createObjectComparator() {
        return new ObjectComparator();
    }

}
