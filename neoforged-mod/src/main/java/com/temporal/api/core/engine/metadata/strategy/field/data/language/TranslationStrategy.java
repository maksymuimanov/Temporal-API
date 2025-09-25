package com.temporal.api.core.engine.metadata.strategy.field.data.language;

import com.temporal.api.core.engine.event.data.language.provider.ApiLanguageProvider;
import com.temporal.api.core.engine.event.data.language.transformer.KeyTransformer;
import com.temporal.api.core.engine.metadata.pool.ProcessorScope;
import com.temporal.api.core.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import com.temporal.api.core.engine.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.ReflectionUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("unchecked")
public abstract class TranslationStrategy<A extends Annotation> implements FieldAnnotationStrategy<A> {
    public static final String TRANSLATION_ID_METHOD = "id";
    public static final String TRANSLATION_VALUE_METHOD = "value";
    public static final String TRANSLATION_PREFIX_METHOD = "prefix";
    public static final String TRANSLATION_SUFFIX_METHOD = "suffix";
    private final Class<?> translationProvider;

    protected TranslationStrategy(Class<?> translationProvider) {
        this.translationProvider = translationProvider;
    }

    @Override
    public void execute(Field field, Object object, A annotation) throws Exception {
        Object o = ReflectionUtils.getFieldValue(field, object);
        Class<? extends A> annotationClass = this.getAnnotationClass();
        String id = ReflectionUtils.invokeMethod(annotationClass, TRANSLATION_ID_METHOD, annotation);
        String value = ReflectionUtils.invokeMethod(annotationClass, TRANSLATION_VALUE_METHOD, annotation);
        String prefix = ReflectionUtils.invokeMethod(annotationClass, TRANSLATION_PREFIX_METHOD, annotation);
        String suffix = ReflectionUtils.invokeMethod(annotationClass, TRANSLATION_SUFFIX_METHOD, annotation);
        this.directTranslation(id, value, prefix, suffix, o);
    }

    protected void directTranslation(String possibleKey, String value, String prefix, String suffix, Object o) {
        if (!possibleKey.isBlank()) {
            this.putTranslation(possibleKey, value, prefix, suffix, ApiLanguageProvider.STRING_TRANSFORMER);
        } else {
            switch (o) {
                case String stringField -> this.putTranslation(stringField, value, prefix, suffix, ApiLanguageProvider.STRING_TRANSFORMER);
                case Component component -> this.putTranslation(component, value, prefix, suffix, ApiLanguageProvider.COMPONENT_TRANSFORMER);
                case ModConfigSpec.ConfigValue<?> configValue -> this.putTranslation(configValue, value, prefix, suffix, ApiLanguageProvider.CONFIG_TRANSFORMER);
                case Holder<?> holder -> this.putTranslation(Objects.requireNonNull(holder.getKey()), value, prefix, suffix);
                case ResourceKey<?> key -> this.putTranslation(key, value, prefix, suffix);
                default -> throw new IllegalStateException("Unexpected value: " + o);
            }
        }
    }

    protected <T> void putTranslation(ResourceKey<T> key, String value, String prefix, String suffix) {
        ResourceKey<Registry<T>> registryKey = key.registryKey();
        ApiLanguageProvider.REGISTRY_KEY_TRANSFORMERS.entrySet()
                .stream()
                .filter(entry -> registryKey.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .map(transformer -> (KeyTransformer<ResourceKey<T>>) transformer)
                .forEach(transformer -> this.putTranslation(key, value, prefix, suffix, transformer));
    }

    protected <T> void putTranslation(T key, String value, String prefix, String suffix, KeyTransformer<T> keyTransformer) {
        try {

            Map<String, String> translationMap = ReflectionUtils.getFieldValue(this.getTranslationProvider(), ApiLanguageProvider.TRANSLATIONS_FIELD_NAME, null);
            String translationKey = keyTransformer.transform(key);
            if (!prefix.isBlank()) translationKey = prefix + "." + translationKey;
            if (!suffix.isBlank()) translationKey = translationKey + "." + suffix;
            translationMap.put(translationKey, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected Class<?> getTranslationProvider() {
        return translationProvider;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
