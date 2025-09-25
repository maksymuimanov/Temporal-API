package com.temporal.api.core.engine.metadata.annotation.injection;

import com.temporal.api.core.engine.metadata.processor.AnnotationProcessor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Processor {
    String value();
    Class<? extends AnnotationProcessor> override() default AnnotationProcessor.class;
}
