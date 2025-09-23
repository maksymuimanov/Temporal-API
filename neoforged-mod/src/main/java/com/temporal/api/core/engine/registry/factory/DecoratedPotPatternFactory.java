package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
public class DecoratedPotPatternFactory extends AbstractObjectFactory<DecoratedPotPattern> {
    public DecoratedPotPatternFactory() {
        this(InjectionPool.getFromInstance("$DecoratedPotPatterns"));
    }

    public DecoratedPotPatternFactory(TemporalRegister<DecoratedPotPattern> register) {
        super(register);
    }

    public DeferredHolder<DecoratedPotPattern, DecoratedPotPattern> create(String name) {
        ResourceLocation assetId = ResourceUtils.createLocation(name);
        return this.create(name, () -> new DecoratedPotPattern(assetId));
    }
}
