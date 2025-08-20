package com.temporal.api.core.event.data.recipe.holder;

public interface FourShapedRecipeHolder extends ShapedOneMaterialRecipeHolder {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XX",
                "XX"
        };
    }
}
