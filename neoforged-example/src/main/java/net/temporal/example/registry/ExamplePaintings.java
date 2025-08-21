package net.temporal.example.registry;

import com.temporal.api.core.engine.io.metadata.annotation.data.model.GeneratePainting;
import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

@Injected(false)
public final class ExamplePaintings {
    @GeneratePainting
    private static final ResourceKey<PaintingVariant> EXAMPLE = ResourceUtils.createKey(Registries.PAINTING_VARIANT, "example");
}
