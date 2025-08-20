package com.temporal.api.core.engine.io.metadata.annotation.injection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Injected {
    boolean value() default true;
    boolean isInjection() default true;
    String mandatoryMod() default "";
}
