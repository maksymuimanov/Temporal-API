package com.temporal.api.core.engine.io.metadata.strategy.type.data.defined;

import com.temporal.api.core.engine.io.metadata.annotation.data.defined.DefinedRecipe;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.holder.RecipeHolder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

public class DefinedRecipeStrategy implements ClassAnnotationStrategy {
    @Override
    public void execute(Class<?> clazz, Object object) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        RecipeHolder recipeHolder = (RecipeHolder) constructor.newInstance();
        ApiRecipeProvider.RECIPES.add(recipeHolder);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return DefinedRecipe.class;
    }
}
