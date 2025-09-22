package com.temporal.api.core.engine.event.data.recipe.strategy;

import com.temporal.api.core.engine.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.engine.event.data.recipe.description.SmithingTransformRecipeDescription;
import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public class SmithingTransformRecipeStrategy implements RecipeStrategy<SmithingTransformRecipeDescription> {
    @Override
    public void saveRecipe(SmithingTransformRecipeDescription description, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput recipeOutput) {
        Ingredient base = description.getBaseTag() != null
                ? recipeProvider.tag(description.getBaseTag())
                : Ingredient.of(description.getBases());
        Ingredient addition = description.getAdditionTag() != null
                ? recipeProvider.tag(description.getAdditionTag())
                : Ingredient.of(description.getAdditions());
        SmithingTransformRecipeBuilder builder = SmithingTransformRecipeBuilder.smithing(Ingredient.of(description.getTemplates()), base, addition, description.getRecipeCategory(), description.getResult().asItem());
        for (ItemLike item : description.getAdditions())
            builder.unlocks(ApiRecipeProvider.getHasName(item), ApiRecipeProvider.has(item));
        String path;
        if (description.getName() != null) {
            path = description.getName();
        } else {
            path = RegistryUtils.getObjectId(BuiltInRegistries.ITEM, description.getResult().asItem());
        }

        builder.save(recipeOutput, path);
    }
}
