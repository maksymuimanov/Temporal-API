package com.temporal.api.core.registry.factory.other;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public final class BlockPropertiesFactory {
    private BlockPropertiesFactory() {
    }

    public static Properties empty() {
        return Properties.of();
    }

    public static Properties wool() {
        return copy(Blocks.WHITE_WOOL);
    }

    public static Properties dirt() {
        return copy(Blocks.DIRT);
    }

    public static Properties stone() {
        return copy(Blocks.STONE);
    }

    public static Properties deepslate() {
        return copy(Blocks.DEEPSLATE);
    }

    public static Properties metal() {
        return copy(Blocks.IRON_BLOCK);
    }

    public static Properties bricks() {
        return copy(Blocks.BRICKS);
    }

    public static Properties shortGrass() {
        return copy(Blocks.SHORT_GRASS);
    }

    public static Properties bush() {
        return copy(Blocks.SWEET_BERRY_BUSH);
    }

    public static Properties flower() {
        return copy(Blocks.ALLIUM);
    }

    public static Properties mushroom() {
        return copy(Blocks.BROWN_MUSHROOM);
    }

    public static Properties flowerPot() {
        return copy(Blocks.FLOWER_POT);
    }

    public static Properties crop() {
        return copy(Blocks.CARROTS);
    }

    public static Properties sapling() {
        return copy(Blocks.OAK_SAPLING);
    }

    public static Properties leaves() {
        return copy(Blocks.OAK_LEAVES);
    }

    public static Properties wood() {
        return copy(Blocks.OAK_WOOD);
    }

    public static Properties planks() {
        return copy(Blocks.OAK_PLANKS);
    }

    public static Properties button() {
        return copy(Blocks.OAK_BUTTON);
    }

    public static Properties pressurePlate() {
        return copy(Blocks.OAK_PRESSURE_PLATE);
    }

    public static Properties fence() {
        return copy(Blocks.OAK_FENCE);
    }

    public static Properties fenceGate() {
        return copy(Blocks.OAK_FENCE_GATE);
    }

    public static Properties wall() {
        return copy(Blocks.COBBLESTONE_WALL);
    }

    public static Properties door() {
        return copy(Blocks.OAK_DOOR);
    }

    public static Properties trapDoor() {
        return copy(Blocks.OAK_TRAPDOOR);
    }

    public static Properties chain() {
        return copy(Blocks.CHAIN);
    }

    public static Properties copy(BlockBehaviour block) {
        return Properties.ofFullCopy(block);
    }
}
