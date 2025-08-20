package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.data.recipes.RecipeCategory;

public interface SwordShapedRecipeHolder extends ShapedRecipeHolder {
    @Override
    default String[] getPattern() {
        return new String[]{
                "X",
                "X",
                "S"
        };
    }

    @Override
    default RecipeCategory getRecipeCategory() {
        return RecipeCategory.COMBAT;
    }
}
