package com.greatorator.tolkienmobs.entity.merchant.render;

import com.greatorator.tolkienmobs.entity.EntityTTMVillager;
import com.greatorator.tolkienmobs.entity.merchant.EntityTTMElves;
import com.greatorator.tolkienmobs.entity.merchant.model.ModelTTMElves;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderTTMElves extends MobRenderer<EntityTTMElves, ModelTTMElves<EntityTTMElves>> {
    public RenderTTMElves(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelTTMElves<>(), 1.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityTTMElves entity) {
        return entity.getElvesTypeName();
    }

    protected void preRenderCallback(EntityTTMVillager entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        float f = 0.98F;
        if (entitylivingbaseIn.isChild()) {
            f = (float) ((double) f * 0.5D);
            this.shadowSize = 0.25F;
        } else {
            this.shadowSize = 0.5F;
        }

        matrixStackIn.scale(f, f, f);
    }
}