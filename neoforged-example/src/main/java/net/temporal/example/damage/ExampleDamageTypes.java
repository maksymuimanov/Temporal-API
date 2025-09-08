package net.temporal.example.damage;

import com.temporal.api.core.engine.metadata.annotation.data.GenerateDamageType;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateMultiple;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public final class ExampleDamageTypes {
    @TranslateMultiple(americanEnglish = {
            @TranslateAmericanEnglish("Example Damage"),
            @TranslateAmericanEnglish(value = "Killed by {2this}", prefix = "death.attack")
    })
    @GenerateDamageType
    public static final ResourceKey<DamageType> EXAMPLE_DAMAGE_TYPE = ResourceUtils.createKey(Registries.DAMAGE_TYPE, "example");
}
