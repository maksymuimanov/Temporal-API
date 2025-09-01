package com.temporal.api.core.event.data.recipe.description;

public interface SmokingRecipeDescription extends CookingRecipeDescription {
    @Override
    default String getName() {
        return "_from_smoking";
    }
}
