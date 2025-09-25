package com.temporal.api.core.util;

import com.temporal.api.core.engine.context.ModContext;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import java.util.function.Function;
import java.util.stream.Stream;

public final class ResourceUtils {
    private ResourceUtils() {
    }

    public static String mapId(String id, Function<String, String> pathMapper) {
        return mapId(id, (namespace) -> namespace, pathMapper);
    }

    public static String mapId(String id, Function<String, String> namespaceMapper, Function<String, String> pathMapper) {
        String[] resource = id.split(":");
        return namespaceMapper.apply(resource[0]) + ":" + pathMapper.apply(resource[1]);
    }

    public static <T> ResourceKey<T> createKey(ResourceKey<? extends Registry<T>> registry, String id) {
        return ResourceKey.create(registry, parse(id));
    }

    public static ResourceLocation parse(String id) {
        if (id.contains(":")) {
            String[] split = id.split(":");
            return ResourceLocation.fromNamespaceAndPath(split[0], split[1]);
        } else {
            return createLocation(id);
        }
    }

    public static ResourceLocation createLocation(ResourceKey<?> resourceKey) {
        String namespace = resourceKey.location().getNamespace();
        return ResourceLocation.fromNamespaceAndPath(namespace, getResourceId(resourceKey));
    }

    public static ResourceLocation createLocation(String id) {
        return ResourceLocation.fromNamespaceAndPath(ModContext.NEO_MOD.getModId(), id);
    }

    public static String getResourceId(ResourceKey<?> resourceKey) {
        if (resourceKey == null) throw new RuntimeException("ResourceKey is null");
        return resourceKey.location().toString();
    }

    public static String getResourceId(TagKey<?> tagKey) {
        if (tagKey == null) throw new RuntimeException("TagKey is null");
        return tagKey.location().toString();
    }

    public static String getResourceName(ResourceKey<?> resourceKey) {
        if (resourceKey == null) throw new RuntimeException("ResourceKey is null");
        return resourceKey.location().getPath();
    }

    public static String getResourceName(TagKey<?> tagKey) {
        if (tagKey == null) throw new RuntimeException("TagKey is null");
        return tagKey.location().getPath();
    }

    @SuppressWarnings("unchecked")
    public static <T> Stream<ResourceKey<T>> getResourceKeyStream(Class<?> resourceClassHolder) {
        return ReflectionUtils.getStaticFieldStream(resourceClassHolder,
                field -> ResourceKey.class.isAssignableFrom(field.getType()),
                o -> (ResourceKey<T>) o);
    }
}
