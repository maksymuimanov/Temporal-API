package com.temporal.api.core.engine.metadata.annotation.data.model.item;

import com.temporal.api.core.engine.event.data.model.item.ItemModelProviderStrategy;
import com.temporal.api.core.engine.event.data.model.item.spec.CustomItemModelSpec;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateCustomItemModel {
    Class<? extends ItemModelProviderStrategy<CustomItemModelSpec>> strategy();

    String[] additionalData() default {};
}