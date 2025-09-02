package com.temporal.api.core.engine.event.data.wolf;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.WolfVariant;

public record WolfVariantDescriptionHolder(ResourceKey<WolfVariant> variant, String biomeTag) {
}
