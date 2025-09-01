package com.temporal.api.core.event.data.recipe.description;

public interface NineShapedRecipeDescription extends ShapedOneMaterialRecipeDescription {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XXX",
                "XXX",
                "XXX"
        };
    }
}
