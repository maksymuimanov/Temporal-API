package com.temporal.api.core.engine.io;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.EngineLayer;
import com.temporal.api.core.engine.event.handler.EventHandler;
import com.temporal.api.core.engine.io.context.*;
import com.temporal.api.core.engine.io.metadata.consumer.AnnotationStrategyConsumer;
import com.temporal.api.core.engine.io.metadata.consumer.AsyncStrategyConsumer;
import com.temporal.api.core.engine.io.metadata.consumer.SimpleStrategyConsumer;
import com.temporal.api.core.engine.io.metadata.executor.*;
import com.temporal.api.core.engine.io.metadata.processor.AnnotationProcessor;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.List;
import java.util.Set;

public class IOLayer implements EngineLayer {
    public static volatile NeoMod NEO_MOD;
    public static final AnnotationStrategyConsumer SIMPLE_STRATEGY_CONSUMER = new SimpleStrategyConsumer();
    public static final AnnotationStrategyConsumer ASYNC_STRATEGY_CONSUMER = new AsyncStrategyConsumer();
    public static final AnnotationExecutor<ClassAnnotationStrategy<?>> CLASS_EXECUTOR = new ClassExecutor();
    public static final AnnotationExecutor<FieldAnnotationStrategy<?>> FIELD_EXECUTOR = new FieldExecutor();
    public static final AnnotationExecutor<MethodAnnotationStrategy<?>> METHOD_EXECUTOR = new MethodExecutor();
    public static final AnnotationExecutor<FieldAnnotationStrategy<?>> STATIC_FIELD_EXECUTOR = new StaticFieldExecutor();
    public static final AnnotationExecutor<MethodAnnotationStrategy<?>> STATIC_METHOD_EXECUTOR = new StaticMethodExecutor();
    private Class<?> modClass;
    private List<ModClassScanner> classScanners;
    private List<ObjectPoolInitializer> objectPoolInitializers;
    private List<?> externalSource;
    private List<FactoryRegistrar> factoryRegistrars;
    private List<AnnotationProcessor<?>> simpleProcessors;
    private List<AnnotationProcessor<?>> asyncProcessors;
    private List<ObjectPoolCleaner> objectPoolCleaners;

    @Override
    public void processAllTasks() {
        ApiMod.LOGGER.info("Starting IOLayer.processAllTasks() for modClass: {}", this.modClass.getName());
        NEO_MOD = NeoMod.create(this.modClass, this.classScanners);
        String modId = NEO_MOD.getModId();
        Set<Class<?>> classes = NEO_MOD.getClasses();
        ApiMod.LOGGER.info("NeoMod dependency created: (modId={}, classes={})", modId, classes.size());
        ObjectPool objectPool = ModContext.getInstance()
                .createPool(modId);
        ApiMod.LOGGER.debug("ObjectPool created for modId: {}", modId);
        objectPoolInitializers.forEach(initializer -> {
            ApiMod.LOGGER.debug("Running defaulted ObjectPoolInitializer - {}", initializer.getClass().getName());
            initializer.initialize(objectPool, this.externalSource);
        });
        objectPool.getObjects(ObjectPoolInitializer.class).forEach(initializer -> {
            ApiMod.LOGGER.debug("Running dynamic ObjectPoolInitializer - {}", initializer.getClass().getName());
            initializer.initialize(objectPool, this.externalSource);
        });
        ApiMod.LOGGER.debug("ObjectPool is initialized for modId: {}", modId);
        IEventBus eventBus = objectPool.getObject(IEventBus.class);
        factoryRegistrars.forEach(factoryRegistrar -> {
            ApiMod.LOGGER.debug("Registering factories with {}", factoryRegistrar.getClass().getName());
            factoryRegistrar.registerFactories(eventBus);
        });
        CommonSetupEventHandler commonSetupEventHandler = new CommonSetupEventHandler(modId, classes);
        commonSetupEventHandler.handle();
        ApiMod.LOGGER.debug("Running {} ObjectPoolCleaners", objectPoolCleaners.size());
        objectPoolCleaners.forEach(ObjectPoolCleaner::clear);
        ApiMod.LOGGER.debug("Running dynamic ObjectPoolCleaners from pool");
        objectPool.getObjects(ObjectPoolCleaner.class)
                .forEach(ObjectPoolCleaner::clear);
        ApiMod.LOGGER.info("IOLayer.processAllTasks() completed for modId: {}", modId);
    }

    public void setModClass(Class<?> modClass) {
        this.modClass = modClass;
    }

    public void setClassScanners(List<ModClassScanner> classScanners) {
        this.classScanners = classScanners;
    }

    public void setContextInitializers(List<ObjectPoolInitializer> objectPoolInitializers) {
        this.objectPoolInitializers = objectPoolInitializers;
    }

    public void setExternalSource(List<?> externalSource) {
        this.externalSource = externalSource;
    }

    public void setFactoryRegistrars(List<FactoryRegistrar> factoryRegistrars) {
        this.factoryRegistrars = factoryRegistrars;
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

    public class CommonSetupEventHandler implements EventHandler {
        private final String modId;
        private final Set<Class<?>> classes;

        public CommonSetupEventHandler(String modId, Set<Class<?>> classes) {
            this.modId = modId;
            this.classes = classes;
        }

        @Override
        public void handle() {
            this.subscribeModEvent(FMLCommonSetupEvent.class, event -> {
                ApiMod.LOGGER.info("FMLCommonSetupEvent received for modId: {}", this.modId);
                event.enqueueWork(() -> {
                    ApiMod.LOGGER.debug("Processing {} simple annotation processors", simpleProcessors.size());
                    simpleProcessors.forEach(annotationProcessor ->
                            annotationProcessor.process(this.classes, SIMPLE_STRATEGY_CONSUMER));
                    ApiMod.LOGGER.debug("Processing {} async annotation processors", asyncProcessors.size());
                    asyncProcessors.forEach(annotationProcessor ->
                            annotationProcessor.process(this.classes, ASYNC_STRATEGY_CONSUMER));
                });
            });
        }
    }
}
