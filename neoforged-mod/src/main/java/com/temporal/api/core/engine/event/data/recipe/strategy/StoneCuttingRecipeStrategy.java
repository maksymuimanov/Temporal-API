package com.temporal.api.core.engine.event.data.recipe.strategy;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.engine.event.data.recipe.description.StoneCuttingRecipeDescription;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class StoneCuttingRecipeStrategy implements RecipeStrategy<StoneCuttingRecipeDescription> {
    @Override
    public void saveRecipe(StoneCuttingRecipeDescription description, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput recipeOutput) {
        SingleItemRecipeBuilder builder = SingleItemRecipeBuilder.stonecutting(Ingredient.of(description.getIngredient()), description.getRecipeCategory(), description.getResult(), description.getCount());
        if (description.getName() != null) {
            builder.save(recipeOutput, ModContext.NEO_MOD.getModId() + ":" + description.getName());
        } else {
            builder.save(recipeOutput);
        }
    }
}
