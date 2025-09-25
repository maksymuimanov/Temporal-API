package com.temporal.api.core.engine.registry.extension.item;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.factory.ItemFactory;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;

public interface MusicDiscSubFactory {
    default DeferredItem<Item> createMusicDisc(String name, ResourceKey<JukeboxSong> jukeboxSong) {
        return this.createMusicDisc(name, new Item.Properties(), jukeboxSong);
    }

    default DeferredItem<Item> createMusicDisc(String name, Item.Properties properties, ResourceKey<JukeboxSong> jukeboxSong) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.stacksTo(1)
                .jukeboxPlayable(jukeboxSong)
                .rarity(Rarity.RARE), Item::new);
    }
}
