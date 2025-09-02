package com.temporal.api.core.engine.metadata.strategy.type.data;

import com.temporal.api.core.engine.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.engine.event.data.recipe.description.RecipeDescription;
import com.temporal.api.core.engine.metadata.annotation.data.RegisterRecipe;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;

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
