package com.temporal.api.core.engine.metadata.annotation.injection;

import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Strategy {
    String value();
    Class<? extends AnnotationStrategy> override() default AnnotationStrategy.class;
}
