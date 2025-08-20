package com.temporal.api.core.event.data.language.provider;

import com.temporal.api.core.collection.TemporalMap;
import net.minecraft.data.PackOutput;

import java.util.Map;

public class TurkishProvider extends ApiLanguageProvider {
    public static final Map<String, String> TRANSLATIONS = new TemporalMap<>();

    public TurkishProvider(PackOutput output) {
        super(output, "tr_tr");
    }

    @Override
    public Map<String, String> getTranslations() {
        return TRANSLATIONS;
    }
}