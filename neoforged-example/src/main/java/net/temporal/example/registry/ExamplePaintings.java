package net.temporal.example.registry;

import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateEnglish;
import com.temporal.api.core.engine.metadata.annotation.data.model.GeneratePainting;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

public final class ExamplePaintings {
    @GeneratePainting
    @TranslateEnglish("Example Painting")
    private static final ResourceKey<PaintingVariant> EXAMPLE = ResourceUtils.createKey(Registries.PAINTING_VARIANT, "example");
}
