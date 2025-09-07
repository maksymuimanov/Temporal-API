package net.temporal.example.registry;

import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateBannerPattern;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddBannerPatternTag;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class ExampleBannerPatterns {
    @TranslateAmericanEnglish("Example Banner Pattern")
    @GenerateBannerPattern
    @AddBannerPatternTag("example:pattern_item/example")
    public static final ResourceKey<BannerPattern> EXAMPLE = ResourceUtils.createKey(Registries.BANNER_PATTERN, "example");
}
