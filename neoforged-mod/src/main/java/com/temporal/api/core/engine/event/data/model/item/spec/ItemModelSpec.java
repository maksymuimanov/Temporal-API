package com.temporal.api.core.engine.event.data.model.item.spec;

import com.temporal.api.core.util.RegistryUtils;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ItemModelSpec {
    public static final String ITEM_PREFIX = "item";
    private final Holder<? extends Item> holder;

    public ItemModelSpec(Holder<? extends Item> holder) {
        this.holder = holder;
    }

    public ResourceLocation getLocation() {
        return this.getLocation("");
    }

    public ResourceLocation getLocation(String suffix) {
        return ResourceUtils.parse(this.getPath() + suffix);
    }

    public String getPath() {
        return getItemPath(this.getItem());
    }

    @SuppressWarnings("unchecked")
    public <T extends Item> T getItem() {
        return (T) this.getHolder().value();
    }

    public Holder<? extends Item> getHolder() {
        return holder;
    }

    public static String getItemPath(Item item) {
        return RegistryUtils.getObjectId(BuiltInRegistries.ITEM, item, ITEM_PREFIX);
    }
}
