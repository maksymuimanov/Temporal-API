package com.temporal.api.core.event.data.advancement;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public final class AdvancementProviderFactory {
    private AdvancementProviderFactory() {
    }

    @SuppressWarnings("deprecation")
    public static AdvancementProvider createProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        return new AdvancementProvider(output, lookupProvider, List.of(new ApiAdvancementProvider()));
    }
}
