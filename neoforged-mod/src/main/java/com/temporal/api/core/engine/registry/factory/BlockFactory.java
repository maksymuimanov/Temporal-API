package com.temporal.api.core.engine.registry.factory;

import com.temporal.api.core.engine.context.InjectionPool;
import com.temporal.api.core.engine.registry.TemporalRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockFactory extends AbstractObjectFactory<Block> {
    private final ItemFactory itemFactory;

    public BlockFactory() {
        this(InjectionPool.getFromInstance("$Blocks"));
    }

    public BlockFactory(final TemporalRegister<Block> blocks) {
        this(blocks, InjectionPool.getFromInstance(ItemFactory.class));
    }

    public BlockFactory(final TemporalRegister<Block> blocks, final ItemFactory itemFactory) {
        super(blocks);
        this.itemFactory = itemFactory;
    }

    public DeferredBlock<Block> createWithoutItem(final String name, final BlockBehaviour.Properties properties) {
        return createWithoutItem(name, properties, Block::new);
    }

    public <T extends Block> DeferredBlock<T> createWithoutItem(final String name, final BlockBehaviour.Properties properties, final Function<BlockBehaviour.Properties, T> function) {
        return create(name, () -> function.apply(properties));
    }

    public DeferredBlock<Block> create(final String name, final BlockBehaviour.Properties properties) {
        return create(name, properties, Block::new);
    }

    public DeferredBlock<Block> create(final String name, final BlockBehaviour.Properties properties, final Item.Properties itemProperties) {
        return create(name, properties, Block::new, itemProperties);
    }

    public <T extends Block> DeferredBlock<T> create(final String name, final BlockBehaviour.Properties properties, final Function<BlockBehaviour.Properties, T> function) {
        return create(name, properties, function, new Item.Properties());
    }

    public <T extends Block> DeferredBlock<T> create(final String name, final BlockBehaviour.Properties properties, final Function<BlockBehaviour.Properties, T> function, final Item.Properties itemProperties) {
        final DeferredBlock<T> block = create(name, () -> function.apply(properties));
        itemFactory.create(name, itemProperties, props -> new BlockItem(block.value(), props));
        return block;
    }

    @Override
    public <T extends Block> DeferredBlock<T> create(final String name, final Supplier<T> supplier) {
        return create(name, supplier, new Item.Properties());
    }

    public <T extends Block> DeferredBlock<T> create(final String name, final Supplier<T> supplier, final Item.Properties itemProperties) {
        final DeferredBlock<T> block = create(name, supplier);
        itemFactory.create(name, itemProperties, props -> new BlockItem(block.value(), props));
        return block;
    }
}
