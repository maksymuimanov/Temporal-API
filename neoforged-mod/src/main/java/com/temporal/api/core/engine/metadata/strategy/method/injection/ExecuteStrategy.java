package com.temporal.api.core.engine.metadata.strategy.method.injection;

import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.injection.Execute;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.strategy.method.MethodAnnotationStrategy;
import net.neoforged.fml.ModList;

import java.lang.reflect.Method;

@Strategy(StrategyPoolInitializer.DEFAULT_METHOD_INJECTION)
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
