package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.data.recipes.RecipeCategory;

public interface PickaxeShapedRecipeHolder extends ShapedRecipeHolder {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XXX",
                " S ",
                " S "
        };
    }

    @Override
    default RecipeCategory getRecipeCategory() {
        return RecipeCategory.TOOLS;
    }
}
