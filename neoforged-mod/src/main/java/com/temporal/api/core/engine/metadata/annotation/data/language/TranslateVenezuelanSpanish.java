package com.temporal.api.core.engine.metadata.annotation.data.language;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TranslateVenezuelanSpanish {
    String id() default "";
    String value();
}