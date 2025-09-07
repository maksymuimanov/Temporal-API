package net.temporal.example.banner;

import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import com.temporal.api.core.engine.metadata.annotation.data.language.TranslateMultiple;
import com.temporal.api.core.engine.metadata.annotation.data.model.GenerateBannerPattern;
import com.temporal.api.core.engine.metadata.annotation.data.tag.AddBannerPatternTag;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class ExampleBannerPatterns {
    @TranslateMultiple(americanEnglish = {
            @TranslateAmericanEnglish("Example Banner Pattern"),
            @TranslateAmericanEnglish(value = "Example Black Banner Pattern", suffix = "black"),
            @TranslateAmericanEnglish(value = "Example Blue Banner Pattern", suffix = "blue"),
            @TranslateAmericanEnglish(value = "Example Brown Banner Pattern", suffix = "brown"),
            @TranslateAmericanEnglish(value = "Example Cyan Banner Pattern", suffix = "cyan"),
            @TranslateAmericanEnglish(value = "Example Gray Banner Pattern", suffix = "gray"),
            @TranslateAmericanEnglish(value = "Example Green Banner Pattern", suffix = "green"),
            @TranslateAmericanEnglish(value = "Example Light Blue Banner Pattern", suffix = "light_blue"),
            @TranslateAmericanEnglish(value = "Example Light Gray Banner Pattern", suffix = "light_gray"),
            @TranslateAmericanEnglish(value = "Example Lime Banner Pattern", suffix = "lime"),
            @TranslateAmericanEnglish(value = "Example Magenta Banner Pattern", suffix = "magenta"),
            @TranslateAmericanEnglish(value = "Example Orange Banner Pattern", suffix = "orange"),
            @TranslateAmericanEnglish(value = "Example Pink Banner Pattern", suffix = "pink"),
            @TranslateAmericanEnglish(value = "Example Purple Banner Pattern", suffix = "purple"),
            @TranslateAmericanEnglish(value = "Example Red Banner Pattern", suffix = "red"),
            @TranslateAmericanEnglish(value = "Example White Banner Pattern", suffix = "white"),
            @TranslateAmericanEnglish(value = "Example Yellow Banner Pattern", suffix = "yellow"),
    })
    @GenerateBannerPattern
    @AddBannerPatternTag("example:pattern_item/example")
    public static final ResourceKey<BannerPattern> EXAMPLE = ResourceUtils.createKey(Registries.BANNER_PATTERN, "example");
}
