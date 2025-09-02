package com.temporal.api.core.engine.event.data.recipe.description;

public interface CampfireCookingRecipeDescription extends CookingRecipeDescription {
    @Override
    default String getName() {
        return "_from_campfire_cooking";
    }
}
