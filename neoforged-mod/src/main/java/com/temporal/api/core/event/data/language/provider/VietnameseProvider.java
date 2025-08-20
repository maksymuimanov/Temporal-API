package com.temporal.api.core.event.data.language.provider;

import com.temporal.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class VietnameseProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public VietnameseProvider(PackOutput output) {
        super(output, "vi_vn");
    }

    @Override
    public Map<String, String> getTranslations() {
        return TRANSLATIONS;
    }
}