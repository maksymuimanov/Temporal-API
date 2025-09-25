package net.temporal.example.particle;

import com.temporal.api.common.particle.SimpleParticle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

public class ExampleParticle extends SimpleParticle {
    protected ExampleParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet spriteSet) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed, spriteSet);
        this.friction = 0.96F;
        this.speedUpWhenYMotionIsBlocked = true;
        this.quadSize *= 0.75F;
        this.hasPhysics = false;
    }

    @Override
    @NotNull
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Provider extends SimpleParticle.Provider {
        public Provider(SpriteSet spriteSet) {
            super(spriteSet);
        }

        @Override
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet spriteSet) {
            ExampleParticle particle = new ExampleParticle(clientLevel, x, y, z, xSpeed, ySpeed, zSpeed, spriteSet);
            particle.setAlpha(1.0F);
            particle.setParticleSpeed(xSpeed * 0.25D, ySpeed * 0.25D, zSpeed * 0.25D);
            particle.setLifetime(clientLevel.random.nextInt(6) + 6);
            return particle;
        }
    }
}
