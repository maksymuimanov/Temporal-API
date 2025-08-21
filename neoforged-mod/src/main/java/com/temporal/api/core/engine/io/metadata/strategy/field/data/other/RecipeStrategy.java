package com.temporal.api.core.engine.io.metadata.strategy.field.data.other;

import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.holder.RecipeHolder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class RecipeStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        GenerateRecipe annotation = field.getDeclaredAnnotation(GenerateRecipe.class);
        for (Class<? extends RecipeHolder> clazz : annotation.value()) {
            ApiRecipeProvider.RECIPES.add(clazz.getConstructor().newInstance());
        }
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return GenerateRecipe.class;
    }
}
