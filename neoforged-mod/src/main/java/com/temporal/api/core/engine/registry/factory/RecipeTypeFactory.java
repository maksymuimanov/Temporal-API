package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class RecipeTypeFactory extends AbstractObjectFactory<RecipeType<?>> {
    public RecipeTypeFactory() {
        this(InjectionPool.getFromInstance("$RecipeTypes"));
    }

    public RecipeTypeFactory(TemporalRegister<RecipeType<?>> recipeTypes) {
        super(recipeTypes);
    }

    public <T extends Recipe<?>> DeferredHolder<RecipeType<?>, RecipeType<T>> create(String name) {
        return this.create(name, () -> RecipeType.simple(ResourceUtils.createLocation(name)));
    }
}