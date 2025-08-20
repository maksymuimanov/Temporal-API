package com.temporal.api.common.block;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StrippableLogBlock extends LogBlock {
    public final Block strippedResult;

    public StrippableLogBlock(Block strippedResult, Properties properties) {
        super(properties);
        this.strippedResult = strippedResult;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(@NotNull BlockState state, @NotNull UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (itemAbility.equals(ItemAbilities.AXE_STRIP) && this.strippedResult != null) {
            return this.strippedResult.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
