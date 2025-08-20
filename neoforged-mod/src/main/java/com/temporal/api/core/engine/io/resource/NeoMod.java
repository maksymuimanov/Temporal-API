package com.temporal.api.core.engine.io.resource;

import com.google.common.base.MoreObjects;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.util.other.IOUtils;
import net.neoforged.fml.common.Mod;

import java.util.Set;

public class NeoMod {
    private String name;
    private Class<?> clazz;
    private String modId;
    private Set<Class<?>> classes;

    public NeoMod(String name, Class<?> clazz, String modId, Set<Class<?>> classes) {
        this.name = name;
        this.clazz = clazz;
        this.modId = modId;
        this.classes = classes;
    }

    public static NeoMod create(Class<?> clazz) {
        String name = clazz.getSimpleName();
        String modId = clazz.getDeclaredAnnotation(Mod.class).value();
        Set<Class<?>> classes = IOUtils.getAllClasses(modId, clazz, Injected.class);
        return new NeoMod(name, clazz, modId, classes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getModId() {
        return modId;
    }

    public void setModId(String modId) {
        this.modId = modId;
    }

    public Set<Class<?>> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class<?>> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("clazz", clazz)
                .add("modId", modId)
                .add("classes", classes)
                .toString();
    }
}
