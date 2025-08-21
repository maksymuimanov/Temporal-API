package com.temporal.api.core.engine.io.metadata.annotation.data;

import com.temporal.api.core.engine.io.metadata.constant.TagContainerType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RegisterTagContainer {
    TagContainerType value();
}