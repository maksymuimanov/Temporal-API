package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.data.recipes.RecipeCategory;

public interface ChestplateShapedRecipeHolder extends ShapedOneMaterialRecipeHolder {
    @Override
    default String[] getPattern() {
        return new String[]{
                "X X",
                "XXX",
                "XXX"
        };
    }

    @Override
    default RecipeCategory getRecipeCategory() {
        return RecipeCategory.COMBAT;
    }
}
