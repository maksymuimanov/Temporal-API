package com.temporal.api.core.engine.io.metadata.strategy.type.data;

import com.temporal.api.core.engine.io.metadata.annotation.data.RegisterRecipe;
import com.temporal.api.core.engine.io.metadata.strategy.type.ClassAnnotationStrategy;
import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.description.RecipeDescription;

import java.lang.reflect.Constructor;

public class RegisterRecipeStrategy implements ClassAnnotationStrategy<RegisterRecipe> {
    @Override
    public void execute(Class<?> clazz, Object object, RegisterRecipe annotation) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        RecipeDescription recipeDescription = (RecipeDescription) constructor.newInstance();
        ApiRecipeProvider.RECIPES.add(recipeDescription);
    }

    @Override
    public Class<? extends RegisterRecipe> getAnnotationClass() {
        return RegisterRecipe.class;
    }
}
