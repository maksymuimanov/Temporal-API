package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.description.CampfireCookingRecipeDescription;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class CampfireCookingRecipeStrategy implements RecipeStrategy<CampfireCookingRecipeDescription> {
    @Override
    public void saveRecipe(CampfireCookingRecipeDescription description, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput recipeOutput) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(description.getIngredient()), description.getRecipeCategory(), description.getResult(),
                        description.getExperience(), description.getCookingTime())
                .group(description.getGroup())
                .unlockedBy(ApiRecipeProvider.getHasName(description.getIngredient()), ApiRecipeProvider.has(description.getIngredient()))
                .save(recipeOutput, IOLayer.NEO_MOD.getModId() + ":" + ApiRecipeProvider.getItemName(description.getResult()) + description.getName() + "_" + ApiRecipeProvider.getItemName(description.getIngredient()));
    }
}
