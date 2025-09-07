package com.temporal.api.core.util;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.extensions.IHolderExtension;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TagUtils {
    public static TagKey<Item> createItem(String id) {
        return ItemTags.create(ResourceUtils.parse(id));
    }

    public static TagKey<Block> createBlock(String id) {
        return BlockTags.create(ResourceUtils.parse(id));
    }

    public TagKey<EntityType<?>> createEntityType(String id) {
        return createTag(Registries.ENTITY_TYPE, id);
    }

    public static TagKey<Fluid> createFluid(String id) {
        return FluidTags.create(ResourceUtils.parse(id));
    }

    public static TagKey<BannerPattern> createBannerPattern(String id) {
        return createTag(Registries.BANNER_PATTERN, id);
    }

    public static TagKey<BiomeModifier> createBiomeModifier(String id) {
        return createTag(NeoForgeRegistries.Keys.BIOME_MODIFIERS, id);
    }

    public static TagKey<Biome> createBiome(String id) {
        return createTag(Registries.BIOME, id);
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
    public static <T> @NotNull Stream<TagKey<T>> getTagKeyStream(Class<?> tagClassHolder) {
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
