package com.temporal.api.core.engine.event.data.language.provider;

import com.temporal.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class YakutProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public YakutProvider(PackOutput output) {
        super(output, "sah_sah");
    }
}