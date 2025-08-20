package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.data.recipes.RecipeCategory;

public interface ShovelShapedRecipeHolder extends ShapedRecipeHolder {
    @Override
    default String[] getPattern() {
        return new String[]{
                "X",
                "S",
                "S"
        };
    }

    @Override
    default RecipeCategory getRecipeCategory() {
        return RecipeCategory.TOOLS;
    }
}
