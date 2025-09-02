package com.temporal.api.core.engine.metadata;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.event.handler.EventHandler;
import com.temporal.api.core.engine.metadata.consumer.AnnotationStrategyConsumer;
import com.temporal.api.core.engine.metadata.consumer.AsyncStrategyConsumer;
import com.temporal.api.core.engine.metadata.consumer.SimpleStrategyConsumer;
import com.temporal.api.core.engine.metadata.executor.*;
import com.temporal.api.core.engine.metadata.processor.AnnotationProcessor;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

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
    private List<AnnotationProcessor<?>> simpleProcessors;
    private List<AnnotationProcessor<?>> asyncProcessors;

    @Override
    public void processAllTasks() {
        CommonSetupEventHandler commonSetupEventHandler = new CommonSetupEventHandler();
        commonSetupEventHandler.handle();
    }

    public void setSimpleProcessors(List<AnnotationProcessor<?>> simpleProcessors) {
        this.simpleProcessors = simpleProcessors;
    }

    public void setAsyncProcessors(List<AnnotationProcessor<?>> asyncProcessors) {
        this.asyncProcessors = asyncProcessors;
    }

    public class CommonSetupEventHandler implements EventHandler {
        @Override
        public void handle() {
            this.subscribeModEvent(FMLCommonSetupEvent.class, event -> {
                ApiMod.LOGGER.info("FMLCommonSetupEvent received for modId: {}", ModContext.NEO_MOD.getModId());
                event.enqueueWork(() -> {
                    ApiMod.LOGGER.debug("Processing {} simple annotation processors", simpleProcessors.size());
                    Set<Class<?>> classes = ModContext.NEO_MOD.getClasses();
                    simpleProcessors.forEach(annotationProcessor ->
                            annotationProcessor.process(classes, SIMPLE_STRATEGY_CONSUMER));
                    ApiMod.LOGGER.debug("Processing {} async annotation processors", asyncProcessors.size());
                    asyncProcessors.forEach(annotationProcessor ->
                            annotationProcessor.process(classes, ASYNC_STRATEGY_CONSUMER));
                });
            });
        }
    }
}
