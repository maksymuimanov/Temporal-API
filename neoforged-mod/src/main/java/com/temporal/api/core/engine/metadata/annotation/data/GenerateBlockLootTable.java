package com.temporal.api.core.engine.metadata.annotation.data;

import com.temporal.api.core.engine.event.data.loot.LootProviderStrategy;
import com.temporal.api.core.engine.metadata.constant.BlockLootTableType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateBlockLootTable {
    BlockLootTableType value() default BlockLootTableType.SELF;

    String[] additionalData() default {};

    Class<? extends LootProviderStrategy> custom() default LootProviderStrategy.class;
}