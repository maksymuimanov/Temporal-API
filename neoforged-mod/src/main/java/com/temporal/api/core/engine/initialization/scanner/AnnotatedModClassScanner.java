package com.temporal.api.core.engine.initialization.scanner;

import com.temporal.api.core.engine.metadata.annotation.injection.Injected;
import com.temporal.api.core.exception.ModInfoNotFoundException;
import com.temporal.api.core.util.ReflectionUtils;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

import java.util.Set;

public class AnnotatedModClassScanner implements ModClassScanner {
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
                .getAnnotations()
                .stream()
                .filter(annotation -> annotation.annotationType().equals(Type.getType(Injected.class)))
                .map(ModFileScanData.AnnotationData::clazz)
                .map(clazz -> ReflectionUtils.forType(clazz, modClass))
                .forEach(target::add);
    }
}
