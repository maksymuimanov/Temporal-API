package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MenuTypeFactory extends AbstractObjectFactory<MenuType<?>> {
    public MenuTypeFactory() {
        this(InjectionPool.getFromInstance("$MenuTypes"));
    }

    public MenuTypeFactory(TemporalRegister<MenuType<?>> menuTypes) {
        super(menuTypes);
    }

    public <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> create(String name, IContainerFactory<T> containerFactory) {
        return this.create(name, () -> IMenuTypeExtension.create(containerFactory));
    }

    public <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> create(String name, MenuType.MenuSupplier<T> container, FeatureFlagSet featureFlagSet) {
        return this.create(name, () -> new MenuType<>(container, featureFlagSet));
    }
}
