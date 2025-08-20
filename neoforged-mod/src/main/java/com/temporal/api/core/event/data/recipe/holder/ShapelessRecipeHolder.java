package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.world.level.ItemLike;

import java.util.Map;

public interface ShapelessRecipeHolder extends RecipeHolder {
    Map<ItemLike, Integer> getItemAndCountMap();
}
