package com.temporal.api.common.block;

import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

public class ApiCropBlock extends CropBlock {
    public ApiCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    @NotNull
    public IntegerProperty getAgeProperty() {
        return super.getAgeProperty();
    }
}
