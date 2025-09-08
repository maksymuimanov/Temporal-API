package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.registry.factory.*;

import java.util.List;

public class FactoryPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(ObjectPool objectPool, List<?> externalObjects) {
        objectPool.putObject(new ItemFactory());
        objectPool.putObject(new BlockFactory());
        objectPool.putObject(new CreativeModeTabFactory());
        objectPool.putObject(new EffectFactory());
        objectPool.putObject(new EntityTypeFactory());
        objectPool.putObject(new BlockEntityTypeFactory());
        objectPool.putObject(new ParticleFactory());
        objectPool.putObject(new PoiTypeFactory());
        objectPool.putObject(new PotionFactory());
        objectPool.putObject(new RecipeSerializerFactory());
        objectPool.putObject(new RecipeTypeFactory());
        objectPool.putObject(new SoundEventFactory());
        objectPool.putObject(new VillagerProfessionFactory());
        objectPool.putObject(new LootModifierSerializerFactory());
        objectPool.putObject(new MenuTypeFactory());
        objectPool.putObject(new TriggerFactory());
        objectPool.putObject(new ArmorMaterialFactory());
        objectPool.putObject(new AttachmentTypeFactory());
        objectPool.putObject(new CarverFactory());
        objectPool.putObject(new DataComponentTypeFactory());
        objectPool.putObject(new FluidFactory());
        objectPool.putObject(new FluidTypeFactory());
        objectPool.putObject(new FoliagePlacerTypeFactory());
        objectPool.putObject(new TreeDecoratorTypeFactory());
        objectPool.putObject(new TrunkPlacerTypeFactory());
    }
}