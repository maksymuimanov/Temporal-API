package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.description.ShapelessRecipeDescription;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import org.jetbrains.annotations.NotNull;

public class ShapelessRecipeStrategy implements RecipeStrategy<ShapelessRecipeDescription> {
    @Override
    public void saveRecipe(ShapelessRecipeDescription description, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(description.getRecipeCategory(), description.getResult(), description.getCount());
        for (var entry : description.getItemAndCountMap().entrySet()) builder = builder.requires(entry.getKey(), entry.getValue())
                .unlockedBy(ApiRecipeProvider.getHasName(entry.getKey()), ApiRecipeProvider.has(entry.getKey()));
        if (description.getName() != null) {
            builder.save(recipeOutput, IOLayer.NEO_MOD.getModId() + ":" + description.getName());
        } else {
            builder.save(recipeOutput);
        }
    }
}
