package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MenuFactory extends AbstractObjectFactory<MenuType<?>> {
    public MenuFactory() {
        this(InjectionPool.getFromInstance("$Menus"));
    }

    public MenuFactory(final TemporalRegister<MenuType<?>> register) {
        super(register);
    }

    public <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> create(final String name, final IContainerFactory<T> containerFactory) {
        return create(name, () -> IMenuTypeExtension.create(containerFactory));
    }

    public <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> create(final String name, final MenuType.MenuSupplier<T> container, final FeatureFlagSet featureFlagSet) {
        return create(name, () -> new MenuType<>(container, featureFlagSet));
    }
}
