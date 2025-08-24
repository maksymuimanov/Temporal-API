package com.temporal.api.core.engine.io.metadata.annotation.event;

import com.temporal.api.core.engine.io.metadata.constant.CreativeModeTabType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AddCreativeModeTab {
    CreativeModeTabType[] value();
}
