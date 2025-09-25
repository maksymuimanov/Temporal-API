package com.temporal.api.core.engine.metadata.strategy.method.injection;

import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.injection.Execute;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.InjectionAnnotationProcessor;
import com.temporal.api.core.engine.metadata.strategy.method.MethodAnnotationStrategy;
import net.neoforged.fml.ModList;

import java.lang.reflect.Method;

@Strategy(StrategyPoolInitializer.DEFAULT_METHOD_INJECTION)
public class ExecuteStrategy implements MethodAnnotationStrategy<Execute> {
    @Override
    public void execute(Method method, Object object, Execute annotation) throws Exception {
        String modCondition = annotation.mod();
        if (modCondition.isBlank() || ModList.get().isLoaded(modCondition)) method.invoke(object);
    }

    @Override
    public Class<Execute> getAnnotationClass() {
        return Execute.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(InjectionAnnotationProcessor.NAME);
    }
}
