package net.temporal.example.wolf;

import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateWolfVariant;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.WolfVariant;

public final class ExampleWolfVariants {
    @TranslateAmericanEnglish("Example Wolf Variant")
    @GenerateWolfVariant(biomeTag = "minecraft:is_nether")
    public static final ResourceKey<WolfVariant> EXAMPLE_WOLF_VARIANT = ResourceUtils.createKey(Registries.WOLF_VARIANT, "example");
}