package com.temporal.api.core.event.data.recipe.description;

import net.minecraft.world.level.ItemLike;

import java.util.Map;

public interface ShapedRecipeDescription extends RecipeDescription {
    String[] getPattern();

    Map<Character, ItemLike> getPatternTranslation();
}
