package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.world.level.ItemLike;

public interface CookingRecipeHolder extends RecipeHolder {
    ItemLike getIngredient();

    float getExperience();

    int getCookingTime();

    String getGroup();
}
