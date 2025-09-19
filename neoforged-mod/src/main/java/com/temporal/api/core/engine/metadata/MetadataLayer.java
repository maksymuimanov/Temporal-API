package com.temporal.api.core.engine.metadata;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.metadata.consumer.AnnotationStrategyConsumer;
import com.temporal.api.core.engine.metadata.consumer.AsyncStrategyConsumer;
import com.temporal.api.core.engine.metadata.consumer.SimpleStrategyConsumer;
import com.temporal.api.core.engine.metadata.director.AnnotationDirector;
import com.temporal.api.core.engine.metadata.pool.ProcessorPool;
import com.temporal.api.core.engine.metadata.pool.SimpleProcessorPool;

import java.util.List;
import java.util.Set;

public class MetadataLayer implements EngineLayer {
    public static final AnnotationStrategyConsumer SIMPLE_STRATEGY_CONSUMER = new SimpleStrategyConsumer();
    public static final AnnotationStrategyConsumer ASYNC_STRATEGY_CONSUMER = new AsyncStrategyConsumer();
    private List<AnnotationDirector> annotationDirectors;

    @Override
    public void processAllTasks() {
        ApiMod.LOGGER.debug("Processing defaulted {} annotation directors", annotationDirectors.size());
        Set<Class<?>> classes = ModContext.NEO_MOD.getClasses();
        annotationDirectors.forEach(annotationDirector -> {
            annotationDirector.directAll(classes);
        });
        List<? extends AnnotationDirector> dynamicAnnotationDirectors = InjectionPool.getInstance().getAll(AnnotationDirector.class);
        ApiMod.LOGGER.debug("Processing dynamic {} annotation directors", dynamicAnnotationDirectors.size());
        dynamicAnnotationDirectors.forEach(annotationDirector -> {
            annotationDirector.directAll(classes);
        });
        ProcessorPool processorPool = SimpleProcessorPool.getInstance();
        processorPool.processAll();
    }

    public void setAnnotationDirectors(List<AnnotationDirector> annotationDirectors) {
        this.annotationDirectors = annotationDirectors;
    }
}
