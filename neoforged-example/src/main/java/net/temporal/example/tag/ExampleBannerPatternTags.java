package net.temporal.example.tag;

import com.temporal.api.core.util.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public final class ExampleBannerPatternTags {
    public static final TagKey<BannerPattern> EXAMPLE = TagUtils.createBannerPattern("pattern_item/example");
}
