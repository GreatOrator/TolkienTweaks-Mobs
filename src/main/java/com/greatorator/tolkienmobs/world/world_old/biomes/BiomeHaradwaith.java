//package com.greatorator.tolkienmobs.world.world_old.biomes;
//
//import com.greatorator.tolkienmobs.TTMConfig_Old;
//import com.greatorator.tolkienmobs.entity.hostile.EntityTMHaradrim;
//import com.greatorator.tolkienmobs.entity.passive.EntityTMMumakil;
//import com.greatorator.tolkienmobs.utils.LogHelperTTM;
//import net.minecraft.init.Blocks;
//import net.minecraft.util.math.MathHelper;
//import net.minecraft.world.biome.Biome;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//public class BiomeHaradwaith extends Biome {
//    public BiomeHaradwaith()
//    {
//        super(new Biome.BiomeProperties("Haradwaith")
//                .setBaseHeight(0.125F)
//                .setHeightVariation(0.05F)
//                .setTemperature(2.0F)
//                .setRainfall(0.0F)
//                .setRainDisabled());
//
//        LogHelperTTM.info("In the land where the stars are strange...");
//        this.topBlock = Blocks.SAND.getDefaultState();
//        this.fillerBlock = Blocks.SAND.getDefaultState();
//
//        setSpawnables();
//
//        this.decorator = this.createBiomeDecorator();
//        this.decorator.treesPerChunk = -999;
//        this.decorator.grassPerChunk = 12;
//        this.decorator.deadBushPerChunk = 5;
//        this.decorator.reedsPerChunk = 50;
//        this.decorator.cactiPerChunk = 10;
//        this.decorator.generateFalls = true;
//    }
//
//    private void setSpawnables()
//    {
//
//        this.spawnableCaveCreatureList.clear();
//        this.spawnableCreatureList.clear();
//        this.spawnableMonsterList.clear();
//        this.spawnableWaterCreatureList.clear();
//
//        if (TTMConfig_Old.enableNaturalSpawn) {
//
//            if (TTMConfig_Old.enablePassive) {
//                if (TTMConfig_Old.enableMumakil) {
//                    this.spawnableCreatureList.add(new SpawnListEntry(EntityTMMumakil.class, 5, 1, 1));
//                }
//            }
//            if (TTMConfig_Old.enableMonster) {
//                if (TTMConfig_Old.enableHaradrim) {
//                    this.spawnableMonsterList.add(new SpawnListEntry(EntityTMHaradrim.class, 8, 1, 3));
//                }
//            }
//        }
//    }
//
//    @SideOnly(Side.CLIENT)
//    public int getSkyColorByTemp(float currentTemperature)
//    {
//        currentTemperature = currentTemperature / 3.0F;
//        currentTemperature = MathHelper.clamp(currentTemperature, -1.0F, 1.0F);
//        return MathHelper.hsvToRGB(0.62222224F - currentTemperature * 0.05F, 0.5F + currentTemperature * 0.1F, 1.0F);
//    }
//}