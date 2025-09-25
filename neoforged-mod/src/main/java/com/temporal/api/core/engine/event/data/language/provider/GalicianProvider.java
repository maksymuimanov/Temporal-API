package com.temporal.api.core.engine.event.data.language.provider;

import com.temporal.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class GalicianProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public GalicianProvider(PackOutput output) {
        super(output, "gl_es");
    }
}