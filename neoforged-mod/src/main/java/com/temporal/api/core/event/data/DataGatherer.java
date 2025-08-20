package com.temporal.api.core.event.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

public interface DataGatherer {
    void gatherData(GatherDataEvent event);

    void init();

    void addGlobalLootModifierProvider(GatherDataEvent event);

    void addLootTableProvider(GatherDataEvent event);

    void addModelProvider(GatherDataEvent event);

    void addLanguageProvider(GatherDataEvent event);

    void addRecipeProvider(GatherDataEvent event);

    void addTagProvider(GatherDataEvent event);

    void addDatapackProvider(GatherDataEvent event);

    void addDataMapProvider(GatherDataEvent event);

    void addAdvancementProvider(GatherDataEvent event);

    void addSoundProvider(GatherDataEvent event);

    void addParticleProvider(GatherDataEvent event);

    void addJsonProvider(GatherDataEvent event);

    @NotNull
    PackOutput getPackOutput(GatherDataEvent event);

    DataGenerator getDataGenerator(GatherDataEvent event);

    ExistingFileHelper getExistingFileHelper(GatherDataEvent event);
}
