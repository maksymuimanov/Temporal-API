package com.temporal.api.core.engine.io.metadata.strategy.field.data.other;

import com.temporal.api.core.engine.io.metadata.annotation.data.other.Recipe;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.holder.RecipeHolder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class RecipeStrategy implements FieldAnnotationStrategy {
    @Override
    public void execute(Field field, Object object) throws Exception {
        field.setAccessible(true);
        Recipe recipe = field.getDeclaredAnnotation(Recipe.class);
        for (Class<? extends RecipeHolder> clazz : recipe.value()) {
            ApiRecipeProvider.RECIPES.add(clazz.getConstructor().newInstance());
        }
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return Recipe.class;
    }
}
