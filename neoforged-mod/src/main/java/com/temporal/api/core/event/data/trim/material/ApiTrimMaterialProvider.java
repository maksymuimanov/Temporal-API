package com.temporal.api.core.event.data.trim.material;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.event.data.json.AtlasTrimProvider;
import com.temporal.api.core.util.other.RegistryUtils;
import com.temporal.api.core.util.other.ResourceUtils;
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
    public static final Map<ResourceKey<TrimMaterial>, TrimMaterialDescriptionHolder> TRIM_MATERIALS = new TemporalMap<>();

    @Override
    public void registerTrimMaterials(BootstrapContext<TrimMaterial> context) {
        TRIM_MATERIALS.forEach((trimMaterial, description) -> {
            String assetName = ResourceUtils.getResourceId(trimMaterial);
            Item ingredient = RegistryUtils.getItemById(description.itemId());
            ResourceLocation location = trimMaterial.location();
            String descriptionId = Util.makeDescriptionId("trim_material", location);
            TextColor textColor = TextColor.parseColor(description.color()).getOrThrow();
            Style style = Style.EMPTY.withColor(textColor);
            MutableComponent component = Component.translatable(descriptionId).withStyle(style);
            context.register(trimMaterial, TrimMaterial.create(assetName, ingredient, description.itemModelIndex(), component, Map.of()));
            Map<String, ResourceLocation> materialLocations = AtlasTrimProvider.TRIM_INFO.getRight();
            materialLocations.put(assetName, location);
        });
    }

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        TrimMaterialProvider provider = new ApiTrimMaterialProvider();
        provider.registerTrimMaterials(context);
    }
}
