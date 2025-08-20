package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.data.recipes.RecipeCategory;

public interface HelmetShapedRecipeHolder extends ShapedOneMaterialRecipeHolder {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XXX",
                "X X"
        };
    }

    @Override
    default RecipeCategory getRecipeCategory() {
        return RecipeCategory.COMBAT;
    }
}
