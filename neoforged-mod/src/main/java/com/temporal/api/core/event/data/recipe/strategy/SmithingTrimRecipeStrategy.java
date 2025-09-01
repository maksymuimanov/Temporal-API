package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.description.SmithingTrimRecipeDescription;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SmithingTrimRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SmithingTrimRecipeStrategy implements RecipeStrategy<SmithingTrimRecipeDescription> {
    @Override
    public void saveRecipe(SmithingTrimRecipeDescription description, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput recipeOutput) {
        Ingredient base = description.getBaseTag() != null
                ? recipeProvider.tag(description.getBaseTag())
                : Ingredient.of(description.getBases());
        Ingredient addition = description.getAdditionTag() != null
                ? recipeProvider.tag(description.getAdditionTag())
                : Ingredient.of(description.getAdditions());
        SmithingTrimRecipeBuilder builder = SmithingTrimRecipeBuilder.smithingTrim(Ingredient.of(description.getTemplates()), base, addition, description.getRecipeCategory());
        for (ItemLike template : description.getTemplates()) {
            builder.unlocks("has_smithing_trim_template", ApiRecipeProvider.has(template));
        }
        String path;
        if (description.getName() != null) {
            path = description.getName();
        } else {
            path = UUID.randomUUID() + "_trim_recipe";
        }

        ResourceKey<Recipe<?>> resourceKey = ResourceUtils.createKey(Registries.RECIPE, path);
        builder.save(recipeOutput, resourceKey.location());
    }
}
