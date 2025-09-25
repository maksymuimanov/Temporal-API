package com.temporal.api.core.engine.metadata.pool;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.metadata.processor.AnnotationProcessor;
import com.temporal.api.core.engine.metadata.processor.StrategySpec;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleProcessorPool implements ProcessorPool {
    private final Map<ProcessorScope, AnnotationProcessor> processors;

    public SimpleProcessorPool() {
        this.processors = new LinkedHashMap<>();
    }

    @Override
    public <T extends AnnotationProcessor> T get(String name) {
        ProcessorScope scope = new ProcessorScope(name);
        return this.get(scope);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends AnnotationProcessor> T get(ProcessorScope scope) {
        return (T) processors.get(scope);
    }

    @Override
    public void processAll() {
        this.processors.forEach((scope, annotationProcessor) -> {
            annotationProcessor.process();
        });
    }

    @Override
    public <T> void subscribe(AnnotationStrategy<T, ?> strategy, T type) {
        StrategySpec<T> strategySpec = new StrategySpec<>(strategy, type);
        this.subscribe(strategySpec);
    }

    @Override
    public <T> void subscribe(StrategySpec<T> strategySpec) {
        ProcessorScope scope = strategySpec.strategy().getProcessorScope();
        AnnotationProcessor annotationProcessor = this.get(scope);
        annotationProcessor.subscribe(strategySpec);
    }

    @Override
    public void put(ProcessorScope scope, Class<? extends AnnotationProcessor> processorClass) {
        AnnotationProcessor processor = ReflectionUtils.createObject(processorClass);
        this.put(scope, processor);
    }

    @Override
    public void put(ProcessorScope scope, AnnotationProcessor processor) {
        this.processors.put(scope, processor);
    }

    @Override
    public void override(ProcessorScope scope, Class<? extends AnnotationProcessor> to) {
        AnnotationProcessor processor = ReflectionUtils.createObject(to);
        this.override(scope, processor);
    }

    @Override
    public void override(ProcessorScope scope, AnnotationProcessor to) {
        this.remove(scope);
        this.put(scope, to);
    }

    @Override
    public void remove(ProcessorScope processorScope) {
        this.processors.remove(processorScope);
    }

    @Override
    public boolean contains(String name) {
        ProcessorScope scope = new ProcessorScope(name);
        return this.contains(scope);
    }

    @Override
    public boolean contains(ProcessorScope scope) {
        return this.processors.containsKey(scope);
    }

    @Override
    public @NotNull Iterator<AnnotationProcessor> iterator() {
        return this.processors.values().iterator();
    }

    public static SimpleProcessorPool getInstance() {
        return InjectionPool.getFromInstance(SimpleProcessorPool.class);
    }
}
