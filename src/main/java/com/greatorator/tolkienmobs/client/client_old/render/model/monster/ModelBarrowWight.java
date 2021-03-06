//package com.greatorator.tolkienmobs.client.render.model.monster;
//
//import com.greatorator.tolkienmobs.client.render.model.ModelTTM;
//import com.greatorator.tolkienmobs.entity.hostile.EntityTMBarrowWight;
//import net.minecraft.client.model.ModelBiped;
//import net.minecraft.client.model.ModelRenderer;
//import net.minecraft.client.renderer.GlStateManager;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.init.Items;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.EnumHand;
//import net.minecraft.util.EnumHandSide;
//import net.minecraft.util.math.MathHelper;
//
///**
// * Barrow Wight - GreatOrator
// */
//public class ModelBarrowWight extends ModelTTM {
//    public ModelRenderer bipedLeftArmwear;
//    public ModelRenderer bipedRightLegwear;
//    public ModelRenderer bipedRightArmwear;
//    public ModelRenderer bipedDeadmau5Head;
//    public ModelRenderer bipedLeftLegwear;
//    public ModelRenderer bipedRightLeg;
//    public ModelRenderer bipedHead;
//    public ModelRenderer bipedBody;
//    public ModelRenderer bipedLeftLeg;
//    public ModelRenderer bipedBodyWear;
//    private boolean ghostModel;
//
//    public ModelBarrowWight(boolean ghostModel) {
//        this.ghostModel = ghostModel;
//            this.textureWidth = 64;
//            this.textureHeight = 64;
//            this.bipedRightArmwear = new ModelRenderer(this, 40, 32);
//            this.bipedRightArmwear.setRotationPoint(-5.0F, 2.0F, 0.0F);
//            this.bipedRightArmwear.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F);
//            this.bipedRightArm = new ModelRenderer(this, 40, 16);
//            this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
//            this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
//            this.bipedBody = new ModelRenderer(this, 16, 16);
//            this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
//            this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
//            this.bipedRightLegwear = new ModelRenderer(this, 0, 32);
//            this.bipedRightLegwear.setRotationPoint(-1.9F, 12.0F, 0.0F);
//            this.bipedRightLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
//            this.bipedLeftLegwear = new ModelRenderer(this, 0, 48);
//            this.bipedLeftLegwear.setRotationPoint(1.9F, 12.0F, 0.0F);
//            this.bipedLeftLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
//            this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
//            this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
//            this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
//            this.bipedLeftArmwear = new ModelRenderer(this, 48, 48);
//            this.bipedLeftArmwear.setRotationPoint(5.0F, 2.0F, 0.0F);
//            this.bipedLeftArmwear.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F);
//            this.bipedDeadmau5Head = new ModelRenderer(this, 32, 0);
//            this.bipedDeadmau5Head.setRotationPoint(0.0F, 0.0F, 0.0F);
//            this.bipedDeadmau5Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
//            this.bipedBodyWear = new ModelRenderer(this, 16, 32);
//            this.bipedBodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
//            this.bipedBodyWear.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F);
//            this.bipedRightLeg = new ModelRenderer(this, 0, 16);
//            this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
//            this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
//            this.bipedHead = new ModelRenderer(this, 0, 0);
//            this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
//            this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
//            this.bipedLeftArm = new ModelRenderer(this, 32, 48);
//            this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
//            this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
//    }
//
//    @Override
//    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
//        if (ghostModel) {
//            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//            GlStateManager.enableNormalize();
//            GlStateManager.enableBlend();
//            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
//        }
//            this.bipedHead.render(f5);
//            this.bipedRightArm.render(f5);
//            this.bipedRightLeg.render(f5);
//            this.bipedLeftLeg.render(f5);
//            this.bipedBody.render(f5);
//            this.bipedLeftArm.render(f5);
//
//            this.bipedLeftLegwear.render(f5);
//            this.bipedRightLegwear.render(f5);
//            this.bipedLeftArmwear.render(f5);
//            this.bipedRightArmwear.render(f5);
//            this.bipedBodyWear.render(f5);
//
//            copyModelAngles(this.bipedHead, this.bipedDeadmau5Head);
//            this.bipedDeadmau5Head.rotationPointX = 0.0F;
//            this.bipedDeadmau5Head.rotationPointY = 0.0F;
//            this.bipedDeadmau5Head.render(f5);
//        if (ghostModel) {
//            GlStateManager.disableBlend();
//            GlStateManager.disableNormalize();
//        }
//    }
//
//    public void setLivingAnimations(LivingEntity LivingEntityIn, float limbSwing, float limbSwingAmount, float partialTickTime)
//    {
//        this.rightArmPose = ModelBiped.ArmPose.EMPTY;
//        this.leftArmPose = ModelBiped.ArmPose.EMPTY;
//        ItemStack itemstack = LivingEntityIn.getHeldItem(EnumHand.MAIN_HAND);
//
//        if (itemstack.getItem() == Items.BOW && ((EntityTMBarrowWight)LivingEntityIn).isSwingingArms())
//        {
//            if (LivingEntityIn.getPrimaryHand() == EnumHandSide.RIGHT)
//            {
//                this.rightArmPose = ModelBiped.ArmPose.ITEM;
//            }
//            else
//            {
//                this.leftArmPose = ModelBiped.ArmPose.ITEM;
//            }
//        }
//
//        super.setLivingAnimations(LivingEntityIn, limbSwing, limbSwingAmount, partialTickTime);
//    }
//
//    @Override
//    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
//        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
//
//        copyModelAngles(this.bipedLeftLeg, this.bipedLeftLegwear);
//        copyModelAngles(this.bipedRightLeg, this.bipedRightLegwear);
//        copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
//        copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
//        copyModelAngles(this.bipedBody, this.bipedBodyWear);
//
//        this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
//        this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
//
//        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
//        this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
//
//        this.bipedHead.rotateAngleY = netHeadYaw * 0.017453292F;
//        this.bipedHead.rotateAngleX = headPitch * 0.017453292F;
//
//        this.bipedRightArm.rotationPointX = -5.0F;
//        this.bipedLeftArm.rotationPointX = 5.0F;
//    }
//}