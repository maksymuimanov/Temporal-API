package com.temporal.api.core.event.data.recipe.holder;

public interface NineShapedRecipeHolder extends ShapedOneMaterialRecipeHolder {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XXX",
                "XXX",
                "XXX"
        };
    }
}
