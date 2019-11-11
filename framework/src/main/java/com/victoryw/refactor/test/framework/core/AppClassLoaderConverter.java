package com.victoryw.refactor.test.framework.core;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.Objects;

public class AppClassLoaderConverter implements Converter {

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        return this.getClass().getClassLoader();
    }

    @Override
    public boolean canConvert(Class type) {
        return Objects.equals(type.toString(), "class sun.misc.Launcher$AppClassLoader");
    }
}
