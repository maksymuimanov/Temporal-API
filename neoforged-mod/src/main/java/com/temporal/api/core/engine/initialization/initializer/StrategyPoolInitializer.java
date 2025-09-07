package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;
import com.temporal.api.core.engine.metadata.pool.StrategyScope;
import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.method.MethodAnnotationStrategy;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;

import java.util.List;
import java.util.Set;

public class StrategyPoolInitializer implements ObjectPoolInitializer {
    public static final String ROOT_PACKAGE = "com.temporal.api.core.engine.metadata.strategy";
    public static final String CLASS_PACKAGE = ROOT_PACKAGE + ".type";
    public static final String FIELD_PACKAGE = ROOT_PACKAGE + ".field";
    public static final String METHOD_PACKAGE = ROOT_PACKAGE + ".method";
    public static final String INJECTION_SUFFIX = ".injection";
    public static final String EVENT_SUFFIX = ".event";
    public static final String DATA_SUFFIX = ".data";
    public static final String DEFAULT_CLASS_EVENT = "default_class_event";
    public static final String DEFAULT_CLASS_DATA = "default_class_data";
    public static final String DEFAULT_FIELD_INJECTION = "default_field_injection";
    public static final String DEFAULT_FIELD_EVENT = "default_field_event";
    public static final String DEFAULT_FIELD_DATA = "default_field_data";
    public static final String DEFAULT_METHOD_INJECTION = "default_method_injection";
    public static final String DEFAULT_METHOD_EVENT = "default_method_event";

    @Override
    @SuppressWarnings("unchecked")
    public void initialize(ObjectPool objectPool, List<?> externalObjects) {
        StrategyPool strategyPool = new SimpleStrategyPool();
        this.putStrategies(CLASS_PACKAGE + EVENT_SUFFIX, ClassAnnotationStrategy.class, strategyPool, DEFAULT_CLASS_EVENT);
        this.putStrategies(CLASS_PACKAGE + DATA_SUFFIX, ClassAnnotationStrategy.class, strategyPool, DEFAULT_CLASS_DATA);
        this.putStrategies(FIELD_PACKAGE + INJECTION_SUFFIX, FieldAnnotationStrategy.class, strategyPool, DEFAULT_FIELD_INJECTION);
        this.putStrategies(FIELD_PACKAGE + EVENT_SUFFIX, FieldAnnotationStrategy.class, strategyPool, DEFAULT_FIELD_EVENT);
        this.putStrategies(FIELD_PACKAGE + DATA_SUFFIX, FieldAnnotationStrategy.class, strategyPool, DEFAULT_FIELD_DATA);
        this.putStrategies(METHOD_PACKAGE + INJECTION_SUFFIX, MethodAnnotationStrategy.class, strategyPool, DEFAULT_METHOD_INJECTION);
        this.putStrategies(METHOD_PACKAGE + EVENT_SUFFIX, MethodAnnotationStrategy.class, strategyPool, DEFAULT_METHOD_EVENT);
        ModContext.NEO_MOD.getClasses()
                .forEach(clazz -> {
                    if (!clazz.isAnnotationPresent(Strategy.class)) return;
                    Strategy annotation = clazz.getDeclaredAnnotation(Strategy.class);
                    StrategyScope scope = new StrategyScope(annotation.value());
                    strategyPool.putStrategy(scope, (Class<? extends AnnotationStrategy<?, ?>>) clazz);
                });
        objectPool.putObject(strategyPool);
    }

    private <T extends AnnotationStrategy<?, ?>> void putStrategies(String packageName, Class<T> clazz, StrategyPool strategyPool, String scopeName) {
        this.getStrategies(packageName,  clazz).forEach(strategy -> {
            strategyPool.putStrategy(new StrategyScope(scopeName), strategy);
        });
    }

    private Set<? extends AnnotationStrategy<?, ?>> getStrategies(String packageName, Class<? extends AnnotationStrategy<?, ?>> parentClass) {
        return ReflectionUtils.getSubclassFamily(ApiMod.MOD_ID, ApiMod.class, packageName, parentClass);
    }
}
