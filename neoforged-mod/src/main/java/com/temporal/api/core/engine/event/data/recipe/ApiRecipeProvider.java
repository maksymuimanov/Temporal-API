package com.temporal.api.core.engine.event.data.recipe;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.engine.event.data.recipe.description.*;
import com.temporal.api.core.engine.event.data.recipe.strategy.*;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;

public class ApiRecipeProvider extends RecipeProvider {
    public static final Queue<RecipeDescription> RECIPES = new TemporalQueue<>();
    private static final RecipeStrategy<ShapelessRecipeDescription> SHAPELESS_RECIPE_STRATEGY = new ShapelessRecipeStrategy();
    private static final RecipeStrategy<ShapedRecipeDescription> SHAPED_RECIPE_STRATEGY = new ShapedRecipeStrategy();
    private static final RecipeStrategy<BlastingRecipeDescription> BLASTING_RECIPE_STRATEGY = new BlastingRecipeStrategy();
    private static final RecipeStrategy<SmeltingRecipeDescription> SMELTING_RECIPE_STRATEGY = new SmeltingRecipeStrategy();
    private static final RecipeStrategy<SmokingRecipeDescription> SMOKING_RECIPE_STRATEGY = new SmokingRecipeStrategy();
    private static final RecipeStrategy<CampfireCookingRecipeDescription> CAMPFIRE_COOKING_RECIPE_STRATEGY = new CampfireCookingRecipeStrategy();
    private static final RecipeStrategy<SmithingTrimRecipeDescription> SMITHING_TRIM_RECIPE_STRATEGY = new SmithingTrimRecipeStrategy();
    private static final RecipeStrategy<SmithingTransformRecipeDescription> SMITHING_TRANSFORM_RECIPE_STRATEGY = new SmithingTransformRecipeStrategy();
    private static final RecipeStrategy<StoneCuttingRecipeDescription> STONE_CUTTING_RECIPE_STRATEGY_RECIPE_STRATEGY = new StoneCuttingRecipeStrategy();

    public ApiRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        RECIPES.forEach(undefinedRecipe -> {
            switch (undefinedRecipe) {
                case ShapelessRecipeDescription recipe -> SHAPELESS_RECIPE_STRATEGY.saveRecipe(recipe, this, output);
                case ShapedRecipeDescription recipe -> SHAPED_RECIPE_STRATEGY.saveRecipe(recipe, this, output);
                case BlastingRecipeDescription recipe -> BLASTING_RECIPE_STRATEGY.saveRecipe(recipe, this, output);
                case SmeltingRecipeDescription recipe -> SMELTING_RECIPE_STRATEGY.saveRecipe(recipe, this, output);
                case SmokingRecipeDescription recipe -> SMOKING_RECIPE_STRATEGY.saveRecipe(recipe, this, output);
                case CampfireCookingRecipeDescription recipe -> CAMPFIRE_COOKING_RECIPE_STRATEGY.saveRecipe(recipe, this, output);
                case SmithingTrimRecipeDescription recipe -> SMITHING_TRIM_RECIPE_STRATEGY.saveRecipe(recipe, this, output);
                case SmithingTransformRecipeDescription recipe -> SMITHING_TRANSFORM_RECIPE_STRATEGY.saveRecipe(recipe, this, output);
                case StoneCuttingRecipeDescription recipe -> STONE_CUTTING_RECIPE_STRATEGY_RECIPE_STRATEGY.saveRecipe(recipe, this, output);
                case null, default -> {}
            }
        });
    }

    @NotNull
    public Ingredient tag(@NotNull TagKey<Item> tagKey) {
        return Ingredient.of(tagKey);
    }

    public static String getHasName(ItemLike itemLike) {
        return "has_" + getItemName(itemLike);
    }

    public static @NotNull String getItemName(ItemLike itemLike) {
        return Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(itemLike.asItem())).getPath();
    }

    public static @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> has(@NotNull ItemLike itemLike) {
        return RecipeProvider.has(itemLike);
    }
}
