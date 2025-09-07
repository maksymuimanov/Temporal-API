package com.temporal.api.core.engine.event.data.file;

import net.minecraft.data.DataProvider;
import org.jetbrains.annotations.NotNull;

public interface FileProvider extends DataProvider {
    String JSON = ".json";

    @NotNull
    default String getName() {
        return this.getClass().getSimpleName();
    }
}
