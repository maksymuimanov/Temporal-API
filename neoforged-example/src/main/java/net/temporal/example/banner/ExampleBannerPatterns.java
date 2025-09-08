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
            @TranslateAmericanEnglish(value = "Black {this$}", suffix = "black"),
            @TranslateAmericanEnglish(value = "Blue {this$}", suffix = "blue"),
            @TranslateAmericanEnglish(value = "Brown {this$}", suffix = "brown"),
            @TranslateAmericanEnglish(value = "Cyan {this$}", suffix = "cyan"),
            @TranslateAmericanEnglish(value = "Gray {this$}", suffix = "gray"),
            @TranslateAmericanEnglish(value = "Green {this$}", suffix = "green"),
            @TranslateAmericanEnglish(value = "Light Blue {this$}", suffix = "light_blue"),
            @TranslateAmericanEnglish(value = "Light Gray {this$}", suffix = "light_gray"),
            @TranslateAmericanEnglish(value = "Lime {this$}", suffix = "lime"),
            @TranslateAmericanEnglish(value = "Magenta {this$}", suffix = "magenta"),
            @TranslateAmericanEnglish(value = "Orange {this$}", suffix = "orange"),
            @TranslateAmericanEnglish(value = "Pink {this$}", suffix = "pink"),
            @TranslateAmericanEnglish(value = "Purple {this$}", suffix = "purple"),
            @TranslateAmericanEnglish(value = "Red {this$}", suffix = "red"),
            @TranslateAmericanEnglish(value = "White {this$}", suffix = "white"),
            @TranslateAmericanEnglish(value = "Yellow {this$}", suffix = "yellow"),
    })
    @GenerateBannerPattern
    @AddBannerPatternTag("example:pattern_item/example")
    public static final ResourceKey<BannerPattern> EXAMPLE = ResourceUtils.createKey(Registries.BANNER_PATTERN, "example");
}
