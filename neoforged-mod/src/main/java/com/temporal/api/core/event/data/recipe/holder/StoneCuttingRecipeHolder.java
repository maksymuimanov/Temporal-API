package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.world.level.ItemLike;

public interface StoneCuttingRecipeHolder extends RecipeHolder {
    ItemLike getIngredient();
}
