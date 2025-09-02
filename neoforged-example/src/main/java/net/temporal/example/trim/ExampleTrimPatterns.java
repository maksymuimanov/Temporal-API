package net.temporal.example.trim;

import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateEnglish;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateTrimPattern;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimPattern;

public class ExampleTrimPatterns {
    @TranslateEnglish("Example Trim Pattern")
    @GenerateTrimPattern(itemId = "example:example_armor_trim_smithing_template")
    public static final ResourceKey<TrimPattern> EXAMPLE_TRIM_PATTERN = ResourceUtils.createKey(Registries.TRIM_PATTERN, "example");
}
