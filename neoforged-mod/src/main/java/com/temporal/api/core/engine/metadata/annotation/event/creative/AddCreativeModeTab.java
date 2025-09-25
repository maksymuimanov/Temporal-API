package com.temporal.api.core.engine.metadata.annotation.event.creative;

import com.temporal.api.core.engine.metadata.constant.CreativeModeTabType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AddCreativeModeTab {
    CreativeModeTabType[] value();
}
