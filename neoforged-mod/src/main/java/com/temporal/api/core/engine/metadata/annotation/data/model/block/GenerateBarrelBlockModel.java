package com.temporal.api.core.engine.metadata.annotation.data.model.block;

import com.temporal.api.core.engine.event.data.model.RenderTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateBarrelBlockModel {
    String renderType() default RenderTypes.SOLID;
}