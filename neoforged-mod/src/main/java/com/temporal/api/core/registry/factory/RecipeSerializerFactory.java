package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.TemporalRegister;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;

public class RecipeSerializerFactory extends AbstractObjectFactory<RecipeSerializer<?>> {
    public RecipeSerializerFactory() {
        this(InjectionPool.getFromInstance("$RecipeSerializers"));
    }

    public RecipeSerializerFactory(TemporalRegister<RecipeSerializer<?>> recipeSerializers) {
        super(recipeSerializers);
    }

    public <T extends Recipe<?>> DeferredHolder<RecipeSerializer<?>, RecipeSerializer<T>> create(String name, RecipeSerializer<T> recipeSerializer) {
        return this.create(name, () -> recipeSerializer);
    }
}