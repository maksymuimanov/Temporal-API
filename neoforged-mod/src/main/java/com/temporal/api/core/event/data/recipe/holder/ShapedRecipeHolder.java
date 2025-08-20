package com.temporal.api.core.event.data.recipe.holder;

import net.minecraft.world.level.ItemLike;

import java.util.Map;

public interface ShapedRecipeHolder extends RecipeHolder {
    String[] getPattern();

    Map<Character, ItemLike> getPatternTranslation();
}
