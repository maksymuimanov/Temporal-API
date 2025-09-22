package net.temporal.example.trim;

import com.temporal.api.core.engine.metadata.annotation.data.GenerateTrimMaterial;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimMaterial;

public final class ExampleTrimMaterials {
    @TranslateAmericanEnglish("Example Trim Material")
    @GenerateTrimMaterial(item = "example:example_ingot", color = "#829499", itemModelIndex = 0.2F)
    public static final ResourceKey<TrimMaterial> EXAMPLE_TRIM_MATERIAL = ResourceUtils.createKey(Registries.TRIM_MATERIAL, "example");

}
