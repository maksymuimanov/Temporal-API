package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.description.RecipeDescription;
import net.minecraft.data.recipes.RecipeOutput;
import org.jetbrains.annotations.NotNull;

public interface RecipeStrategy<T extends RecipeDescription> {
    void saveRecipe(T description, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput output);
}
