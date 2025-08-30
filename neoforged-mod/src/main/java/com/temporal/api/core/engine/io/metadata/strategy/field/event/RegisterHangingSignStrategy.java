package com.temporal.api.core.engine.io.metadata.strategy.field.event;

import com.temporal.api.core.engine.event.handler.BlockEntityTypeEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.RegisterHangingSign;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallHangingSignBlock;

import java.lang.reflect.Field;

public class RegisterHangingSignStrategy implements FieldAnnotationStrategy<RegisterHangingSign> {
    @Override
    public void execute(Field field, Object object, RegisterHangingSign annotation) throws Exception {
        var ceilingSignBlockHolder = (Holder<Block>) field.get(object);
        WallHangingSignBlock wallHangingSignBlock = (WallHangingSignBlock) RegistryUtils.getBlockById(annotation.value());
        Holder<Block> wallHangingSignBlockHolder = wallHangingSignBlock.defaultBlockState().getBlockHolder();
        BlockEntityTypeEventHandler.HANGING_SIGNS.put(ceilingSignBlockHolder, wallHangingSignBlockHolder);
    }

    @Override
    public Class<? extends RegisterHangingSign> getAnnotationClass() {
        return RegisterHangingSign.class;
    }
}
