package com.temporal.api.core.event.data.recipe.description;

public interface FourShapedRecipeDescription extends ShapedOneMaterialRecipeDescription {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XX",
                "XX"
        };
    }
}
