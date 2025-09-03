package com.temporal.api.core.engine.event.data.trim.material;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.engine.event.data.file.AtlasArmorTrimProvider;
import com.temporal.api.core.util.RegistryUtils;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.Util;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.util.Map;

public class ApiTrimMaterialProvider implements TrimMaterialProvider {
    public static final Map<ResourceKey<TrimMaterial>, TrimMaterialDescription> TRIM_MATERIALS = new TemporalMap<>();
    public static final String TRIM_MATERIAL_TYPE = "trim_material";

    @Override
    public void registerTrimMaterials(BootstrapContext<TrimMaterial> context) {
        TRIM_MATERIALS.forEach((trimMaterial, description) -> {
            String assetName = ResourceUtils.getResourceName(trimMaterial);
            Item ingredient = RegistryUtils.getItem(description.itemId());
            ResourceLocation location = trimMaterial.location();
            String descriptionId = Util.makeDescriptionId(TRIM_MATERIAL_TYPE, location);
            TextColor textColor = TextColor.parseColor(description.color()).getOrThrow();
            Style style = Style.EMPTY.withColor(textColor);
            MutableComponent component = Component.translatable(descriptionId).withStyle(style);
            context.register(trimMaterial, TrimMaterial.create(assetName, ingredient, description.itemModelIndex(), component, Map.of()));
            AtlasArmorTrimProvider.TRIM_MATERIALS_LOCATIONS.put(assetName, location);
        });
    }

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        TrimMaterialProvider provider = new ApiTrimMaterialProvider();
        provider.registerTrimMaterials(context);
    }
}
