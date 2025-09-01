package com.temporal.api.core.event.data.recipe.description;

import net.minecraft.data.recipes.RecipeCategory;

public interface ShovelShapedRecipeDescription extends ShapedRecipeDescription {
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
