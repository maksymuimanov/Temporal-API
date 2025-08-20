package com.temporal.api.core.engine.io.metadata.annotation.data.language;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SlovakTranslation {
    String id() default "";
    String value();
}