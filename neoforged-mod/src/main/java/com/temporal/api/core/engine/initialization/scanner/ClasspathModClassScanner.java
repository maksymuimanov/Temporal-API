package com.temporal.api.core.engine.initialization.scanner;

import com.temporal.api.core.exception.ModInfoNotFoundException;
import com.temporal.api.core.util.ReflectionUtils;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.ModFileScanData;

import java.util.Set;

public class ClasspathModClassScanner implements ModClassScanner {
    @Override
    public void getClasses(String modId, Class<?> modClass, Set<Class<?>> target) {
        ModList.get()
                .getMods()
                .stream()
                .filter(modInfo -> modInfo.getModId().equals(modId))
                .findFirst()
                .orElseThrow(() -> new ModInfoNotFoundException("Mod Info Not Found: " + modId + " " + modClass))
                .getOwningFile()
                .getFile()
                .getScanResult()
                .getClasses()
                .stream()
                .map(ModFileScanData.ClassData::clazz)
                .map(clazz -> ReflectionUtils.forType(clazz, modClass))
                .forEach(target::add);
    }
}
