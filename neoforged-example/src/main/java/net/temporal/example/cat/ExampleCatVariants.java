package net.temporal.example.cat;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddCatVariantTag;
import com.temporal.api.core.engine.registry.factory.CatVariantFactory;
import net.minecraft.world.entity.animal.CatVariant;
import net.neoforged.neoforge.registries.DeferredHolder;

public final class ExampleCatVariants {
    private static final CatVariantFactory CAT_VARIANT_FACTORY = InjectionPool.getFromInstance(CatVariantFactory.class);

    @AddCatVariantTag("minecraft:default_spawns")
    public static final DeferredHolder<CatVariant, CatVariant> EXAMPLE = CAT_VARIANT_FACTORY.create("example");
}
