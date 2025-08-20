package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RecipeSerializerFactory extends AbstractObjectFactory<RecipeSerializer<?>> {
    private final DeferredRegister<RecipeSerializer<?>> recipeSerializers;

    public RecipeSerializerFactory() {
        this(InjectionPool.getFromInstance("$RecipeSerializers"));
    }

    public RecipeSerializerFactory(DeferredRegister<RecipeSerializer<?>> recipeSerializers) {
        this.recipeSerializers = recipeSerializers;
    }

    public <T extends Recipe<?>> DeferredHolder<RecipeSerializer<?>, RecipeSerializer<T>> create(String name, RecipeSerializer<T> recipeSerializer) {
        return this.create(name, () -> recipeSerializer);
    }



    @Override
    public DeferredRegister<RecipeSerializer<?>> getRegistry() {
        return recipeSerializers;
    }
}