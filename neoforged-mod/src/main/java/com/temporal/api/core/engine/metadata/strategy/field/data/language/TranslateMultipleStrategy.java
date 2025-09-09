package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateMultiple;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.SimpleStrategyPool;
import com.temporal.api.core.engine.metadata.pool.StrategyPool;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateMultipleStrategy implements FieldAnnotationStrategy<TranslateMultiple> {
    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void execute(Field field, Object object, TranslateMultiple annotation) throws Exception {
        Class<? extends TranslateMultiple> annotationClass = annotation.getClass();
        StrategyPool strategyPool = SimpleStrategyPool.getInstance();
        Method[] methods = annotationClass.getDeclaredMethods();
        for (Method method : methods) {
            if (!method.getReturnType().isArray()) continue;
            Annotation[] languageAnnotations = (Annotation[]) method.invoke(annotation);
            for (Annotation languageAnnotation : languageAnnotations) {
                FieldAnnotationStrategy strategy = strategyPool.getStrategy(languageAnnotation.annotationType());
                strategy.execute(field, object, languageAnnotation);
            }
        }
    }

    @Override
    public Class<? extends TranslateMultiple> getAnnotationClass() {
        return TranslateMultiple.class;
    }
}
