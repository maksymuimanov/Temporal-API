package com.temporal.api.core.event.data.json;

import com.temporal.api.core.collection.Pair;
import com.temporal.api.core.collection.SimplePair;
import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.collection.TemporalQueue;
import com.temporal.api.core.util.other.IOUtils;
import net.minecraft.resources.ResourceLocation;

import java.nio.file.Path;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class AtlasTrimProvider implements JsonProvider {
    public static final Pair<Queue<ResourceLocation>, Map<String, ResourceLocation>> TRIM_INFO = new SimplePair<>(new TemporalQueue<>(), new TemporalMap<>());
    private static final String FORMAT = """
            {
              "replace": false,
              "sources": [
                {
                  "type": "paletted_permutations",
                  "textures": [
                    "trims/models/armor/coast",
                    "trims/models/armor/coast_leggings",
                    "trims/models/armor/sentry",
                    "trims/models/armor/sentry_leggings",
                    "trims/models/armor/dune",
                    "trims/models/armor/dune_leggings",
                    "trims/models/armor/wild",
                    "trims/models/armor/wild_leggings",
                    "trims/models/armor/ward",
                    "trims/models/armor/ward_leggings",
                    "trims/models/armor/eye",
                    "trims/models/armor/eye_leggings",
                    "trims/models/armor/vex",
                    "trims/models/armor/vex_leggings",
                    "trims/models/armor/tide",
                    "trims/models/armor/tide_leggings",
                    "trims/models/armor/snout",
                    "trims/models/armor/snout_leggings",
                    "trims/models/armor/rib",
                    "trims/models/armor/rib_leggings",
                    "trims/models/armor/spire",
                    "trims/models/armor/spire_leggings",
                    "trims/models/armor/wayfinder",
                    "trims/models/armor/wayfinder_leggings",
                    "trims/models/armor/shaper",
                    "trims/models/armor/shaper_leggings",
                    "trims/models/armor/silence",
                    "trims/models/armor/silence_leggings",
                    "trims/models/armor/raiser",
                    "trims/models/armor/raiser_leggings",
                    "trims/models/armor/host",
                    "trims/models/armor/host_leggings"
                    ${trim_patterns}
                  ],
                  "palette_key": "trims/color_palettes/trim_palette",
                  "permutations": {
                    "quartz": "trims/color_palettes/quartz",
                    "iron": "trims/color_palettes/iron",
                    "gold": "trims/color_palettes/gold",
                    "diamond": "trims/color_palettes/diamond",
                    "netherite": "trims/color_palettes/netherite",
                    "redstone": "trims/color_palettes/redstone",
                    "copper": "trims/color_palettes/copper",
                    "emerald": "trims/color_palettes/emerald",
                    "lapis": "trims/color_palettes/lapis",
                    "amethyst": "trims/color_palettes/amethyst",
                    "iron_darker": "trims/color_palettes/iron_darker",
                    "gold_darker": "trims/color_palettes/gold_darker",
                    "diamond_darker": "trims/color_palettes/diamond_darker",
                    "netherite_darker": "trims/color_palettes/netherite_darker"
                    ${trim_materials}
                  }
                }
              ]
            }
            """;
    private static final String TARGET_FILE = "assets/minecraft/atlases/armor_trims.json";
    private static final Path TARGET_FILE_PATH = Path.of(TARGET_FILE);


    @Override
    public void registerFiles() {
        String trimPatterns = "";
        String trimMaterials = "";
        Queue<ResourceLocation> left = TRIM_INFO.getLeft();
        Map<String, ResourceLocation> right = TRIM_INFO.getRight();
        if (left != null && !left.isEmpty()) {
            trimPatterns = left.stream()
                    .map(location -> "\"" + location.toString() + "\"")
                    .map(line -> line + ",\n" + line + "_leggings")
                    .collect(Collectors.joining(",\n        "));
            left.clear();
        }
        if (right != null && !right.isEmpty()) {
            trimMaterials = ",\n        " + right.entrySet()
                    .stream()
                    .map(entry -> "\"" + entry.getKey() + ": " + entry.getValue().toString() + "\"")
                    .collect(Collectors.joining(",\n        "));
            right.clear();
        }

        IOUtils.writeJson(TARGET_FILE_PATH, FORMAT, trimPatterns, trimMaterials);
    }
}
