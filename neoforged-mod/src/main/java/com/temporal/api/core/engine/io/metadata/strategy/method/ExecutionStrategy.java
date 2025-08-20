package com.temporal.api.core.engine.io.metadata.strategy.method;

import com.temporal.api.core.engine.io.metadata.annotation.injection.Execution;
import net.neoforged.fml.ModList;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ExecutionStrategy implements MethodAnnotationStrategy {
    @Override
    public void execute(Method method, Object object) throws Exception {
        method.setAccessible(true);
        Execution execution = method.getDeclaredAnnotation(Execution.class);
        String modCondition = execution.mandatoryMod();
        if (modCondition.isBlank() || ModList.get().isLoaded(modCondition)) method.invoke(object);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return Execution.class;
    }
}
