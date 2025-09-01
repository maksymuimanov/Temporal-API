package com.temporal.api.core.event.data.model.block;

import com.temporal.api.common.block.ApiCropBlock;
import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.util.RegistryUtils;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.BiConsumer;
import java.util.function.Function;

public class ApiBlockModelProvider extends BlockStateProvider {
    private static final BlockModelProviderStrategyConsumer CONSUMER = new BlockModelProviderStrategyConsumerImpl();
    public static final String MINECRAFT_CUTOUT = "minecraft:cutout";
    public static final String BLOCK_PREFIX = "block";
    public static final String BLOCK_PREFIX_PATH = BLOCK_PREFIX + "/";

    public ApiBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IOLayer.NEO_MOD.getModId(), existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        CONSUMER.registerModels(this);
    }

    public <T extends Block> void familyMember(T block, String parentId, BiConsumer<T, ResourceLocation> blockModelRegistry) {
        String parentBlockPath = this.getBlockPath(RegistryUtils.getBlock(parentId));
        ResourceLocation parentTexture = ResourceUtils.parse(parentBlockPath);
        blockModelRegistry.accept(block, parentTexture);
    }

    public void cropBlock(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    @SuppressWarnings("unchecked")
    public <T extends ApiCropBlock> ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        Integer age = state.getValue(((T) block).getAgeProperty());
        models[0] = new ConfiguredModel(models().crop(modelName + age, ResourceUtils.parse(BLOCK_PREFIX_PATH + textureName + age)).renderType(MINECRAFT_CUTOUT));
        return models;
    }

    public String getBlockPath(Block block) {
        return RegistryUtils.getObjectName(BuiltInRegistries.BLOCK, block, BLOCK_PREFIX);
    }
}
