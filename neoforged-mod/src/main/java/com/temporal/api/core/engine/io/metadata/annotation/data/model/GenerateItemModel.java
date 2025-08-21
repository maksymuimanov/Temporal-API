package com.temporal.api.core.engine.io.metadata.annotation.data.model;

import com.temporal.api.core.engine.io.metadata.constant.ItemModelType;
import com.temporal.api.core.event.data.model.item.ItemModelProviderStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateItemModel {
    ItemModelType value() default ItemModelType.BASIC;

    String[] additionalData() default {};

    Class<? extends ItemModelProviderStrategy> custom() default ItemModelProviderStrategy.class;
}