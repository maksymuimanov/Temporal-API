package com.temporal.api.core.event.data.damage;

import com.temporal.api.core.collection.TemporalMap;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

import java.util.Map;

public class ApiDamageTypeProvider implements DamageTypeProvider {
    public static final Map<ResourceKey<DamageType>, DamageTypeDescriptionHolder> DAMAGE_TYPES = new TemporalMap<>();

    @Override
    public void registerDamageTypes(BootstrapContext<DamageType> context) {
        DAMAGE_TYPES.forEach((damageType, description) -> {
            ResourceLocation location = damageType.location();
            String messageId = "damage." + location.getNamespace() + "." + location.getPath();
            context.register(damageType, new DamageType(messageId,
                    description.damageScaling(), description.exhaustion(), description.effects(), description.messageType()));
        });
    }

    public static void bootstrap(BootstrapContext<DamageType> context) {
        DamageTypeProvider damageTypeProvider = new ApiDamageTypeProvider();
        damageTypeProvider.registerDamageTypes(context);
    }
}
