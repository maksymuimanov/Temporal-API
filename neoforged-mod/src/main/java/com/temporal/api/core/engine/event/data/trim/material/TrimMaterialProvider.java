package com.temporal.api.core.engine.event.data.trim.material;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.armortrim.TrimMaterial;

public interface TrimMaterialProvider {
    void registerTrimMaterials(BootstrapContext<TrimMaterial> context);
}
