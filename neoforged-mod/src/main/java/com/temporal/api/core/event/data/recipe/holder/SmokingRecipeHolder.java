package com.temporal.api.core.event.data.recipe.holder;

public interface SmokingRecipeHolder extends CookingRecipeHolder {
    @Override
    default String getName() {
        return "_from_smoking";
    }
}
