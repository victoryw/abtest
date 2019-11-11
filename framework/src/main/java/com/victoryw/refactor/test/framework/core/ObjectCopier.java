package com.victoryw.refactor.test.framework.core;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.Objects;

public class ObjectCopier {

    private final XStream xStreamFromDefaultClassLoader = new XStream();
    private final XStream xStreamFromBaseLineClassLoader = new XStream();

    public ObjectCopier(ClassLoader baseLineProjectClassLoader) {
        xStreamFromBaseLineClassLoader.registerConverter(new AppClassLoaderConverter());
        xStreamFromDefaultClassLoader.registerConverter(new AppClassLoaderConverter());
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
