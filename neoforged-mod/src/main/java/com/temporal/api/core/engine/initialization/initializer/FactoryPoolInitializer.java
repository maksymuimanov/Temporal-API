package com.temporal.api.core.engine.initialization.initializer;

import com.temporal.api.core.engine.context.ObjectPool;
import com.temporal.api.core.engine.registry.factory.*;

import java.util.Collection;
import java.util.List;

public class FactoryPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectPool objectPool) {
        objectPool.put(new ItemFactory());
        objectPool.put(new BlockFactory());
        objectPool.put(new CreativeModeTabFactory());
        objectPool.put(new EffectFactory());
        objectPool.put(new EntityTypeFactory());
        objectPool.put(new BlockEntityTypeFactory());
        objectPool.put(new ParticleTypeFactory());
        objectPool.put(new PoiTypeFactory());
        objectPool.put(new PotionFactory());
        objectPool.put(new RecipeSerializerFactory());
        objectPool.put(new RecipeTypeFactory());
        objectPool.put(new SoundEventFactory());
        objectPool.put(new VillagerProfessionFactory());
        objectPool.put(new LootModifierSerializerFactory());
        objectPool.put(new MenuTypeFactory());
        objectPool.put(new TriggerFactory());
        objectPool.put(new ArmorMaterialFactory());
        objectPool.put(new AttachmentTypeFactory());
        objectPool.put(new FeatureFactory());
        objectPool.put(new CarverFactory());
        objectPool.put(new DataComponentTypeFactory());
        objectPool.put(new FluidFactory());
        objectPool.put(new FluidTypeFactory());
        objectPool.put(new FoliagePlacerTypeFactory());
        objectPool.put(new TreeDecoratorTypeFactory());
        objectPool.put(new TrunkPlacerTypeFactory());
        objectPool.put(new EnchantmentEffectComponentTypeFactory());
        objectPool.put(new EnchantmentEntityEffectTypeFactory());
        objectPool.put(new EnchantmentProviderTypeFactory());
        objectPool.put(new EnchantmentLevelBasedValueTypeFactory());
        objectPool.put(new EnchantmentLocationBasedEffectTypeFactory());
        objectPool.put(new EnchantmentValueEffectTypeFactory());
    }
}