package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;
import com.temporal.api.core.engine.metadata.pool.StrategyScope;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.util.List;

public class StrategyPoolInitializer implements ObjectPoolInitializer {
    public static final String DEFAULT_CLASS_INJECTION = "default_class_injection";
    public static final String DEFAULT_CLASS_EVENT_LAYER = "default_class_event_layer";
    public static final String DEFAULT_CLASS_DATA = "default_class_data";
    public static final String DEFAULT_FIELD_INJECTION = "default_field_injection";
    public static final String DEFAULT_FIELD_EVENT_BLOCK = "default_field_event_block";
    public static final String DEFAULT_FIELD_EVENT_CREATIVE = "default_field_event_creative";
    public static final String DEFAULT_FIELD_EVENT_FML = "default_field_event_fml";
    public static final String DEFAULT_FIELD_EVENT_RENDERER = "default_field_event_renderer";
    public static final String DEFAULT_FIELD_DATA = "default_field_data";
    public static final String DEFAULT_METHOD_INJECTION = "default_method_injection";
    public static final String DEFAULT_METHOD_EVENT_ATTRIBUTES = "default_method_event_attributes";
    public static final String DEFAULT_METHOD_DATA = "default_method_data";

    @Override
    @SuppressWarnings("unchecked")
    public void initialize(Iterable<Class<?>> classes, List<?> externalObjects, ObjectPool objectPool) {
        StrategyPool strategyPool = new SimpleStrategyPool();
        classes.forEach(clazz -> {
                    if (!clazz.isAnnotationPresent(Strategy.class)) return;
                    Strategy annotation = clazz.getDeclaredAnnotation(Strategy.class);
                    StrategyScope scope = new StrategyScope(annotation.value());
                    if (!Annotation.class.equals(annotation.override())) {
                        strategyPool.removeStrategy(annotation.override());
                    }
                    strategyPool.putStrategy(scope, (Class<? extends AnnotationStrategy<?, ?>>) clazz);
                });
        objectPool.put(strategyPool);
    }
}
