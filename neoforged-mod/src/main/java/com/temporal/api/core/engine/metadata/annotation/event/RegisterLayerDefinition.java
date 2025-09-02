package com.temporal.api.core.engine.metadata.annotation.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RegisterLayerDefinition {
    String fieldName() default "LAYER_LOCATION";

    String factoryMethodName() default "createBodyLayer";
}
