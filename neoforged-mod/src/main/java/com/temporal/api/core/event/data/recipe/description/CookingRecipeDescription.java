package com.temporal.api.core.event.data.recipe.description;

import net.minecraft.world.level.ItemLike;

public interface CookingRecipeDescription extends RecipeDescription {
    ItemLike getIngredient();

    float getExperience();

    int getCookingTime();

    String getGroup();
}
