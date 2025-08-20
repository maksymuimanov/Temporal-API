package com.temporal.api.core.engine.io.metadata.annotation.data.model;

import com.temporal.api.core.event.data.model.item.ItemModelProviderStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CustomItemModel {
    Class<? extends ItemModelProviderStrategy> value();

    String[] additionalData() default {};
}