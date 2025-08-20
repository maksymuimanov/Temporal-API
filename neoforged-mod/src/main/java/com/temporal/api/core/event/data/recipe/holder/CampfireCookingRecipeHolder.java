package com.temporal.api.core.event.data.recipe.holder;

public interface CampfireCookingRecipeHolder extends CookingRecipeHolder {
    @Override
    default String getName() {
        return "_from_campfire_cooking";
    }
}
