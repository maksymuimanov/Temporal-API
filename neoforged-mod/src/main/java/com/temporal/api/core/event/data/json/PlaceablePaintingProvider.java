package com.temporal.api.core.event.data.json;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.util.other.IOUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.nio.file.Path;
import java.util.Queue;
import java.util.stream.Collectors;

public class PlaceablePaintingProvider implements JsonProvider {
    public static final Queue<ResourceKey<PaintingVariant>> PLACEABLES = new TemporalQueue<>();
    private static final String FORMAT = """
            {
              "values": [
                ${placeables}
              ]
            }
            """;
    private static final String TARGET_FILE = "data/minecraft/tags/painting_variant/placeable.json";
    private static final Path TARGET_FILE_PATH = Path.of(TARGET_FILE);

    @Override
    public void registerFiles() {
        String placeablesString = PLACEABLES.stream()
                .map(ResourceKey::location)
                .map(location -> "\"" + location + "\"")
                .collect(Collectors.joining(",\n"));
        IOUtils.writeJson(TARGET_FILE_PATH, FORMAT, placeablesString);
        PLACEABLES.clear();
    }
}
