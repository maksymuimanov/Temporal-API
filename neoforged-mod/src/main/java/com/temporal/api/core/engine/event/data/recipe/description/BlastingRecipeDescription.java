package com.temporal.api.core.engine.event.data.recipe.description;

public interface BlastingRecipeDescription extends CookingRecipeDescription {
    @Override
    default String getName() {
        return "_from_blasting";
    }
}
