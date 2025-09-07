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
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Black", suffix = "black"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Blue", suffix = "blue"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Brown", suffix = "brown"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Cyan", suffix = "cyan"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Gray", suffix = "gray"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Green", suffix = "green"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Light Blue", suffix = "light_blue"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Light Gray", suffix = "light_gray"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Lime", suffix = "lime"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Magenta", suffix = "magenta"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Orange", suffix = "orange"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Pink", suffix = "pink"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Purple", suffix = "purple"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Red", suffix = "red"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} White", suffix = "white"),
            @TranslateAmericanEnglish(value = "{block.minecraft.banner.example.example} Yellow", suffix = "yellow"),
    })
    @GenerateBannerPattern
    @AddBannerPatternTag("example:pattern_item/example")
    public static final ResourceKey<BannerPattern> EXAMPLE = ResourceUtils.createKey(Registries.BANNER_PATTERN, "example");
}
