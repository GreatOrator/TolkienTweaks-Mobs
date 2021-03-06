package com.greatorator.tolkienmobs.entity.ambient;

import com.google.common.collect.Maps;
import com.greatorator.tolkienmobs.TTMContent;
import com.greatorator.tolkienmobs.TolkienMobs;
import com.greatorator.tolkienmobs.datagen.SoundGenerator;
import com.greatorator.tolkienmobs.entity.EntityTTMAmbients;
import com.greatorator.tolkienmobs.init.TTMTags;
import net.minecraft.block.material.Material;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Map;

public class EntityTTMSquirrel extends EntityTTMAmbients {
    private static final DataParameter<Integer> SQUIRREL_TYPE = EntityDataManager.createKey(EntityTTMSquirrel.class, DataSerializers.VARINT);
    private static final ResourceLocation KILLER_SQUIRREL = new ResourceLocation(TolkienMobs.MODID, "textures/entity/sosquirrel/killer_squirrel");

    public static final Map<Integer, ResourceLocation> TEXTURE_BY_ID = Util.make(Maps.newHashMap(), (option) -> {
        option.put(0, new ResourceLocation(TolkienMobs.MODID, "textures/entity/sosquirrel/sosquirrel.png"));
        option.put(1, new ResourceLocation(TolkienMobs.MODID, "textures/entity/sosquirrel/sosquirrel2.png"));
        option.put(2, new ResourceLocation(TolkienMobs.MODID, "textures/entity/sosquirrel/sosquirrel3.png"));
        option.put(3, new ResourceLocation(TolkienMobs.MODID, "textures/entity/sosquirrel/sosquirrel4.png"));
    });

    public EntityTTMSquirrel(EntityType<? extends EntityTTMSquirrel> type, World worldIn)
    {
        super(type, worldIn);
    }

    protected void registerGoals()
    {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, Ingredient.fromTag(TTMTags.items.ACORNS), true));
        this.goalSelector.addGoal(5, new PanicGoal(this, 1.3F));
        this.goalSelector.addGoal(6, new AvoidEntityGoal<>(this, PlayerEntity.class, 2.0F, 0.8F, 1.4F));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.13F;
    }

    static class AvoidEntityGoal<T extends LivingEntity> extends net.minecraft.entity.ai.goal.AvoidEntityGoal<T> {
        private final EntityTTMSquirrel ttmSquirrel;

        public AvoidEntityGoal(EntityTTMSquirrel ttmSquirrel, Class<T> p_i46403_2_, float p_i46403_3_, double p_i46403_4_, double p_i46403_6_) {
            super(ttmSquirrel, p_i46403_2_, p_i46403_3_, p_i46403_4_, p_i46403_6_);
            this.ttmSquirrel = ttmSquirrel;
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return this.ttmSquirrel.getSquirrelType() != 99 && super.shouldExecute();
        }
    }

    /** Region for determining random skin */
    public ResourceLocation getSquirrelTypeName() {
        return TEXTURE_BY_ID.getOrDefault(this.getSquirrelType(), TEXTURE_BY_ID.get(0));
    }

    public int getSquirrelType() {
        return this.dataManager.get(SQUIRREL_TYPE);
    }

    public void setSquirrelType(int type) {
        if (type == 99) {
            this.getAttribute(Attributes.ARMOR).setBaseValue(8.0D);
            this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WolfEntity.class, true));
            this.goalSelector.addGoal(4, new EntityTTMSquirrel.EvilAttackGoal(this));
            if (!this.hasCustomName()) {
                this.setCustomName(new TranslationTextComponent(Util.makeTranslationKey("entity", KILLER_SQUIRREL)));
            }
        }

        this.dataManager.set(SQUIRREL_TYPE, type);
        if (type < 0 || type >= 4) {
            type = this.rand.nextInt(3);
        }

        this.dataManager.set(SQUIRREL_TYPE, type);
    }

    static class EvilAttackGoal extends MeleeAttackGoal {
        public EvilAttackGoal(EntityTTMSquirrel squirrel) {
            super(squirrel, 1.4D, true);
        }

        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return (double)(4.0F + attackTarget.getWidth());
        }
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(SQUIRREL_TYPE, 1);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("SquirrelType", this.getSquirrelType());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setSquirrelType(compound.getInt("SquirrelType"));
    }

    protected SoundEvent getJumpSound()
    {
        return SoundGenerator.soundStepSOSquirrel.get();
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundGenerator.soundIdleSOSquirrel.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundGenerator.soundHurtSOSquirrel.get();
    }

    protected SoundEvent getDeathSound()
    {
        return SoundGenerator.soundDeathSOSquirrel.get();
    }

    public SoundCategory getSoundCategory()
    {
        return this.getSquirrelType() == 99 ? SoundCategory.HOSTILE : SoundCategory.NEUTRAL;
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        if (this.getSquirrelType() == 99)
        {
            this.playSound(SoundGenerator.soundAngrySOSquirrel.get(), 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 8.0F);
        }
        else
        {
            return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0F);
        }
    }

    private boolean isSquirrelBreedingItem(Item itemIn)
    {
        return itemIn == TTMContent.TREE_ACORN.get() || itemIn == TTMContent.GOLDEN_TREE_ACORN.get();
    }

    public boolean isBreedingItem(ItemStack stack)
    {
        return this.isSquirrelBreedingItem(stack.getItem());
    }

    @Override
    public float getBlockPathWeight(BlockPos pos) {
        // prefer standing on leaves
        Material underMaterial = this.world.getBlockState(pos.down()).getMaterial();
        if (underMaterial == Material.LEAVES) {
            return 12.0F;
        }
        if (underMaterial == Material.WOOD) {
            return 15.0F;
        }
        if (underMaterial == Material.EARTH) {
            return 10.0F;
        }

        return this.world.getLightValue(pos) - 0.5F;
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag)
    {
        int i = this.getRandomSquirrelType(worldIn);
        if (spawnDataIn instanceof EntityTTMSquirrel.SquirrelData) {
            i = ((EntityTTMSquirrel.SquirrelData)spawnDataIn).typeData;
        } else {
            spawnDataIn = new EntityTTMSquirrel.SquirrelData(i);
        }

        this.setSquirrelType(i);
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    private int getRandomSquirrelType(IWorld worldIn)
    {
        Biome biome = worldIn.getBiome(this.getPosition());
        int i = this.rand.nextInt(100);

        if (biome.getPrecipitation() == Biome.RainType.SNOW) {
            return i < 80 ? 1 : 3;
        } else if (biome.getCategory() == Biome.Category.DESERT) {
            return 4;
        } else {
            return i < 50 ? 0 : (i < 90 ? 4 : 2);
        }
    }

    public static class SquirrelData extends AgeableEntity.AgeableData {
        public final int typeData;

        public SquirrelData(int type) {
            super(1.0F);
            this.typeData = type;
        }
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return null;
    }
}