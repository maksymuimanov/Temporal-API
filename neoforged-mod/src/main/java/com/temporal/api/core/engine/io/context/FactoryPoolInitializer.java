package com.temporal.api.core.engine.io.context;

import com.temporal.api.core.registry.factory.common.*;

import java.util.List;

public class FactoryPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(List<?> externalObjects) {
        ObjectPool objectPool = InjectionPool.getInstance();
        objectPool.putObject(new ItemFactory());
        objectPool.putObject(new BlockFactory());
        objectPool.putObject(new BiomeFactory());
        objectPool.putObject(new CreativeModeTabFactory());
        objectPool.putObject(new EffectFactory());
        objectPool.putObject(new EntityTypeFactory());
        objectPool.putObject(new BlockEntityTypeFactory());
        objectPool.putObject(new ParticleFactory());
        objectPool.putObject(new PoiTypeFactory());
        objectPool.putObject(new PotionFactory());
        objectPool.putObject(new RecipeSerializerFactory());
        objectPool.putObject(new SoundEventFactory());
        objectPool.putObject(new VillagerProfessionFactory());
        objectPool.putObject(new LootModifierSerializerFactory());
        objectPool.putObject(new MenuTypeFactory());
        objectPool.putObject(new TriggerFactory());
        objectPool.putObject(new ArmorMaterialFactory());
    }
}
