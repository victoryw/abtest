package com.victoryw.refactor.test.framework.core;

import com.thoughtworks.xstream.XStream;

public class ObjectCopier {

    private final XStream xStreamFromDefaultClassLoader = new XStream();
    private final XStream xStreamFromBaseLineClassLoader = new XStream();

    public ObjectCopier(ClassLoader baseLineProjectClassLoader) {
        xStreamFromBaseLineClassLoader.setClassLoader(baseLineProjectClassLoader);
    }


    Object copyObjectToTargetClassLoader(final Object source) {
        String obj = xStreamFromDefaultClassLoader.toXML(source);
        return xStreamFromBaseLineClassLoader.fromXML(obj);
    }

    Object copyObjectToCurrentClassLoader(final Object source) {
        String obj = xStreamFromBaseLineClassLoader.toXML(source);
        return xStreamFromDefaultClassLoader.fromXML(obj);
    }
}
