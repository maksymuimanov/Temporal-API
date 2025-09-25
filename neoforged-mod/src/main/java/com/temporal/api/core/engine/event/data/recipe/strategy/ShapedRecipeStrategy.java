package com.temporal.api.core.engine.event.data.recipe.strategy;

import com.temporal.api.core.engine.context.ModContext;
import com.temporal.api.core.engine.event.data.recipe.ApiRecipeProvider;
import com.temporal.api.core.engine.event.data.recipe.description.ShapedRecipeDescription;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ShapedRecipeStrategy implements RecipeStrategy<ShapedRecipeDescription> {
    @Override
    public void saveRecipe(ShapedRecipeDescription description, ApiRecipeProvider recipeProvider, @NotNull RecipeOutput recipeOutput) {
        String[] pattern = description.getPattern();
        final Map<Character, ItemLike> patternTranslation = description.getPatternTranslation();
        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(description.getRecipeCategory(), description.getResult(), description.getCount());
        for (String line : pattern) builder = builder.pattern(line);
        for (var translation : patternTranslation.entrySet()) builder = builder.define(translation.getKey(), translation.getValue());
        for (ItemLike item : patternTranslation.values()) builder = builder.unlockedBy(ApiRecipeProvider.getHasName(item), ApiRecipeProvider.has(item));
        if (description.getName() != null) {
            builder.save(recipeOutput, ModContext.NEO_MOD.getModId() + ":" + description.getName());
        } else {
            builder.save(recipeOutput);
        }
    }
}
