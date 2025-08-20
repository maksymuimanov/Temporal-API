package com.temporal.api.core.event.data.recipe.strategy;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.event.data.recipe.holder.ShapedRecipeHolder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ShapedRecipeStrategy implements RecipeStrategy<ShapedRecipeHolder> {
    @Override
    public void saveRecipe(ShapedRecipeHolder recipeHolder, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput recipeOutput) {
        String[] pattern = recipeHolder.getPattern();
        final Map<Character, ItemLike> patternTranslation = recipeHolder.getPatternTranslation();
        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(recipeHolder.getRecipeCategory(), recipeHolder.getResult(), recipeHolder.getCount());
        for (String line : pattern) builder = builder.pattern(line);
        for (var translation : patternTranslation.entrySet()) builder = builder.define(translation.getKey(), translation.getValue());
        for (ItemLike item : patternTranslation.values()) builder = builder.unlockedBy(ApiRecipeProvider.getHasName(item), ApiRecipeProvider.has(item));
        if (recipeHolder.getName() != null) {
            builder.save(recipeOutput, IOLayer.NEO_MOD.getModId() + ":" + recipeHolder.getName());
        } else {
            builder.save(recipeOutput);
        }
    }
}
