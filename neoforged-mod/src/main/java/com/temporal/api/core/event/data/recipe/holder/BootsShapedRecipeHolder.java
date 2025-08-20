package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.data.recipes.RecipeCategory;

public interface BootsShapedRecipeHolder extends ShapedOneMaterialRecipeHolder {
    @Override
    default String[] getPattern() {
        return new String[]{
                "X X",
                "X X"
        };
    }

    @Override
    default RecipeCategory getRecipeCategory() {
        return RecipeCategory.COMBAT;
    }
}
