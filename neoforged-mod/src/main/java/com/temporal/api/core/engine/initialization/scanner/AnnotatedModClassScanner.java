package com.temporal.api.core.engine.initialization.scanner;

import com.temporal.api.core.engine.metadata.annotation.injection.Handler;
import com.temporal.api.core.engine.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

import java.util.Set;

public class AnnotatedModClassScanner implements ModClassScanner {
    @Override
    public void getClasses(String modId, Class<?> modClass, Set<Class<?>> target) {
        ModList.get()
                .getModFileById(modId)
                .getFile()
                .getScanResult()
                .getAnnotations()
                .stream()
                .filter(annotation -> {
                    Type annotationType = annotation.annotationType();
                    return annotationType.equals(Type.getType(Injected.class))
                            || annotationType.equals(Type.getType(Strategy.class))
                            || annotationType.equals(Type.getType(Handler.class));
                })
                .map(ModFileScanData.AnnotationData::clazz)
                .map(clazz -> ReflectionUtils.forType(clazz, modClass))
                .forEach(target::add);
    }
}
