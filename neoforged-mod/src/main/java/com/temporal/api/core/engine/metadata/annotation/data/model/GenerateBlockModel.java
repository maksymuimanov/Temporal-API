package com.temporal.api.core.engine.metadata.annotation.data.model;

import com.temporal.api.core.engine.event.data.model.block.BlockModelProviderStrategy;
import com.temporal.api.core.engine.metadata.constant.BlockModelType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateBlockModel {
    BlockModelType value() default BlockModelType.CUBED;

    String[] additionalData() default {};

    Class<? extends BlockModelProviderStrategy> custom() default BlockModelProviderStrategy.class;
}