package com.temporal.api.core.engine.io.metadata.strategy.field.event;

import com.temporal.api.core.engine.event.handler.BlockEntityTypeEventHandler;
import com.temporal.api.core.engine.io.metadata.annotation.event.RegisterSign;
import com.temporal.api.core.engine.io.metadata.strategy.field.FieldAnnotationStrategy;
import com.temporal.api.core.util.RegistryUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallSignBlock;

import java.lang.reflect.Field;

public class RegisterSignStrategy implements FieldAnnotationStrategy<RegisterSign> {
    @Override
    public void execute(Field field, Object object, RegisterSign annotation) throws Exception {
        var signBlockHolder = (Holder<Block>) field.get(object);
        WallSignBlock wallSignBlock = (WallSignBlock) RegistryUtils.getBlockById(annotation.value());
        Holder<Block> wallSignBlockHolder = wallSignBlock.defaultBlockState().getBlockHolder();
        BlockEntityTypeEventHandler.SIGNS.put(signBlockHolder, wallSignBlockHolder);
    }

    @Override
    public Class<? extends RegisterSign> getAnnotationClass() {
        return RegisterSign.class;
    }
}
