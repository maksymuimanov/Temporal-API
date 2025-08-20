package com.temporal.api.client.animation;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public class LegAnimationHelper {
    public static void animateDefault(ModelPart leg1, ModelPart leg2, ModelPart leg3, ModelPart leg4, AnimationDirection animationDirection, float limbSwing, float limbSwingAmount) {
        float movement1 = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        float movement2 = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

        switch (animationDirection) {
            case X -> {
                leg1.xRot = movement1;
                leg2.xRot = movement2;
                leg3.xRot = movement2;
                leg4.xRot = movement1;
            }
            case Y -> {
                leg1.yRot = movement1;
                leg2.yRot = movement2;
                leg3.yRot = movement2;
                leg4.yRot = movement1;
            }
            case Z -> {
                leg1.zRot = movement1;
                leg2.zRot = movement2;
                leg3.zRot = movement2;
                leg4.zRot = movement1;
            }
        }
    }
}
