package net.temporal.example.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.temporal.example.entity.ExampleEntity;
import net.temporal.example.entity.model.ExampleEntityModel;

public class ExampleRenderer extends MobRenderer<ExampleEntity, ExampleEntityModel<ExampleEntity>> {
    public ExampleRenderer(EntityRendererProvider.Context context) {
        super(context, new ExampleEntityModel<>(context.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ExampleEntity exampleEntity) {
        return ResourceUtils.parse("textures/entity/example_entity.png");
    }

    @Override
    public void render(ExampleEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.6F, 0.6F, 0.6F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
