package com.temporal.api.core.engine.event.data.language.provider;

import com.temporal.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class ValencianProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public ValencianProvider(PackOutput output) {
        super(output, "val_es");
    }
}