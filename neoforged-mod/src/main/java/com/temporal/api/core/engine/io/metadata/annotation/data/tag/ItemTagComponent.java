package com.temporal.api.core.engine.io.metadata.annotation.data.tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ItemTagComponent {
    String[] value();
    Class<?> tagContainer() default Object.class;
}