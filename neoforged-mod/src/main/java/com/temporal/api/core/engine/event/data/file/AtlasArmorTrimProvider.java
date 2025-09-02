package com.temporal.api.core.engine.event.data.file;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.json.AtlasArmorTrimsRepresentation;
import com.temporal.api.core.json.JsonRepresentation;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import java.util.*;

public class AtlasArmorTrimProvider extends SingleFileProvider {
    public static final Queue<ResourceLocation> TRIM_PATTERNS_LOCATIONS = new TemporalQueue<>();
    public static final Map<String, ResourceLocation> TRIM_MATERIALS_LOCATIONS = new TemporalMap<>();
    private static final List<String> DEFAULT_TRIM_PATTERNS = new ArrayList<>();
    private static final Map<String, String> DEFAULT_TRIM_MATERIALS = new HashMap<>();

    static {
        addDefaultTrimPattern("bolt");
        addDefaultTrimPattern("coast");
        addDefaultTrimPattern("dune");
        addDefaultTrimPattern("eye");
        addDefaultTrimPattern("flow");
        addDefaultTrimPattern("host");
        addDefaultTrimPattern("raiser");
        addDefaultTrimPattern("rib");
        addDefaultTrimPattern("sentry");
        addDefaultTrimPattern("shaper");
        addDefaultTrimPattern("silence");
        addDefaultTrimPattern("snout");
        addDefaultTrimPattern("spire");
        addDefaultTrimPattern("tide");
        addDefaultTrimPattern("vex");
        addDefaultTrimPattern("ward");
        addDefaultTrimPattern("wayfinder");
        addDefaultTrimPattern("wild");
        addDefaultTrimMaterial("quartz");
        addDefaultTrimMaterial("iron");
        addDefaultTrimMaterial("gold");
        addDefaultTrimMaterial("diamond");
        addDefaultTrimMaterial("netherite");
        addDefaultTrimMaterial("redstone");
        addDefaultTrimMaterial("copper");
        addDefaultTrimMaterial("emerald");
        addDefaultTrimMaterial("lapis");
        addDefaultTrimMaterial("amethyst");
        addDefaultTrimMaterial("iron_darker");
        addDefaultTrimMaterial("gold_darker");
        addDefaultTrimMaterial("diamond_darker");
        addDefaultTrimMaterial("netherite_darker");
    }

    protected static void addDefaultTrimPattern(String name) {
        String id = "trims/models/armor/" + name;
        DEFAULT_TRIM_PATTERNS.add(id);
        DEFAULT_TRIM_PATTERNS.add(id + "_leggings");
    }

    protected static void addDefaultTrimMaterial(String name) {
        DEFAULT_TRIM_MATERIALS.put(name, "trims/color_palettes/" + name);
    }

    public AtlasArmorTrimProvider(PackOutput output) {
        super(output, PackOutput.Target.RESOURCE_PACK, "atlases/armor_trims.json", ResourceLocation.DEFAULT_NAMESPACE);
    }

    @Override
    public void registerFile() {
        List<String> trimPatterns = new ArrayList<>(DEFAULT_TRIM_PATTERNS);
        TRIM_PATTERNS_LOCATIONS.forEach(location -> {
            String namespace = location.getNamespace();
            String path = location.getPath();
            String id = namespace + ":trims/models/armor/" + path;
            trimPatterns.add(id);
            trimPatterns.add(id + "_leggings");
        });
        Map<String, String> trimMaterials = new HashMap<>(DEFAULT_TRIM_MATERIALS);
        TRIM_MATERIALS_LOCATIONS.forEach((key, value) -> {
            trimMaterials.put(key, value.getNamespace() + ":trims/color_palettes/" + value.getPath());
        });
        AtlasArmorTrimsRepresentation.Permutation permutation = new AtlasArmorTrimsRepresentation.Permutation(trimMaterials);
        AtlasArmorTrimsRepresentation.Source source = new AtlasArmorTrimsRepresentation.Source(
                "paletted_permutations",
                trimPatterns,
                "trims/color_palettes/trim_palette",
                permutation
        );
        AtlasArmorTrimsRepresentation.Source[] sources = {source};
        JsonRepresentation representation = new AtlasArmorTrimsRepresentation(false, sources);
        this.define(representation);
    }
}
