package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.data.recipes.RecipeCategory;

public interface LeggingsShapedRecipeHolder extends ShapedOneMaterialRecipeHolder {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XXX",
                "X X",
                "X X"
        };
    }

    @Override
    default RecipeCategory getRecipeCategory() {
        return RecipeCategory.COMBAT;
    }
}
