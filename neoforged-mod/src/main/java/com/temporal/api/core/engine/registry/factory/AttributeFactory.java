package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.neoforge.common.BooleanAttribute;
import net.neoforged.neoforge.common.PercentageAttribute;
import net.neoforged.neoforge.registries.DeferredHolder;

public class AttributeFactory extends AbstractObjectFactory<Attribute> {
    public AttributeFactory() {
        this(InjectionPool.getFromInstance("$Attributes"));
    }

    public AttributeFactory(TemporalRegister<Attribute> register) {
        super(register);
    }

    public DeferredHolder<Attribute, Attribute> createBoolean(String name, String descriptionId, boolean defaultValue) {
        return this.createBoolean(name, descriptionId, defaultValue, false);
    }

    public DeferredHolder<Attribute, Attribute> createBoolean(String name, String descriptionId, boolean defaultValue, boolean isSyncable) {
        return this.createBoolean(name, descriptionId, defaultValue, isSyncable, Attribute.Sentiment.POSITIVE);
    }

    public DeferredHolder<Attribute, Attribute> createBoolean(String name, String descriptionId, boolean defaultValue, boolean isSyncable, Attribute.Sentiment sentiment) {
        return this.create(name, () -> new BooleanAttribute(descriptionId, defaultValue)
                .setSyncable(isSyncable)
                .setSentiment(sentiment));
    }

    public DeferredHolder<Attribute, Attribute> createRanged(String name, String descriptionId, double defaultValue, double min, double max) {
        return this.createRanged(name, descriptionId, defaultValue, min, max, false);
    }

    public DeferredHolder<Attribute, Attribute> createRanged(String name, String descriptionId, double defaultValue, double min, double max, boolean isSyncable) {
        return this.createRanged(name, descriptionId, defaultValue, min, max, isSyncable, Attribute.Sentiment.POSITIVE);
    }

    public DeferredHolder<Attribute, Attribute> createRanged(String name, String descriptionId, double defaultValue, double min, double max, boolean isSyncable, Attribute.Sentiment sentiment) {
        return this.create(name, () -> new RangedAttribute(descriptionId, defaultValue, min, max)
                .setSyncable(isSyncable)
                .setSentiment(sentiment));
    }

    public DeferredHolder<Attribute, Attribute> createPercentage(String name, String descriptionId, double defaultValue, double min, double max, double scaleFactor) {
        return this.createPercentage(name, descriptionId, defaultValue, min, max, scaleFactor, false);
    }

    public DeferredHolder<Attribute, Attribute> createPercentage(String name, String descriptionId, double defaultValue, double min, double max, double scaleFactor, boolean isSyncable) {
        return this.createPercentage(name, descriptionId, defaultValue, min, max, scaleFactor, isSyncable, Attribute.Sentiment.POSITIVE);
    }

    public DeferredHolder<Attribute, Attribute> createPercentage(String name, String descriptionId, double defaultValue, double min, double max, double scaleFactor, boolean isSyncable, Attribute.Sentiment sentiment) {
        return this.create(name, () -> new PercentageAttribute(descriptionId, defaultValue, min, max, scaleFactor)
                .setSyncable(isSyncable)
                .setSentiment(sentiment));
    }
}
