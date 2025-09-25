package com.temporal.api.core.engine.registry.extension.item;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.ItemFactory;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.neoforged.neoforge.registries.DeferredItem;

public interface BannerPatternSubFactory {
    default DeferredItem<BannerPatternItem> createBannerPattern(String name, TagKey<BannerPattern> bannerPattern) {
        return this.createBannerPattern(name, new Item.Properties(), bannerPattern);
    }

    default DeferredItem<BannerPatternItem> createBannerPattern(String name, Item.Properties properties, TagKey<BannerPattern> bannerPattern) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.stacksTo(1), props -> new BannerPatternItem(bannerPattern, props));
    }
}
