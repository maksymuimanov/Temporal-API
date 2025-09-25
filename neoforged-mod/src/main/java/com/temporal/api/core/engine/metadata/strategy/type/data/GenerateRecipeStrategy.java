package com.temporal.api.core.engine.metadata.strategy.type.data;

import com.temporal.api.core.engine.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.engine.event.data.recipe.description.RecipeDescription;
import com.temporal.api.core.engine.initialization.initializer.StrategyPoolInitializer;
import com.temporal.api.core.engine.metadata.annotation.data.GenerateRecipe;
import com.temporal.api.core.engine.metadata.annotation.injection.Strategy;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.type.ClassAnnotationStrategy;

import java.lang.reflect.Constructor;

@Strategy(StrategyPoolInitializer.DEFAULT_CLASS_DATA)
public class GenerateRecipeStrategy implements ClassAnnotationStrategy<GenerateRecipe> {
    @Override
    public void execute(Class<?> clazz, Object object, GenerateRecipe annotation) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        RecipeDescription recipeDescription = (RecipeDescription) constructor.newInstance();
        ApiRecipeProvider.RECIPES.add(recipeDescription);
    }

    @Override
    public Class<GenerateRecipe> getAnnotationClass() {
        return GenerateRecipe.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
