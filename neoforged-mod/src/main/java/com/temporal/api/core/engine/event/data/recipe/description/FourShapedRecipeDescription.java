package com.temporal.api.core.engine.event.data.recipe.description;

public interface FourShapedRecipeDescription extends ShapedOneMaterialRecipeDescription {
    @Override
    default String[] getPattern() {
        return new String[]{
                "XX",
                "XX"
        };
    }
}
