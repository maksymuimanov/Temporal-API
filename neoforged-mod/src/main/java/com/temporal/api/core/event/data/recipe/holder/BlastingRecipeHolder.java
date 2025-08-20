package com.temporal.api.core.event.data.recipe.holder;

public interface BlastingRecipeHolder extends CookingRecipeHolder {
    @Override
    default String getName() {
        return "_from_blasting";
    }
}
