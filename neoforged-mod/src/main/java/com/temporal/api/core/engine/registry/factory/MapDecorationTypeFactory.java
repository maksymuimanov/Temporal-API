package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MapDecorationTypeFactory extends AbstractObjectFactory<MapDecorationType> {
    public MapDecorationTypeFactory() {
        this(InjectionPool.getFromInstance("$MapDecorationTypes"));
    }

    public MapDecorationTypeFactory(TemporalRegister<MapDecorationType> register) {
        super(register);
    }

    public DeferredHolder<MapDecorationType, MapDecorationType> create(String name, boolean showOnItemFrame, int mapColor, boolean explorationMapElement, boolean trackCount) {
        return this.create(name, ResourceUtils.createLocation(name), showOnItemFrame, mapColor, explorationMapElement, trackCount);
    }

    public DeferredHolder<MapDecorationType, MapDecorationType> create(String name, String assetId, boolean showOnItemFrame, int mapColor, boolean explorationMapElement, boolean trackCount) {
        return this.create(name, ResourceUtils.parse(assetId), showOnItemFrame, mapColor, explorationMapElement, trackCount);
    }

    public DeferredHolder<MapDecorationType, MapDecorationType> create(String name, ResourceLocation assetId, boolean showOnItemFrame, int mapColor, boolean explorationMapElement, boolean trackCount) {
        return this.create(name, () -> new MapDecorationType(assetId, showOnItemFrame, mapColor, trackCount, explorationMapElement));
    }
}
