package com.temporal.api.core.registry.factory.extension.item;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import com.temporal.api.core.util.other.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;

public interface MusicDiscSubFactory {
    default DeferredItem<Item> createMusicDisc(String name, String soundId) {
        return createMusicDisc(name, new Item.Properties(), soundId);
    }

    default DeferredItem<Item> createMusicDisc(String name, Item.Properties properties, String soundId) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        ResourceKey<JukeboxSong> songResourceKey = ResourceUtils.createKey(Registries.JUKEBOX_SONG, soundId);
        return itemFactory.create(name, properties.stacksTo(1)
                .jukeboxPlayable(songResourceKey)
                .rarity(Rarity.RARE), Item::new);
    }
}
