package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MenuTypeFactory extends AbstractObjectFactory<MenuType<?>> {
    private final DeferredRegister<MenuType<?>> menuTypes;

    public MenuTypeFactory() {
        this(InjectionPool.getFromInstance("$MenuTypes"));
    }

    public MenuTypeFactory(DeferredRegister<MenuType<?>> menuTypes) {
        this.menuTypes = menuTypes;
    }

    public <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> create(String name, IContainerFactory<T> containerFactory) {
        return menuTypes.register(name, () -> IMenuTypeExtension.create(containerFactory));
    }

    public <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> create(String name, MenuType.MenuSupplier<T> container, FeatureFlagSet featureFlagSet) {
        return menuTypes.register(name, () -> new MenuType<>(container, featureFlagSet));
    }

    @Override
    public DeferredRegister<MenuType<?>> getRegistry() {
        return menuTypes;
    }
}
