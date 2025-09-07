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
            @TranslateAmericanEnglish(value = "Black {block.minecraft.banner.example.example}", suffix = "black"),
            @TranslateAmericanEnglish(value = "Blu {block.minecraft.banner.example.example}e", suffix = "blue"),
            @TranslateAmericanEnglish(value = "Brown {block.minecraft.banner.example.example}", suffix = "brown"),
            @TranslateAmericanEnglish(value = "Cya {block.minecraft.banner.example.example}n", suffix = "cyan"),
            @TranslateAmericanEnglish(value = "Gra {block.minecraft.banner.example.example}y", suffix = "gray"),
            @TranslateAmericanEnglish(value = "Green {block.minecraft.banner.example.example}", suffix = "green"),
            @TranslateAmericanEnglish(value = "Light Blue {block.minecraft.banner.example.example}", suffix = "light_blue"),
            @TranslateAmericanEnglish(value = "Light Gray {block.minecraft.banner.example.example}", suffix = "light_gray"),
            @TranslateAmericanEnglish(value = "Lim {block.minecraft.banner.example.example}e", suffix = "lime"),
            @TranslateAmericanEnglish(value = "Magenta {block.minecraft.banner.example.example}", suffix = "magenta"),
            @TranslateAmericanEnglish(value = "Orange {block.minecraft.banner.example.example}", suffix = "orange"),
            @TranslateAmericanEnglish(value = "Pin {block.minecraft.banner.example.example}k", suffix = "pink"),
            @TranslateAmericanEnglish(value = "Purple {block.minecraft.banner.example.example}", suffix = "purple"),
            @TranslateAmericanEnglish(value = "Re {block.minecraft.banner.example.example}d", suffix = "red"),
            @TranslateAmericanEnglish(value = "White {block.minecraft.banner.example.example}", suffix = "white"),
            @TranslateAmericanEnglish(value = "Yellow {block.minecraft.banner.example.example}", suffix = "yellow"),
    })
    @GenerateBannerPattern
    @AddBannerPatternTag("example:pattern_item/example")
    public static final ResourceKey<BannerPattern> EXAMPLE = ResourceUtils.createKey(Registries.BANNER_PATTERN, "example");
}
