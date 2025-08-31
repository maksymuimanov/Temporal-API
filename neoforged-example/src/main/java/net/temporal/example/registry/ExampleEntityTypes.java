package net.temporal.example.registry;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.engine.io.metadata.annotation.event.RegisterEntityRenderer;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.registry.factory.EntityTypeFactory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.temporal.example.entity.ExampleEntity;
import net.temporal.example.entity.renderer.ExampleRenderer;

@Injected
public final class ExampleEntityTypes {
    private static final EntityTypeFactory ENTITY_TYPE_FACTORY = InjectionPool.getFromInstance(EntityTypeFactory.class);

    @RegisterEntityRenderer(ExampleRenderer.class)
    public static final DeferredHolder<EntityType<?>, EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITY_TYPE_FACTORY.create("example_entity", ExampleEntity::new, MobCategory.MISC, 1f, 1f);
}
