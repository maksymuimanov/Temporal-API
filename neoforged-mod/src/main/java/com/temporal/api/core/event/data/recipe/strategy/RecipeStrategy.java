package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.holder.RecipeHolder;
import net.minecraft.data.recipes.RecipeOutput;
import org.jetbrains.annotations.NotNull;

public interface RecipeStrategy<T extends RecipeHolder> {
    void saveRecipe(T t, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput output);
}
