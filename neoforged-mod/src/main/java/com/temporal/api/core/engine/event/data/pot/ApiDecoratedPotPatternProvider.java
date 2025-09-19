package com.temporal.api.core.engine.event.data.pot;

import com.temporal.api.core.collection.TemporalQueue;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

import java.util.Queue;

public class ApiDecoratedPotPatternProvider implements DecoratedPotPatternProvider {
    public static final Queue<DecoratedPotPatternDescription> PATTERNS = new TemporalQueue<>();

    @Override
    public void addVariant(BootstrapContext<DecoratedPotPattern> context) {
        PATTERNS.forEach(description -> {
            ResourceKey<DecoratedPotPattern> pattern = description.pattern();
            ResourceLocation location = pattern.location();
            context.register(pattern, new DecoratedPotPattern(location));
        });
    }

    public static void bootstrap(BootstrapContext<DecoratedPotPattern> context) {
        DecoratedPotPatternProvider provider = new ApiDecoratedPotPatternProvider();
        provider.addVariant(context);
    }
}
