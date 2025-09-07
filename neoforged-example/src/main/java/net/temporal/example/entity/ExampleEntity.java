package net.temporal.example.entity;

import com.temporal.api.core.engine.metadata.annotation.event.attributes.CreateEntityAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ExampleEntity extends Turtle {
    public ExampleEntity(EntityType<? extends ExampleEntity> entityType, Level level) {
        super(entityType, level);
    }

    @NotNull
    @CreateEntityAttributes("example:example_entity")
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23D)
                .add(Attributes.ATTACK_DAMAGE, 3.0D);
    }
}
