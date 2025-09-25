package net.temporal.example.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.temporal.api.core.engine.metadata.annotation.event.layer.RegisterLayerDefinition;
import com.temporal.api.core.util.ResourceUtils;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.temporal.example.entity.ExampleEntity;
import org.jetbrains.annotations.NotNull;

@RegisterLayerDefinition
public class ExampleEntityModel<T extends ExampleEntity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceUtils.createLocation("example_entity"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;

	public ExampleEntityModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.tail = root.getChild("tail");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();
		PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(34, 42)
				.addBox(-6.0F, -7.0F, -19.0F, 11.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 42)
				.addBox(-7.0F, -10.0F, -14.0F, 13.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 25.0F, 1.0F));
		PartDefinition body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create()
				.texOffs(0, 0)
				.addBox(-7.0F, -10.0F, -10.0F, 13.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 25.0F, 1.0F));
		PartDefinition tail = partDefinition.addOrReplaceChild("tail", CubeListBuilder.create()
				.texOffs(0, 24)
				.addBox(-6.0F, -9.0F, 8.0F, 11.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 25.0F, 1.0F));
		PartDefinition leg1 = partDefinition.addOrReplaceChild("leg1", CubeListBuilder.create()
				.texOffs(48, 24)
				.addBox(4.0F, -3.0F, -9.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition leg2 = partDefinition.addOrReplaceChild("leg2", CubeListBuilder.create()
				.texOffs(48, 30)
				.addBox(-7.0F, -3.0F, -9.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition leg3 = partDefinition.addOrReplaceChild("leg3", CubeListBuilder.create()
				.texOffs(48, 36)
				.addBox(-7.0F, -3.0F, 3.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition leg4 = partDefinition.addOrReplaceChild("leg4", CubeListBuilder.create()
				.texOffs(34, 50)
				.addBox(4.0F, -3.0F, 3.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshDefinition, 128, 128);
	}

	@Override
	public void setupAnim(@NotNull ExampleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}