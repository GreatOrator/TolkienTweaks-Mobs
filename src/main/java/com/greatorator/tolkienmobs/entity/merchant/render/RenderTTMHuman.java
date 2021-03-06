package com.greatorator.tolkienmobs.entity.merchant.render;

import com.greatorator.tolkienmobs.entity.merchant.EntityTTMHuman;
import com.greatorator.tolkienmobs.entity.merchant.model.ModelTTMHuman;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderTTMHuman extends MobRenderer<EntityTTMHuman, ModelTTMHuman<EntityTTMHuman>> {
    public RenderTTMHuman(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelTTMHuman<>(), 1.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityTTMHuman entity) {
        return entity.getHumanTypeName();
    }

    protected void preRenderCallback(EntityTTMHuman entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        float f = 0.93F;
        if (entitylivingbaseIn.isChild()) {
            f = (float)((double)f * 0.5D);
            this.shadowSize = 0.25F;
        } else {
            this.shadowSize = 0.5F;
        }

        matrixStackIn.scale(f, f, f);
    }
}