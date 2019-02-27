package com.greatorator.tolkienmobs.client.render.model.boss;

import com.greatorator.tolkienmobs.client.render.model.ModelTTM;
import com.greatorator.tolkienmobs.entity.boss.EntityBalrog;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

/** Balrog - GreatOrator & Boyd151995 */
public class ModelBalrog extends ModelTTM {
    public ModelRenderer BalrogBody;
    public ModelRenderer BalrogNeck;
    public ModelRenderer BalrogTail1;
    public ModelRenderer BalrogLegR;
    public ModelRenderer BalrogLegL;
    public ModelRenderer BalrogChest;
    public ModelRenderer BalrogWingR;
    public ModelRenderer BalrogWingL;
    public ModelRenderer BalrogWingSkin2;
    public ModelRenderer BalrogWingBone2R;
    public ModelRenderer BalrogWingBone3R;
    public ModelRenderer wingfingerl132;
    public ModelRenderer wingfingerl122;
    public ModelRenderer wingfingerl14;
    public ModelRenderer BalrogWingBone4R;
    public ModelRenderer BalrogWingBone5R;
    public ModelRenderer BalrogWingBone6R;
    public ModelRenderer BalrogWingSkin1;
    public ModelRenderer BalrogWingBone2L;
    public ModelRenderer BalrogWingBone3L;
    public ModelRenderer wingfingerl1;
    public ModelRenderer wingfingerl12;
    public ModelRenderer wingfingerl13;
    public ModelRenderer BalrogWingBone4L;
    public ModelRenderer BalrogWingBone5L;
    public ModelRenderer BalrogWingBone6L;
    public ModelRenderer BalrogSkull;
    public ModelRenderer BalrogHornR1;
    public ModelRenderer BalrogHornL1;
    public ModelRenderer BalrogMouth;
    public ModelRenderer BalrogHornR2;
    public ModelRenderer BalrogHornR3;
    public ModelRenderer BalrogHornR4;
    public ModelRenderer BalrogHornR4_1;
    public ModelRenderer BalrogHornL2;
    public ModelRenderer BalrogHornL3;
    public ModelRenderer BalrogHornL4;
    public ModelRenderer BalrogHornL4_1;
    public ModelRenderer BalrogTooth1;
    public ModelRenderer BalrogTooth2;
    public ModelRenderer BalrogTooth3;
    public ModelRenderer BalrogTooth4;
    public ModelRenderer BalrogTooth22;
    public ModelRenderer BalrogTooth42;
    public ModelRenderer BalrogTooth32;
    public ModelRenderer BalrogTooth12;
    public ModelRenderer bipedRightArmLower;
    public ModelRenderer bipedLeftArmLower;
    public ModelRenderer BalrogTail2;
    public ModelRenderer BalrogTail3;
    public ModelRenderer BalrogTail4;
    public ModelRenderer BalrogTail5;
    public ModelRenderer LegLowR;
    public ModelRenderer LegLLR;
    public ModelRenderer FeetR;
    public ModelRenderer FeetR1;
    public ModelRenderer FeetR2;
    public ModelRenderer LegLowR_1;
    public ModelRenderer LegLLR_1;
    public ModelRenderer FeetR_1;
    public ModelRenderer FeetR1_1;
    public ModelRenderer FeetR2_1;

    public ModelBalrog() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.BalrogHornL4_1 = new ModelRenderer(this, 115, 2);
        this.BalrogHornL4_1.setRotationPoint(4.400000095367432F, 0.5F, 0.4000000059604645F);
        this.BalrogHornL4_1.addBox(0.0F, -1.5F, -1.600000023841858F, 5, 1, 1, 0.0F);
        this.setRotateAngle(BalrogHornL4_1, 0.0F, 0.17453292519943295F, 0.0F);
        this.BalrogTooth12 = new ModelRenderer(this, 0, 28);
        this.BalrogTooth12.setRotationPoint(0.699999988079071F, 2.4000000953674316F, -4.699999809265137F);
        this.BalrogTooth12.addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(BalrogTooth12, 0.08726646259971647F, 0.0F, 0.0F);
        this.wingfingerl122 = new ModelRenderer(this, 122, 103);
        this.wingfingerl122.setRotationPoint(33.70000076293945F, 6.699999809265137F, -0.30000001192092896F);
        this.wingfingerl122.addBox(0.0F, 0.0F, 0.0F, 2, 24, 1, 0.0F);
        this.setRotateAngle(wingfingerl122, 0.0F, 0.0F, 0.8208283259076444F);
        this.BalrogTooth42 = new ModelRenderer(this, 0, 28);
        this.BalrogTooth42.setRotationPoint(-0.699999988079071F, -1.2000000476837158F, -4.599999904632568F);
        this.BalrogTooth42.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(BalrogTooth42, -0.2617993877991494F, 0.0F, 0.0F);
        this.wingfingerl14 = new ModelRenderer(this, 122, 103);
        this.wingfingerl14.setRotationPoint(0.0F, 5.800000190734863F, -0.30000001192092896F);
        this.wingfingerl14.addBox(0.0F, 0.0F, 0.0F, 2, 24, 1, 0.0F);
        this.setRotateAngle(wingfingerl14, 0.0F, 0.0F, -0.6806784082777886F);
        this.BalrogWingBone2L = new ModelRenderer(this, 38, 26);
        this.BalrogWingBone2L.setRotationPoint(6.5F, 0.5F, 0.5F);
        this.BalrogWingBone2L.addBox(0.0F, -1.0F, -1.0F, 17, 1, 1, 0.0F);
        this.FeetR2 = new ModelRenderer(this, 67, 62);
        this.FeetR2.setRotationPoint(0.5F, 0.5F, 0.10000000149011612F);
        this.FeetR2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(FeetR2, -0.5201081037785047F, 0.0F, 0.0F);
        this.BalrogHornR1 = new ModelRenderer(this, 114, 0);
        this.BalrogHornR1.setRotationPoint(-3.5F, -2.799999952316284F, 0.0F);
        this.BalrogHornR1.addBox(-5.0F, -1.5F, -1.5F, 5, 3, 3, 0.0F);
        this.setRotateAngle(BalrogHornR1, -0.17453292519943295F, 0.17453292519943295F, 0.5235987755982988F);
        this.bipedLeftArmLower = new ModelRenderer(this, 0, 31);
        this.bipedLeftArmLower.mirror = true;
        this.bipedLeftArmLower.setRotationPoint(3.0F, 8.0F, 1.0F);
        this.bipedLeftArmLower.addBox(-2.5F, 0.0F, -3.0F, 4, 13, 4, 0.0F);
        this.setRotateAngle(bipedLeftArmLower, -0.17453292519943295F, 0.0F, 0.0F);
        this.FeetR = new ModelRenderer(this, 56, 56);
        this.FeetR.setRotationPoint(-0.5F, 15.699999809265137F, -0.800000011920929F);
        this.FeetR.addBox(0.0F, 0.0F, 0.0F, 5, 2, 6, 0.0F);
        this.setRotateAngle(FeetR, 0.9056513382072132F, 0.0F, 0.0F);
        this.BalrogChest = new ModelRenderer(this, 82, 26);
        this.BalrogChest.setRotationPoint(0.0F, 11.199999809265137F, 0.0F);
        this.BalrogChest.addBox(-8.0F, 0.0F, -3.5F, 16, 10, 7, 0.0F);
        this.setRotateAngle(BalrogChest, -0.5094616179782085F, 0.0F, 0.0F);
        this.BalrogSkull = new ModelRenderer(this, 45, 30);
        this.BalrogSkull.setRotationPoint(0.0F, -6.5F, -1.7999999523162842F);
        this.BalrogSkull.addBox(-4.5F, -4.5F, -4.5F, 9, 9, 9, 0.0F);
        this.setRotateAngle(BalrogSkull, -0.17453292519943295F, 0.0F, 0.0F);
        this.FeetR2_1 = new ModelRenderer(this, 67, 62);
        this.FeetR2_1.setRotationPoint(0.5F, 0.5F, 0.10000000149011612F);
        this.FeetR2_1.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(FeetR2_1, -0.5201081037785047F, 0.0F, 0.0F);
        this.wingfingerl12 = new ModelRenderer(this, 122, 103);
        this.wingfingerl12.setRotationPoint(33.70000076293945F, 6.699999809265137F, -0.30000001192092896F);
        this.wingfingerl12.addBox(0.0F, 0.0F, 0.0F, 2, 24, 1, 0.0F);
        this.setRotateAngle(wingfingerl12, 0.0F, 0.0F, 0.8208283259076444F);
        this.BalrogTooth2 = new ModelRenderer(this, 0, 28);
        this.BalrogTooth2.setRotationPoint(-2.0999999046325684F, 2.200000047683716F, -4.699999809265137F);
        this.BalrogTooth2.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(BalrogTooth2, 0.08726646259971647F, 0.0F, 0.0F);
        this.BalrogWingBone4L = new ModelRenderer(this, 38, 26);
        this.BalrogWingBone4L.setRotationPoint(16.200000762939453F, -0.20000000298023224F, 0.0F);
        this.BalrogWingBone4L.addBox(0.0F, -1.0F, -1.0F, 17, 2, 2, 0.0F);
        this.setRotateAngle(BalrogWingBone4L, 0.0F, 0.0F, 0.3490658503988659F);
        this.BalrogTooth1 = new ModelRenderer(this, 0, 28);
        this.BalrogTooth1.setRotationPoint(2.0999999046325684F, 2.200000047683716F, -4.699999809265137F);
        this.BalrogTooth1.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(BalrogTooth1, 0.08726646259971647F, 0.0F, 0.0F);
        this.BalrogTail2 = new ModelRenderer(this, 25, 52);
        this.BalrogTail2.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.BalrogTail2.addBox(-2.0F, -2.0F, 0.0F, 3, 3, 8, 0.0F);
        this.setRotateAngle(BalrogTail2, 0.16982053621904827F, 0.0F, 0.0F);
        this.LegLowR_1 = new ModelRenderer(this, 22, 43);
        this.LegLowR_1.mirror = true;
        this.LegLowR_1.setRotationPoint(2.5F, 6.5F, -1.5F);
        this.LegLowR_1.addBox(-2.5F, 0.0F, -2.5F, 5, 16, 5, 0.0F);
        this.setRotateAngle(LegLowR_1, 1.3962634015954636F, 0.0F, 0.0F);
        this.BalrogWingBone2R = new ModelRenderer(this, 38, 26);
        this.BalrogWingBone2R.mirror = true;
        this.BalrogWingBone2R.setRotationPoint(6.5F, 0.5F, 0.5F);
        this.BalrogWingBone2R.addBox(0.0F, -1.0F, -1.0F, 17, 1, 1, 0.0F);
        this.BalrogHornL3 = new ModelRenderer(this, 114, 1);
        this.BalrogHornL3.setRotationPoint(4.0F, -0.20000000298023224F, 0.0F);
        this.BalrogHornL3.addBox(0.0F, -1.5F, -1.600000023841858F, 5, 2, 2, 0.0F);
        this.setRotateAngle(BalrogHornL3, 0.0F, 0.3490658503988659F, 0.8726646259971648F);
        this.bipedLeftArm = new ModelRenderer(this, 0, 48);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.setRotationPoint(8.5F, -20.0F, 0.5F);
        this.bipedLeftArm.addBox(0.0F, -1.5F, -3.0F, 5, 10, 6, 0.0F);
        this.wingfingerl1 = new ModelRenderer(this, 122, 103);
        this.wingfingerl1.setRotationPoint(0.0F, 5.800000190734863F, -0.30000001192092896F);
        this.wingfingerl1.addBox(0.0F, 0.0F, 0.0F, 2, 24, 1, 0.0F);
        this.setRotateAngle(wingfingerl1, 0.0F, 0.0F, -0.6806784082777886F);
        this.BalrogNeck = new ModelRenderer(this, 106, 15);
        this.BalrogNeck.setRotationPoint(0.0F, -22.0F, -1.0F);
        this.BalrogNeck.addBox(-2.5F, -4.5F, -2.5F, 5, 6, 5, 0.0F);
        this.setRotateAngle(BalrogNeck, 0.17453292519943295F, 0.0F, 0.0F);
        this.BalrogHornL2 = new ModelRenderer(this, 114, 1);
        this.BalrogHornL2.setRotationPoint(4.5F, 0.30000001192092896F, 0.5F);
        this.BalrogHornL2.addBox(0.0F, -1.5F, -1.5F, 5, 2, 2, 0.0F);
        this.setRotateAngle(BalrogHornL2, 0.0F, 0.17453292519943295F, 0.3490658503988659F);
        this.BalrogMouth = new ModelRenderer(this, 16, 28);
        this.BalrogMouth.setRotationPoint(0.0F, 3.5F, -2.0F);
        this.BalrogMouth.addBox(-2.5F, -2.5F, -5.0F, 5, 5, 8, 0.0F);
        this.setRotateAngle(BalrogMouth, 0.2181661564992912F, 0.0F, 0.0F);
        this.FeetR1 = new ModelRenderer(this, 64, 59);
        this.FeetR1.setRotationPoint(0.5F, -1.0F, 5.300000190734863F);
        this.FeetR1.addBox(0.0F, 0.0F, 0.0F, 4, 2, 3, 0.0F);
        this.setRotateAngle(FeetR1, -1.9093902283134072F, 0.0F, 0.0F);
        this.BalrogLegR = new ModelRenderer(this, 22, 45);
        this.BalrogLegR.mirror = true;
        this.BalrogLegR.setRotationPoint(-7.5F, 1.0F, -0.20000000298023224F);
        this.BalrogLegR.addBox(-1.0F, -2.0F, -4.0F, 7, 11, 8, 0.0F);
        this.setRotateAngle(BalrogLegR, -0.6544984694978736F, 0.0F, 0.0F);
        this.BalrogTooth32 = new ModelRenderer(this, 0, 28);
        this.BalrogTooth32.setRotationPoint(0.800000011920929F, -1.2000000476837158F, -4.599999904632568F);
        this.BalrogTooth32.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(BalrogTooth32, -0.2617993877991494F, 0.0F, 0.0F);
        this.BalrogWingSkin2 = new ModelRenderer(this, 0, 0);
        this.BalrogWingSkin2.setRotationPoint(18.5F, -4.300000190734863F, 0.0F);
        this.BalrogWingSkin2.addBox(-8.5F, 0.0F, 0.0F, 53, 26, 0, 0.0F);
        this.setRotateAngle(BalrogWingSkin2, 0.0F, 0.0F, 0.7853981633974483F);
        this.BalrogHornR2 = new ModelRenderer(this, 114, 1);
        this.BalrogHornR2.setRotationPoint(-4.5F, 0.30000001192092896F, 0.5F);
        this.BalrogHornR2.addBox(-5.0F, -1.5F, -1.5F, 5, 2, 2, 0.0F);
        this.setRotateAngle(BalrogHornR2, 0.0F, -0.17453292519943295F, -0.3490658503988659F);
        this.BalrogWingSkin1 = new ModelRenderer(this, 0, 0);
        this.BalrogWingSkin1.setRotationPoint(18.5F, -4.300000190734863F, 0.0F);
        this.BalrogWingSkin1.addBox(-8.5F, 0.0F, 0.0F, 53, 26, 0, 0.0F);
        this.setRotateAngle(BalrogWingSkin1, 0.0F, 0.0F, 0.7853981633974483F);
        this.FeetR1_1 = new ModelRenderer(this, 64, 59);
        this.FeetR1_1.setRotationPoint(0.5F, -1.0F, 5.300000190734863F);
        this.FeetR1_1.addBox(0.0F, 0.0F, 0.0F, 4, 2, 3, 0.0F);
        this.setRotateAngle(FeetR1_1, -1.9093902283134072F, 0.0F, 0.0F);
        this.wingfingerl132 = new ModelRenderer(this, 120, 103);
        this.wingfingerl132.setRotationPoint(16.399999618530273F, 2.799999952316284F, -1.0F);
        this.wingfingerl132.addBox(0.0F, 0.0F, 0.0F, 2, 23, 2, 0.0F);
        this.setRotateAngle(wingfingerl132, 0.0F, 0.0F, 0.07487462424476646F);
        this.wingfingerl13 = new ModelRenderer(this, 120, 103);
        this.wingfingerl13.setRotationPoint(16.899999618530273F, 2.799999952316284F, -1.0F);
        this.wingfingerl13.addBox(0.0F, 0.0F, 0.0F, 2, 23, 2, 0.0F);
        this.setRotateAngle(wingfingerl13, 0.0F, 0.0F, 0.07487462424476646F);
        this.BalrogWingBone6L = new ModelRenderer(this, 38, 26);
        this.BalrogWingBone6L.setRotationPoint(16.200000762939453F, -0.20000000298023224F, 0.0F);
        this.BalrogWingBone6L.addBox(0.0F, -1.0F, -1.0F, 21, 2, 2, 0.0F);
        this.setRotateAngle(BalrogWingBone6L, 0.0F, 0.0F, 0.6981317007977318F);
        this.BalrogWingL = new ModelRenderer(this, 38, 26);
        this.BalrogWingL.setRotationPoint(4.5F, 5.5F, 3.0F);
        this.BalrogWingL.addBox(0.0F, -1.0F, -1.0F, 17, 2, 2, 0.0F);
        this.setRotateAngle(BalrogWingL, 0.0F, -0.7853981633974483F, -0.7853981633974483F);
        this.BalrogTail4 = new ModelRenderer(this, 25, 52);
        this.BalrogTail4.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.BalrogTail4.addBox(-1.5F, -1.5F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(BalrogTail4, 0.16982053621904827F, 0.0F, 0.0F);
        this.BalrogWingBone3L = new ModelRenderer(this, 38, 26);
        this.BalrogWingBone3L.setRotationPoint(16.200000762939453F, -0.4000000059604645F, 0.0F);
        this.BalrogWingBone3L.addBox(0.0F, -1.0F, -1.0F, 17, 2, 2, 0.0F);
        this.setRotateAngle(BalrogWingBone3L, 0.0F, 0.0F, 0.6981317007977318F);
        this.BalrogTail3 = new ModelRenderer(this, 25, 52);
        this.BalrogTail3.setRotationPoint(0.0F, 0.3F, 6.0F);
        this.BalrogTail3.addBox(-1.5F, -1.5F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(BalrogTail3, 0.16982053621904827F, 0.0F, 0.0F);
        this.BalrogWingBone4R = new ModelRenderer(this, 38, 26);
        this.BalrogWingBone4R.mirror = true;
        this.BalrogWingBone4R.setRotationPoint(16.200000762939453F, -0.20000000298023224F, 0.0F);
        this.BalrogWingBone4R.addBox(0.0F, -1.0F, -1.0F, 17, 2, 2, 0.0F);
        this.setRotateAngle(BalrogWingBone4R, 0.0F, 0.0F, 0.3490658503988659F);
        this.LegLLR = new ModelRenderer(this, 62, 48);
        this.LegLLR.setRotationPoint(-2.0F, 12.199999809265137F, 2.0F);
        this.LegLLR.addBox(0.0F, 0.0F, 0.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LegLLR, -1.6414822147638888F, 0.0F, 0.0F);
        this.BalrogLegL = new ModelRenderer(this, 22, 45);
        this.BalrogLegL.mirror = true;
        this.BalrogLegL.setRotationPoint(2.5F, 1.0F, -0.20000000298023224F);
        this.BalrogLegL.addBox(-1.0F, -2.0F, -4.0F, 7, 11, 8, 0.0F);
        this.setRotateAngle(BalrogLegL, -0.6544984694978736F, 0.0F, 0.0F);
        this.BalrogWingBone5R = new ModelRenderer(this, 38, 26);
        this.BalrogWingBone5R.mirror = true;
        this.BalrogWingBone5R.setRotationPoint(6.099999904632568F, 0.5F, 0.5F);
        this.BalrogWingBone5R.addBox(0.0F, -1.0F, -1.0F, 17, 1, 1, 0.0F);
        this.BalrogWingBone6R = new ModelRenderer(this, 38, 26);
        this.BalrogWingBone6R.mirror = true;
        this.BalrogWingBone6R.setRotationPoint(16.200000762939453F, -0.20000000298023224F, 0.0F);
        this.BalrogWingBone6R.addBox(0.0F, -1.0F, -1.0F, 21, 2, 2, 0.0F);
        this.setRotateAngle(BalrogWingBone6R, 0.0F, 0.0F, 0.6981317007977318F);
        this.BalrogTail1 = new ModelRenderer(this, 25, 52);
        this.BalrogTail1.setRotationPoint(0.5F, 0.0F, 1.0F);
        this.BalrogTail1.addBox(-2.5F, -2.5F, -0.1F, 4, 4, 8, 0.0F);
        this.setRotateAngle(BalrogTail1, -0.8491026810952413F, 0.0F, 0.0F);
        this.BalrogWingR = new ModelRenderer(this, 38, 26);
        this.BalrogWingR.mirror = true;
        this.BalrogWingR.setRotationPoint(-4.5F, 5.5F, 3.0F);
        this.BalrogWingR.addBox(0.0F, -1.0F, -1.0F, 17, 2, 2, 0.0F);
        this.setRotateAngle(BalrogWingR, 0.0F, -2.356194490192345F, 0.7853981633974483F);
        this.LegLowR = new ModelRenderer(this, 22, 43);
        this.LegLowR.mirror = true;
        this.LegLowR.setRotationPoint(2.5F, 6.5F, -1.5F);
        this.LegLowR.addBox(-2.5F, 0.0F, -2.5F, 5, 16, 5, 0.0F);
        this.setRotateAngle(LegLowR, 1.3962634015954636F, 0.0F, 0.0F);
        this.BalrogWingBone3R = new ModelRenderer(this, 38, 26);
        this.BalrogWingBone3R.mirror = true;
        this.BalrogWingBone3R.setRotationPoint(16.200000762939453F, -0.4000000059604645F, 0.0F);
        this.BalrogWingBone3R.addBox(0.0F, -1.0F, -1.0F, 17, 2, 2, 0.0F);
        this.setRotateAngle(BalrogWingBone3R, 0.0F, 0.0F, 0.6981317007977318F);
        this.LegLLR_1 = new ModelRenderer(this, 62, 48);
        this.LegLLR_1.setRotationPoint(-2.0F, 12.199999809265137F, 2.0F);
        this.LegLLR_1.addBox(0.0F, 0.0F, 0.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LegLLR_1, -1.6414822147638888F, 0.0F, 0.0F);
        this.BalrogTail5 = new ModelRenderer(this, 25, 52);
        this.BalrogTail5.setRotationPoint(0.0F, 0.2F, 7.0F);
        this.BalrogTail5.addBox(-1.0F, -1.0F, 0.0F, 1, 1, 8, 0.0F);
        this.setRotateAngle(BalrogTail5, 0.16982053621904827F, 0.0F, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 0, 48);
        this.bipedRightArm.setRotationPoint(-8.0F, -20.0F, 0.5F);
        this.bipedRightArm.addBox(-5.5F, -1.5F, -3.0F, 5, 10, 6, 0.0F);
        this.BalrogHornR4 = new ModelRenderer(this, 114, 1);
        this.BalrogHornR4.setRotationPoint(-3.700000047683716F, -0.20000000298023224F, 0.0F);
        this.BalrogHornR4.addBox(-5.0F, -1.5F, -1.600000023841858F, 5, 2, 2, 0.0F);
        this.setRotateAngle(BalrogHornR4, 0.0F, -0.3490658503988659F, -0.8726646259971648F);
        this.BalrogHornR4_1 = new ModelRenderer(this, 114, 2);
        this.BalrogHornR4_1.setRotationPoint(-4.400000095367432F, 0.5F, 0.4000000059604645F);
        this.BalrogHornR4_1.addBox(-5.0F, -1.5F, -1.600000023841858F, 5, 1, 1, 0.0F);
        this.setRotateAngle(BalrogHornR4_1, 0.0F, -0.17453292519943295F, 0.0F);
        this.BalrogTooth3 = new ModelRenderer(this, 0, 28);
        this.BalrogTooth3.setRotationPoint(2.200000047683716F, -2.0F, -4.699999809265137F);
        this.BalrogTooth3.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(BalrogTooth3, -0.08726646259971647F, 0.0F, 0.0F);
        this.BalrogTooth4 = new ModelRenderer(this, 0, 28);
        this.BalrogTooth4.setRotationPoint(-2.200000047683716F, -2.0999999046325684F, -4.699999809265137F);
        this.BalrogTooth4.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(BalrogTooth4, -0.08726646259971647F, 0.0F, 0.0F);
        this.FeetR_1 = new ModelRenderer(this, 56, 56);
        this.FeetR_1.setRotationPoint(-0.5F, 15.699999809265137F, -0.800000011920929F);
        this.FeetR_1.addBox(0.0F, 0.0F, 0.0F, 5, 2, 6, 0.0F);
        this.setRotateAngle(FeetR_1, 0.9056513382072132F, 0.0F, 0.0F);
        this.BalrogHornL1 = new ModelRenderer(this, 114, 0);
        this.BalrogHornL1.setRotationPoint(3.5F, -2.799999952316284F, 0.0F);
        this.BalrogHornL1.addBox(0.0F, -1.5F, -1.5F, 5, 3, 3, 0.0F);
        this.setRotateAngle(BalrogHornL1, -0.17453292519943295F, -0.17453292519943295F, -0.5235987755982988F);
        this.BalrogTooth22 = new ModelRenderer(this, 0, 28);
        this.BalrogTooth22.setRotationPoint(-0.699999988079071F, 2.4000000953674316F, -4.699999809265137F);
        this.BalrogTooth22.addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(BalrogTooth22, 0.08726646259971647F, 0.0F, 0.0F);
        this.BalrogWingBone5L = new ModelRenderer(this, 38, 26);
        this.BalrogWingBone5L.setRotationPoint(6.099999904632568F, 0.5F, 0.5F);
        this.BalrogWingBone5L.addBox(0.0F, -1.0F, -1.0F, 17, 1, 1, 0.0F);
        this.BalrogHornR3 = new ModelRenderer(this, 114, 1);
        this.BalrogHornR3.setRotationPoint(-4.0F, -0.20000000298023224F, 0.0F);
        this.BalrogHornR3.addBox(-5.0F, -1.5F, -1.600000023841858F, 5, 2, 2, 0.0F);
        this.setRotateAngle(BalrogHornR3, 0.0F, -0.3490658503988659F, -0.8726646259971648F);
        this.BalrogHornL4 = new ModelRenderer(this, 114, 1);
        this.BalrogHornL4.setRotationPoint(4.0F, -0.20000000298023224F, 0.0F);
        this.BalrogHornL4.addBox(0.0F, -1.5F, -1.600000023841858F, 5, 2, 2, 0.0F);
        this.setRotateAngle(BalrogHornL4, 0.0F, 0.3490658503988659F, 0.8726646259971648F);
        this.bipedRightArmLower = new ModelRenderer(this, 0, 31);
        this.bipedRightArmLower.setRotationPoint(-2.5F, 8.0F, 1.0F);
        this.bipedRightArmLower.addBox(-2.5F, 0.0F, -3.0F, 4, 13, 4, 0.0F);
        this.setRotateAngle(bipedRightArmLower, -0.17453292519943295F, 0.0F, 0.0F);
        this.BalrogBody = new ModelRenderer(this, 78, 43);
        this.BalrogBody.setRotationPoint(0.0F, -21.399999618530273F, 0.0F);
        this.BalrogBody.addBox(-8.5F, 0.0F, -4.0F, 17, 13, 8, 0.0F);
        this.setRotateAngle(BalrogBody, 0.2181661564992912F, 0.0F, 0.0F);
        this.BalrogHornL4.addChild(this.BalrogHornL4_1);
        this.BalrogMouth.addChild(this.BalrogTooth12);
        this.BalrogWingSkin2.addChild(this.wingfingerl122);
        this.BalrogMouth.addChild(this.BalrogTooth42);
        this.BalrogWingSkin2.addChild(this.wingfingerl14);
        this.BalrogWingL.addChild(this.BalrogWingBone2L);
        this.FeetR.addChild(this.FeetR2);
        this.BalrogSkull.addChild(this.BalrogHornR1);
        this.bipedLeftArm.addChild(this.bipedLeftArmLower);
        this.LegLLR.addChild(this.FeetR);
        this.BalrogBody.addChild(this.BalrogChest);
        this.BalrogNeck.addChild(this.BalrogSkull);
        this.FeetR_1.addChild(this.FeetR2_1);
        this.BalrogWingSkin1.addChild(this.wingfingerl12);
        this.BalrogMouth.addChild(this.BalrogTooth2);
        this.BalrogWingBone3L.addChild(this.BalrogWingBone4L);
        this.BalrogMouth.addChild(this.BalrogTooth1);
        this.BalrogTail1.addChild(this.BalrogTail2);
        this.BalrogLegL.addChild(this.LegLowR_1);
        this.BalrogWingR.addChild(this.BalrogWingBone2R);
        this.BalrogHornL2.addChild(this.BalrogHornL3);
        this.BalrogWingSkin1.addChild(this.wingfingerl1);
        this.BalrogHornL1.addChild(this.BalrogHornL2);
        this.BalrogSkull.addChild(this.BalrogMouth);
        this.FeetR.addChild(this.FeetR1);
        this.BalrogMouth.addChild(this.BalrogTooth32);
        this.BalrogWingR.addChild(this.BalrogWingSkin2);
        this.BalrogHornR1.addChild(this.BalrogHornR2);
        this.BalrogWingL.addChild(this.BalrogWingSkin1);
        this.FeetR_1.addChild(this.FeetR1_1);
        this.BalrogWingSkin2.addChild(this.wingfingerl132);
        this.BalrogWingSkin1.addChild(this.wingfingerl13);
        this.BalrogWingBone4L.addChild(this.BalrogWingBone6L);
        this.BalrogBody.addChild(this.BalrogWingL);
        this.BalrogTail3.addChild(this.BalrogTail4);
        this.BalrogWingL.addChild(this.BalrogWingBone3L);
        this.BalrogTail2.addChild(this.BalrogTail3);
        this.BalrogWingBone3R.addChild(this.BalrogWingBone4R);
        this.LegLowR.addChild(this.LegLLR);
        this.BalrogWingBone4R.addChild(this.BalrogWingBone5R);
        this.BalrogWingBone4R.addChild(this.BalrogWingBone6R);
        this.BalrogBody.addChild(this.BalrogWingR);
        this.BalrogLegR.addChild(this.LegLowR);
        this.BalrogWingR.addChild(this.BalrogWingBone3R);
        this.LegLowR_1.addChild(this.LegLLR_1);
        this.BalrogTail4.addChild(this.BalrogTail5);
        this.BalrogHornR3.addChild(this.BalrogHornR4);
        this.BalrogHornR4.addChild(this.BalrogHornR4_1);
        this.BalrogMouth.addChild(this.BalrogTooth3);
        this.BalrogMouth.addChild(this.BalrogTooth4);
        this.LegLLR_1.addChild(this.FeetR_1);
        this.BalrogSkull.addChild(this.BalrogHornL1);
        this.BalrogMouth.addChild(this.BalrogTooth22);
        this.BalrogWingBone4L.addChild(this.BalrogWingBone5L);
        this.BalrogHornR2.addChild(this.BalrogHornR3);
        this.BalrogHornL3.addChild(this.BalrogHornL4);
        this.bipedRightArm.addChild(this.bipedRightArmLower);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float anim = (entity.ticksExisted + f5) / 20F;

        BalrogWingL.rotateAngleX = (float) (Math.cos(anim) / 4D);
        BalrogWingL.rotateAngleY = -0.2858F + (float) (Math.sin(anim) / 4D);

        BalrogWingR.rotateAngleX = -(float) (Math.cos(anim) / 4D);
        BalrogWingR.rotateAngleY = (-2.8561945f) - (float) (Math.sin(anim) / 4D);

        this.BalrogNeck.render(f5);
        this.BalrogBody.render(f5);
        this.bipedRightArm.render(f5);
        this.bipedLeftArm.render(f5);
        this.BalrogLegR.render(f5);
        this.BalrogLegL.render(f5);
        this.BalrogTail1.render(f5);
    }

    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
        this.rightArmPose = ModelBiped.ArmPose.EMPTY;
        this.leftArmPose = ModelBiped.ArmPose.EMPTY;
        ItemStack itemstack = entitylivingbaseIn.getHeldItem(EnumHand.MAIN_HAND);

        if (itemstack.getItem() == Items.BOW && ((EntityBalrog)entitylivingbaseIn).isSwingingArms()) {
            if (entitylivingbaseIn.getPrimaryHand() == EnumHandSide.RIGHT) {
                this.rightArmPose = ModelBiped.ArmPose.ITEM;
            }
            else {
                this.leftArmPose = ModelBiped.ArmPose.ITEM;
            }
        }

        super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        float baseLegRotation = -0.6544984694978736F; // needs to be the original value of arm.rotateAngleX
        float baseNeckRotation = 0.17453292519943295F; // needs to be the original value of leg.rotateAngleX

        this.BalrogLegL.rotateAngleX = baseLegRotation + (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.BalrogLegR.rotateAngleX = baseLegRotation + (MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount);
        this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        this.BalrogNeck.rotateAngleY = baseNeckRotation + (netHeadYaw * 0.017453292F);
        this.BalrogNeck.rotateAngleX = baseNeckRotation + (headPitch * 0.017453292F);

        BalrogTail1.rotateAngleY = MathHelper.sin(degToRad(entityIn.ticksExisted*7)) * degToRad(5);
        BalrogTail2.rotateAngleY = BalrogTail1.rotateAngleY * 3;
        BalrogTail3.rotateAngleY = BalrogTail2.rotateAngleY * 1;
        BalrogTail4.rotateAngleY = BalrogTail3.rotateAngleY * 1;
        BalrogTail5.rotateAngleY = BalrogTail4.rotateAngleY * 1;

        this.bipedLeftArm.rotationPointX = 8.5F;
        this.bipedRightArm.rotationPointX = -8.0F;
    }
}