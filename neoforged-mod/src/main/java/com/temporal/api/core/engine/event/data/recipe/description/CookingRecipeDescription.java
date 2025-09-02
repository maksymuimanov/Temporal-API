package com.temporal.api.core.engine.event.data.recipe.description;

import net.minecraft.world.level.ItemLike;

public interface CookingRecipeDescription extends RecipeDescription {
    ItemLike getIngredient();

    float getExperience();

    int getCookingTime();

    String getGroup();
}
