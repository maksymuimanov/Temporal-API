package com.temporal.api.core.util;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.extensions.IHolderExtension;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TagUtils {
    public static TagKey<BannerPattern> createBannerPattern(String id) {
        return createTag(Registries.BANNER_PATTERN, id);
    }

    public static TagKey<Biome> createBiome(String id) {
        return createTag(Registries.BIOME, id);
    }

    public static TagKey<Block> createBlock(String id) {
        return BlockTags.create(ResourceUtils.parse(id));
    }

    public static TagKey<CatVariant> createCatVariant(String id) {
        return createTag(Registries.CAT_VARIANT, id);
    }

    public static TagKey<DamageType> createDamageType(String id) {
        return createTag(Registries.DAMAGE_TYPE, id);
    }

    public static TagKey<Enchantment> createEnchantment(String id) {
        return createTag(Registries.ENCHANTMENT, id);
    }

    public static TagKey<EntityType<?>> createEntityType(String id) {
        return createTag(Registries.ENTITY_TYPE, id);
    }

    public static TagKey<Fluid> createFluid(String id) {
        return createTag(Registries.FLUID, id);
    }

    public static TagKey<GameEvent> createGameEvent(String id) {
        return createTag(Registries.GAME_EVENT, id);
    }

    public static TagKey<Instrument> createInstrument(String id) {
        return createTag(Registries.INSTRUMENT, id);
    }

    public static TagKey<Item> createItem(String id) {
        return ItemTags.create(ResourceUtils.parse(id));
    }

    public static TagKey<PaintingVariant> createPaintingVariant(String id) {
        return createTag(Registries.PAINTING_VARIANT, id);
    }

    public static TagKey<PoiType> createPoiType(String id) {
        return createTag(Registries.POINT_OF_INTEREST_TYPE, id);
    }

    public static TagKey<Structure> createStructure(String id) {
        return createTag(Registries.STRUCTURE, id);
    }

    public static <T> TagKey<T> createTag(ResourceKey<? extends Registry<T>> registry, String id) {
        return TagKey.create(registry, ResourceUtils.parse(id));
    }

    public static <T> void putTag(TagKey<T> tag, Map<String, TagKey<T>> data) {
        String path = tag.location().toString();
        data.put(path, tag);
    }

    public static void putTagContainer(Set<Class<?>> tagContainers, Class<?> tagContainer) {
        if (!tagContainer.equals(Object.class)) {
            tagContainers.add(tagContainer);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> Stream<TagKey<T>> getTagKeyStream(Class<?> tagClassHolder) {
        return ReflectionUtils.getStaticFieldStream(tagClassHolder,
                field -> TagKey.class.isAssignableFrom(field.getType()),
                o -> (TagKey<T>) o);
    }

    @SuppressWarnings("unchecked")
    public static <T> Map<String, List<ResourceKey<T>>> mapTagHolderMap(Map<String, List<Holder<? extends T>>> tagHolderMap) {
        return tagHolderMap.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue()
                        .stream()
                        .map(holder -> (Holder<T>) holder)
                        .map(IHolderExtension::getKey)
                        .toList()));
    }
}
