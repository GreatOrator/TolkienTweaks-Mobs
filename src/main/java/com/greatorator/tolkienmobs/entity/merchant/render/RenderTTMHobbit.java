package com.greatorator.tolkienmobs.entity.merchant.render;

import com.greatorator.tolkienmobs.entity.merchant.EntityTTMHobbit;
import com.greatorator.tolkienmobs.entity.merchant.model.ModelTTMHobbit;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderTTMHobbit extends MobRenderer<EntityTTMHobbit, ModelTTMHobbit<EntityTTMHobbit>> {
public RenderTTMHobbit(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelTTMHobbit<>(), 1.0F);
        }

@Override
public ResourceLocation getEntityTexture(EntityTTMHobbit entity) {
        return entity.getHobbitTypeName();
        }

protected void preRenderCallback(EntityTTMHobbit entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        float f = 0.7F;
        if (entitylivingbaseIn.isChild()) {
        f = (float)((double)f * 0.5D);
        this.shadowSize = 0.25F;
        } else {
        this.shadowSize = 0.5F;
        }

        matrixStackIn.scale(f, f, f);
        }
}