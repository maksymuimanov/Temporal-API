package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.CatVariant;
import net.neoforged.neoforge.registries.DeferredHolder;

public class CatVariantFactory extends AbstractObjectFactory<CatVariant> {
    public static final String ENTITY_CAT_PATH = "textures/entity/cat/%s.png";

    public CatVariantFactory() {
        this(InjectionPool.getFromInstance("$CatVariants"));
    }

    public CatVariantFactory(TemporalRegister<CatVariant> register) {
        super(register);
    }

    public DeferredHolder<CatVariant, CatVariant> create(String name) {
        String texturePath = ENTITY_CAT_PATH.formatted(name);
        ResourceLocation texture = ResourceUtils.createLocation(texturePath);
        return this.create(name, () -> new CatVariant(texture));
    }
}
