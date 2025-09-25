package com.temporal.api.core.engine.event.data.recipe.description;

import net.minecraft.data.recipes.RecipeCategory;

public interface HoeShapedRecipeDescription extends ShapedRecipeDescription {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XX",
                "S ",
                "S "
        };
    }

    @Override
    default RecipeCategory getRecipeCategory() {
        return RecipeCategory.TOOLS;
    }
}
