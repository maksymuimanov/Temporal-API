package com.temporal.api.core.engine.io;

import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.io.context.ModContext;
import com.temporal.api.core.engine.io.context.ObjectPool;
import com.temporal.api.core.engine.io.context.ObjectPoolCleaner;
import com.temporal.api.core.engine.io.context.ObjectPoolInitializer;
import com.temporal.api.core.engine.io.metadata.consumer.AnnotationStrategyConsumer;
import com.temporal.api.core.engine.io.metadata.consumer.AsyncStrategyConsumer;
import com.temporal.api.core.engine.io.metadata.consumer.SimpleStrategyConsumer;
import com.temporal.api.core.engine.io.metadata.executor.*;
import com.temporal.api.core.engine.io.metadata.processor.AnnotationProcessor;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.engine.io.resource.NeoMod;

import java.util.List;

public class IOLayer implements EngineLayer {
    public static volatile NeoMod NEO_MOD;
    public static final AnnotationStrategyConsumer SIMPLE_STRATEGY_CONSUMER = new SimpleStrategyConsumer();
    public static final AnnotationStrategyConsumer ASYNC_STRATEGY_CONSUMER = new AsyncStrategyConsumer();
    public static final AnnotationExecutor<ClassAnnotationStrategy> CLASS_EXECUTOR = new ClassExecutor();
    public static final AnnotationExecutor<FieldAnnotationStrategy> FIELD_EXECUTOR = new FieldExecutor();
    public static final AnnotationExecutor<MethodAnnotationStrategy> METHOD_EXECUTOR = new MethodExecutor();
    public static final AnnotationExecutor<FieldAnnotationStrategy> STATIC_FIELD_EXECUTOR = new StaticFieldExecutor();
    public static final AnnotationExecutor<MethodAnnotationStrategy> STATIC_METHOD_EXECUTOR = new StaticMethodExecutor();
    private Class<?> modClass;
    private List<ObjectPoolInitializer> objectPoolInitializers;
    private List<?> externalSource;
    private List<AnnotationProcessor<?>> asyncProcessors;
    private List<AnnotationProcessor<?>> simpleProcessors;
    private List<ObjectPoolCleaner> objectPoolCleaners;

    @Override
    public void processAllTasks() {
        NEO_MOD = NeoMod.create(this.modClass);
        ObjectPool objectPool = ModContext.getInstance()
                .createPool(NEO_MOD.getModId());
        objectPoolInitializers.forEach(initializer -> initializer.initialize(this.externalSource));
        objectPool.getObjects(ObjectPoolInitializer.class)
                .forEach(initializer -> initializer.initialize(this.externalSource));
        simpleProcessors.forEach(annotationProcessor -> annotationProcessor.process(NEO_MOD.getClasses(), SIMPLE_STRATEGY_CONSUMER));
        asyncProcessors.forEach(annotationProcessor -> annotationProcessor.process(NEO_MOD.getClasses(), ASYNC_STRATEGY_CONSUMER));
        objectPoolCleaners.forEach(ObjectPoolCleaner::clear);
        objectPool.getObjects(ObjectPoolCleaner.class)
                .forEach(ObjectPoolCleaner::clear);
    }

    public void setModClass(Class<?> modClass) {
        this.modClass = modClass;
    }

    public void setContextInitializers(List<ObjectPoolInitializer> objectPoolInitializers) {
        this.objectPoolInitializers = objectPoolInitializers;
    }

    public void setExternalSource(List<?> externalSource) {
        this.externalSource = externalSource;
    }

    public void setSimpleProcessors(List<AnnotationProcessor<?>> simpleProcessors) {
        this.simpleProcessors = simpleProcessors;
    }

    public void setAsyncProcessors(List<AnnotationProcessor<?>> asyncProcessors) {
        this.asyncProcessors = asyncProcessors;
    }

    public void setContextCleaners(List<ObjectPoolCleaner> objectPoolCleaners) {
        this.objectPoolCleaners = objectPoolCleaners;
    }
}
