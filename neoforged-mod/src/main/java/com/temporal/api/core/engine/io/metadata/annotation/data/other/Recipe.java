package com.temporal.api.core.engine.io.metadata.annotation.data.other;

import com.temporal.api.core.event.data.recipe.holder.RecipeHolder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Recipe {
    Class<? extends RecipeHolder>[] value() default {};
}