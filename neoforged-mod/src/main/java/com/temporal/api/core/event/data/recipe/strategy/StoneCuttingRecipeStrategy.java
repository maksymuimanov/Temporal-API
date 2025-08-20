package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.holder.StoneCuttingRecipeHolder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class StoneCuttingRecipeStrategy implements RecipeStrategy<StoneCuttingRecipeHolder> {
    @Override
    public void saveRecipe(StoneCuttingRecipeHolder recipeHolder, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput recipeOutput) {
        SingleItemRecipeBuilder builder = SingleItemRecipeBuilder.stonecutting(Ingredient.of(recipeHolder.getIngredient()), recipeHolder.getRecipeCategory(), recipeHolder.getResult(), recipeHolder.getCount());
        if (recipeHolder.getName() != null) {
            builder.save(recipeOutput, IOLayer.NEO_MOD.getModId() + ":" + recipeHolder.getName());
        } else {
            builder.save(recipeOutput);
        }
    }
}
