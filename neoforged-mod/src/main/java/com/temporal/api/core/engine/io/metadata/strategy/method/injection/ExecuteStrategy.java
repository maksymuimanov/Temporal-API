package com.temporal.api.core.engine.io.metadata.strategy.method.injection;

import com.temporal.api.core.engine.io.metadata.annotation.injection.Execute;
import com.temporal.api.core.engine.io.metadata.strategy.method.MethodAnnotationStrategy;
import net.neoforged.fml.ModList;

import java.lang.reflect.Method;

public class ExecuteStrategy implements MethodAnnotationStrategy<Execute> {
    @Override
    public void execute(Method method, Object object, Execute annotation) throws Exception {
        String modCondition = annotation.mandatoryMod();
        if (modCondition.isBlank() || ModList.get().isLoaded(modCondition)) method.invoke(object);
    }

    @Override
    public Class<? extends Execute> getAnnotationClass() {
        return Execute.class;
    }
}
