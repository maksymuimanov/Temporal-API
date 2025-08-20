package net.temporal.example.recipe;

import com.temporal.api.core.engine.io.metadata.annotation.data.defined.DefinedRecipe;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.event.data.recipe.holder.ShapelessRecipeHolder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.temporal.example.registry.ExampleItems;

import java.util.Map;

@DefinedRecipe
@Injected(false)
public class ExampleRecipe implements ShapelessRecipeHolder {
    @Override
    public Map<ItemLike, Integer> getItemAndCountMap() {
        return Map.of(
                Items.DIAMOND, 1,
                Items.COPPER_BLOCK, 2
        );
    }

    @Override
    public RecipeCategory getRecipeCategory() {
        return RecipeCategory.FOOD;
    }

    @Override
    public ItemLike getResult() {
        return ExampleItems.EXAMPLE_FUEL;
    }
}
