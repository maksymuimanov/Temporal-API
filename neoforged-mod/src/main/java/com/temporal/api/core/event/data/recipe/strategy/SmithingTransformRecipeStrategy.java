package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.holder.SmithingTransformRecipeHolder;
import com.temporal.api.core.util.other.RegistryUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public class SmithingTransformRecipeStrategy implements RecipeStrategy<SmithingTransformRecipeHolder> {
    @Override
    public void saveRecipe(SmithingTransformRecipeHolder recipeHolder, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput recipeOutput) {
        Ingredient base = recipeHolder.getBaseTag() != null
                ? recipeProvider.tag(recipeHolder.getBaseTag())
                : Ingredient.of(recipeHolder.getBases());
        Ingredient addition = recipeHolder.getAdditionTag() != null
                ? recipeProvider.tag(recipeHolder.getAdditionTag())
                : Ingredient.of(recipeHolder.getAdditions());
        SmithingTransformRecipeBuilder builder = SmithingTransformRecipeBuilder.smithing(Ingredient.of(recipeHolder.getTemplates()), base, addition, recipeHolder.getRecipeCategory(), recipeHolder.getResult().asItem());
        for (ItemLike item : recipeHolder.getAdditions())
            builder.unlocks(ApiRecipeProvider.getHasName(item), ApiRecipeProvider.has(item));
        String path;
        if (recipeHolder.getName() != null) {
            path = recipeHolder.getName();
        } else {
            path = RegistryUtils.getIdFromRegistry(BuiltInRegistries.ITEM, recipeHolder.getResult().asItem());
        }

        builder.save(recipeOutput, path);
    }
}
