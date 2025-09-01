package com.temporal.api.core.event.data.recipe.description;

import net.minecraft.data.recipes.RecipeCategory;

public interface SwordShapedRecipeDescription extends ShapedRecipeDescription {
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
