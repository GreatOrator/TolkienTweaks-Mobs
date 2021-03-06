//package com.greatorator.tolkienmobs.client.render.entity.monster;
//
//import com.greatorator.tolkienmobs.TolkienMobs;
//import com.greatorator.tolkienmobs.entity.hostile.EntityTMMirkwoodSpider;
//import com.greatorator.tolkienmobs.client.render.model.monster.ModelMirkwoodSpider;
//import net.minecraft.client.renderer.entity.Render;
//import net.minecraft.client.renderer.entity.RenderLiving;
//import net.minecraft.client.renderer.entity.RenderManager;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.client.registry.IRenderFactory;
//
//import javax.annotation.Nonnull;
//
//public class RenderMirkwoodSpider extends RenderLiving<EntityTMMirkwoodSpider> {
//    private ResourceLocation mobTexture = new ResourceLocation(TolkienMobs.MODID + ":textures/entity/mirkwoodspider.png");
//
//    public static final Factory FACTORY = new Factory();
//
//    public RenderMirkwoodSpider(RenderManager rendermanagerIn) {
//        super(rendermanagerIn, new ModelMirkwoodSpider(), 0.5F);
//    }
//
//    @Override
//    @Nonnull
//    protected ResourceLocation getEntityTexture(@Nonnull EntityTMMirkwoodSpider entity) {
//        return mobTexture;
//    }
//
//    public static class Factory implements IRenderFactory<EntityTMMirkwoodSpider> {
//        @Override
//        public Render<? super EntityTMMirkwoodSpider> createRenderFor(RenderManager manager) {
//            return new RenderMirkwoodSpider(manager);
//        }
//    }
//}