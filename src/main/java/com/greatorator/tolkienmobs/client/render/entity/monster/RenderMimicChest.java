package com.greatorator.tolkienmobs.client.render.entity.monster;

import com.greatorator.tolkienmobs.TolkienMobs;
import com.greatorator.tolkienmobs.client.render.model.monster.ModelMimicChest;
import com.greatorator.tolkienmobs.entity.hostile.EntityTMMimicChest;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;

public class RenderMimicChest extends RenderLiving<EntityTMMimicChest> {
    private static final ResourceLocation TEXTURE_HEAD = new ResourceLocation(TolkienMobs.MODID + ":textures/entity/mimicchest/mimicchest.png");

    public static final Factory FACTORY = new Factory();
    private ModelMimicChest modelbase;

    public float scale;

    public RenderMimicChest(RenderManager rendermanagerIn, float scale)
    {
        super(rendermanagerIn, new ModelMimicChest(), 0.0F);
        this.scale = scale;

        this.modelbase = (ModelMimicChest) this.mainModel;
    }

    @Override
    public void doRender(EntityTMMimicChest mimic, double x, double y, double z, float pitch, float yaw) {
        if(mimic.getRevengeTarget() == null && !mimic.isAngry()) {
            ModelMimicChest.renderChest = true;
        }
        else{
            ModelMimicChest.renderChest = false;
        }
        super.doRender(mimic, x, y, z, pitch, yaw);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityTMMimicChest entity) {
        return TEXTURE_HEAD;
    }

    public static class Factory implements IRenderFactory<EntityTMMimicChest> {
        @Override
        public Render<? super EntityTMMimicChest> createRenderFor(RenderManager manager) {
            return new RenderMimicChest(manager,0.5F);
        }
    }
}