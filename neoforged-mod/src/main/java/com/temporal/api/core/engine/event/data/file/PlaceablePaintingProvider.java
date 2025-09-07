package com.temporal.api.core.engine.event.data.file;

import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.json.JsonRepresentation;
import com.temporal.api.core.json.ResourceLocationsRepresentation;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.util.List;
import java.util.Queue;

public class PlaceablePaintingProvider extends SingleFileProvider {
    public static final Queue<ResourceKey<PaintingVariant>> PLACEABLES = new TemporalQueue<>();
    public static final String PATH = "tags/painting_variant/placeable.json";

    public PlaceablePaintingProvider(PackOutput output) {
        super(output, PackOutput.Target.DATA_PACK, PATH, ResourceLocation.DEFAULT_NAMESPACE);
    }

    @Override
    public void registerFile() {
        List<ResourceLocation> placeables = PLACEABLES.stream()
                .map(ResourceKey::location)
                .toList();
        JsonRepresentation representation = new ResourceLocationsRepresentation(placeables);
        this.define(representation);
        PLACEABLES.clear();
    }
}
