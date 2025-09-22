package com.temporal.api.core.engine.metadata.annotation.data;

import com.temporal.api.core.engine.metadata.constant.TagContainerType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AddTagContainer {
    TagContainerType value();
}