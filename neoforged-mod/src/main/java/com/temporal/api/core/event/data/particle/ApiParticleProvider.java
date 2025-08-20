package com.temporal.api.core.event.data.particle;

import com.temporal.api.core.collection.TemporalMap;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;

import java.util.Map;

public class ApiParticleProvider extends ParticleDescriptionProvider {
    public static final Map<Holder<ParticleType<?>>, ParticleSprite> PARTICLE_SPRITES = new TemporalMap<>();

    public ApiParticleProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, existingFileHelper);
    }

    @Override
    protected void addDescriptions() {
        PARTICLE_SPRITES.forEach((particleType, particleSprite) -> {
            if (particleSprite.count() <= 1) {
                sprite(particleType.value(), ResourceUtils.parse(particleSprite.id()));
            } else {
                spriteSet(particleType.value(), ResourceUtils.parse(particleSprite.id()),
                        particleSprite.count(),
                        particleSprite.reverse());
            }
        });
    }
}
