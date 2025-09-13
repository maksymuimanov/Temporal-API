package com.temporal.api.core.engine.metadata;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.consumer.AnnotationStrategyConsumer;
import com.temporal.api.core.engine.metadata.consumer.AsyncStrategyConsumer;
import com.temporal.api.core.engine.metadata.consumer.SimpleStrategyConsumer;
import com.temporal.api.core.engine.metadata.executor.*;
import com.temporal.api.core.engine.metadata.processor.AnnotationProcessor;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;

import java.util.List;
import java.util.Set;

public class MetadataLayer implements EngineLayer {
    public static final AnnotationStrategyConsumer SIMPLE_STRATEGY_CONSUMER = new SimpleStrategyConsumer();
    public static final AnnotationStrategyConsumer ASYNC_STRATEGY_CONSUMER = new AsyncStrategyConsumer();
    public static final AnnotationExecutor<ClassAnnotationStrategy<?>> CLASS_EXECUTOR = new ClassExecutor();
    public static final AnnotationExecutor<FieldAnnotationStrategy<?>> FIELD_EXECUTOR = new FieldExecutor();
    public static final AnnotationExecutor<MethodAnnotationStrategy<?>> METHOD_EXECUTOR = new MethodExecutor();
    public static final AnnotationExecutor<FieldAnnotationStrategy<?>> STATIC_FIELD_EXECUTOR = new StaticFieldExecutor();
    public static final AnnotationExecutor<MethodAnnotationStrategy<?>> STATIC_METHOD_EXECUTOR = new StaticMethodExecutor();
    private List<AnnotationProcessor> annotationProcessors;

    @Override
    public void processAllTasks() {
        ApiMod.LOGGER.debug("Processing defaulted {} annotation processors", annotationProcessors.size());
        Set<Class<?>> classes = ModContext.NEO_MOD.getClasses();
        annotationProcessors.forEach(annotationProcessor -> {
            annotationProcessor.process(classes);
        });
        List<? extends AnnotationProcessor> dynamicAnnotationProcessors = InjectionPool.getInstance().getAll(AnnotationProcessor.class);
        ApiMod.LOGGER.debug("Processing dynamic {} annotation processors", dynamicAnnotationProcessors.size());
        dynamicAnnotationProcessors.forEach(annotationProcessor -> {
            annotationProcessor.process(classes);
        });
    }

    public void setAnnotationProcessors(List<AnnotationProcessor> annotationProcessors) {
        this.annotationProcessors = annotationProcessors;
    }
}
