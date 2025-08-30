package com.temporal.api.core.registry.factory;

import com.temporal.api.core.engine.io.context.InjectionPool;
import com.temporal.api.core.registry.TemporalRegister;
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

    public BlockFactory(TemporalRegister.TemporalBlocks blocks) {
        this(blocks, InjectionPool.getFromInstance(ItemFactory.class));
    }

    public BlockFactory(TemporalRegister.TemporalBlocks blocks, ItemFactory itemFactory) {
        super(blocks);
        this.itemFactory = itemFactory;
    }

    public DeferredBlock<Block> createWithoutItem(String name, BlockBehaviour.Properties properties) {
        return this.createWithoutItem(name, properties, Block::new);
    }

    public <T extends Block> DeferredBlock<T> createWithoutItem(String name, BlockBehaviour.Properties properties, Function<BlockBehaviour.Properties, T> function) {
        return ((TemporalRegister.TemporalBlocks) this.getRegistry()).registerBlock(name, properties, function);
    }

    public DeferredBlock<Block> create(String name, BlockBehaviour.Properties properties) {
        return this.create(name, properties, Block::new);
    }

    public DeferredBlock<Block> create(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        return this.create(name, properties, Block::new, itemProperties);
    }

    public <T extends Block> DeferredBlock<T> create(String name, BlockBehaviour.Properties properties, Function<BlockBehaviour.Properties, T> function) {
        return this.create(name, properties, function, new Item.Properties());
    }

    public <T extends Block> DeferredBlock<T> create(String name, BlockBehaviour.Properties properties, Function<BlockBehaviour.Properties, T> function, Item.Properties itemProperties) {
        DeferredBlock<T> block = ((TemporalRegister.TemporalBlocks) this.getRegistry()).registerBlock(name, properties, function);
        this.itemFactory.create(name, itemProperties, props -> new BlockItem(block.value(), props));
        return block;
    }

    @Override
    public <T extends Block> DeferredBlock<T> create(String name, Supplier<T> supplier) {
        return this.create(name, supplier, new Item.Properties());
    }

    public <T extends Block> DeferredBlock<T> create(String name, Supplier<T> supplier, Item.Properties itemProperties) {
        DeferredBlock<T> block = ((TemporalRegister.TemporalBlocks) this.getRegistry()).register(name, supplier);
        this.itemFactory.create(name, itemProperties, props -> new BlockItem(block.value(), props));
        return block;
    }
}
