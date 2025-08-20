package com.temporal.api.core.registry.factory.common;

import com.temporal.api.core.engine.io.context.InjectionPool;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public class BlockFactory extends AbstractObjectFactory<Block> {
    private final DeferredRegister.Blocks blocks;
    private final ItemFactory itemFactory;

    public BlockFactory() {
        this(InjectionPool.getFromInstance("$Blocks"));
    }

    public BlockFactory(DeferredRegister.Blocks blocks) {
        this(blocks, InjectionPool.getFromInstance(ItemFactory.class));
    }

    public BlockFactory(DeferredRegister.Blocks blocks, ItemFactory itemFactory) {
        this.blocks = blocks;
        this.itemFactory = itemFactory;
    }

    public <T extends Block> DeferredBlock<T> createWithoutItem(String name, BlockBehaviour.Properties properties) {
        return (DeferredBlock<T>) blocks.registerBlock(name, Block::new, properties);
    }

    public <T extends Block> DeferredBlock<T> createWithoutItem(String name, BlockBehaviour.Properties properties, Function<BlockBehaviour.Properties, ? extends Block> function) {
        return (DeferredBlock<T>) blocks.registerBlock(name, function, properties);
    }

    public <T extends Block> DeferredBlock<T> create(String name, BlockBehaviour.Properties properties) {
        return create(name, properties, new Item.Properties());
    }

    public <T extends Block> DeferredBlock<T> create(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        return create(name, properties, Block::new, itemProperties);
    }

    public <T extends Block> DeferredBlock<T> create(String name, BlockBehaviour.Properties properties, Function<BlockBehaviour.Properties, ? extends Block> function) {
        return create(name, properties, function, new Item.Properties());
    }

    public <T extends Block> DeferredBlock<T> create(String name, BlockBehaviour.Properties properties, Function<BlockBehaviour.Properties, ? extends Block> function, Item.Properties itemProperties) {
        DeferredBlock<T> block = (DeferredBlock<T>) blocks.registerBlock(name, function, properties);
        this.itemFactory.create(name, itemProperties, props -> new BlockItem(block.value(), props));
        return block;
    }

    @Override
    public <T extends Block> DeferredBlock<T> create(String name, Supplier<T> supplier) {
        return create(name, supplier, new Item.Properties());
    }

    public <T extends Block> DeferredBlock<T> create(String name, Supplier<T> supplier, Item.Properties itemProperties) {
        DeferredBlock<T> block = blocks.register(name, supplier);
        this.itemFactory.create(name, itemProperties, props -> new BlockItem(block.value(), props));
        return block;
    }

    @Override
    public DeferredRegister<Block> getRegistry() {
        return blocks;
    }
}
