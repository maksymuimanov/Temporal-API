package com.temporal.api.core.engine.event.data.recipe.description;

import net.minecraft.data.recipes.RecipeCategory;

public interface HelmetShapedRecipeDescription extends ShapedOneMaterialRecipeDescription {
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
