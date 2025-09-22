package com.temporal.api.core.engine.metadata.annotation.data.loot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateCropBlockLootTable {
    String grown();
    String seeds();
    int grownAge();
    int minAge();
    int maxAge();
}