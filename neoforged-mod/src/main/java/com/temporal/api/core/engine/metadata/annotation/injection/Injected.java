package com.temporal.api.core.engine.metadata.annotation.injection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Injected {
    String value() default "";
    boolean isContextObject() default true;
    String mandatoryMod() default "";
}
