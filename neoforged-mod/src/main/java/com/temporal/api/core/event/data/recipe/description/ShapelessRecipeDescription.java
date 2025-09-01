package com.temporal.api.core.event.data.recipe.description;

import net.minecraft.world.level.ItemLike;

import java.util.Map;

public interface ShapelessRecipeDescription extends RecipeDescription {
    Map<ItemLike, Integer> getItemAndCountMap();
}
