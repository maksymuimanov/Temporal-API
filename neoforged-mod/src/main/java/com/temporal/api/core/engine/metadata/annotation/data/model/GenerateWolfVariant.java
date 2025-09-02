package com.temporal.api.core.engine.metadata.annotation.data.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateWolfVariant {
    String biomeTag();
    Class<?> biomeTagContainer() default Object.class;
}
