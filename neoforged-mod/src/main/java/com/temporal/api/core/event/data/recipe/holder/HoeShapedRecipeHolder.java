package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.data.recipes.RecipeCategory;

public interface HoeShapedRecipeHolder extends ShapedRecipeHolder {
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
