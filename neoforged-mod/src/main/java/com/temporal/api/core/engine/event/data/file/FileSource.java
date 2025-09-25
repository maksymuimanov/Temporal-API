package com.temporal.api.core.engine.event.data.file;

import net.minecraft.data.PackOutput;

public record FileSource(PackOutput.Target target, String modId, String path) {
}
