package com.temporal.api.core.engine.io.metadata.annotation.event.render;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RegisterLayerDefinition {
    String layerLocationFieldName() default "LAYER_LOCATION";

    String layerDefinitionFactoryMethodName() default "createBodyLayer";
}
