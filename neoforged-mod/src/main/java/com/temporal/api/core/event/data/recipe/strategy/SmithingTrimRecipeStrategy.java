package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.holder.SmithingTrimRecipeHolder;
import com.temporal.api.core.util.other.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SmithingTrimRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SmithingTrimRecipeStrategy implements RecipeStrategy<SmithingTrimRecipeHolder> {
    @Override
    public void saveRecipe(SmithingTrimRecipeHolder recipeHolder, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput recipeOutput) {
        Ingredient base = recipeHolder.getBaseTag() != null
                ? recipeProvider.tag(recipeHolder.getBaseTag())
                : Ingredient.of(recipeHolder.getBases());
        Ingredient addition = recipeHolder.getAdditionTag() != null
                ? recipeProvider.tag(recipeHolder.getAdditionTag())
                : Ingredient.of(recipeHolder.getAdditions());
        SmithingTrimRecipeBuilder builder = SmithingTrimRecipeBuilder.smithingTrim(Ingredient.of(recipeHolder.getTemplates()), base, addition, recipeHolder.getRecipeCategory());
        for (ItemLike template : recipeHolder.getTemplates()) {
            builder.unlocks("has_smithing_trim_template", ApiRecipeProvider.has(template));
        }
        String path;
        if (recipeHolder.getName() != null) {
            path = recipeHolder.getName();
        } else {
            path = UUID.randomUUID() + "_trim_recipe";
        }

        ResourceKey<Recipe<?>> resourceKey = ResourceUtils.createKey(Registries.RECIPE, path);
        builder.save(recipeOutput, resourceKey.location());
    }
}
