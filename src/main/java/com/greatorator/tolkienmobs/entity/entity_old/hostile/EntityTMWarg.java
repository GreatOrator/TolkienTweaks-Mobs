//package com.greatorator.tolkienmobs.entity.hostile;
//
//import com.greatorator.tolkienmobs.entity.passive.EntityTMHobbit;
//import com.greatorator.tolkienmobs.init.LootInit;
//import com.greatorator.tolkienmobs.init.SoundInit;
//import com.greatorator.tolkienmobs.utils.TTMRand;
//import com.greatorator.tolkienmobs.utils.TTMSpawnEvent;
//import net.minecraft.block.Block;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.IEntityLivingData;
//import net.minecraft.entity.SharedMonsterAttributes;
//import net.minecraft.entity.ai.*;
//import net.minecraft.entity.passive.EntityRabbit;
//import net.minecraft.entity.passive.EntitySheep;
//import net.minecraft.entity.passive.EntityWolf;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.init.SoundEvents;
//import net.minecraft.item.EnumDyeColor;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.network.datasync.DataParameter;
//import net.minecraft.network.datasync.DataSerializers;
//import net.minecraft.network.datasync.EntityDataManager;
//import net.minecraft.util.DamageSource;
//import net.minecraft.util.EnumParticleTypes;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.SoundEvent;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.MathHelper;
//import net.minecraft.world.DifficultyInstance;
//import net.minecraft.world.EnumDifficulty;
//import net.minecraft.world.EnumSkyBlock;
//import net.minecraft.world.World;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//import javax.annotation.Nullable;
//
//public class EntityTMWarg extends EntityWolf {
//    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.<Float>createKey(EntityWolf.class, DataSerializers.FLOAT);
//    private static final DataParameter<Boolean> BEGGING = EntityDataManager.<Boolean>createKey(EntityWolf.class, DataSerializers.BOOLEAN);
//    private static final DataParameter<Integer> COLLAR_COLOR = EntityDataManager.<Integer>createKey(EntityWolf.class, DataSerializers.VARINT);
//    private static final DataParameter<Integer> SKIN_TYPE = EntityDataManager.<Integer>createKey(EntityTMWarg.class, DataSerializers.VARINT);
//
//    /** Float used to smooth the rotation of the wolf head */
//    private float headRotationCourse;
//    private float headRotationCourseOld;
//    /** true is the wolf is wet else false */
//    private boolean isWet;
//    /** True if the wolf is shaking else False */
//    private boolean isShaking;
//    /** This time increases while wolf is shaking and emitting water particles. */
//    private float timeWolfIsShaking;
//    private float prevTimeWolfIsShaking;
//
//    public EntityTMWarg(World worldIn) {
//        super(worldIn);
//        this.setSize(1.5F, 1.4F);
//        this.setTamed(false);
//    }
//
//    @Nullable
//    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
//    {
//        IEntityLivingData ientitylivingdata = super.onInitialSpawn(difficulty, livingdata);
//        this.setEquipmentBasedOnDifficulty(difficulty);
//        int i = this.getRandomMobType();
//
//        if (ientitylivingdata instanceof EntityTMWarg.MobTypeData)
//        {
//            i = ((EntityTMWarg.MobTypeData)livingdata).typeData;
//        }
//        else
//        {
//            ientitylivingdata = new EntityTMWarg.MobTypeData(i);
//        }
//
//        if (TTMRand.getRandomInteger(15, 1) == 2)
//        {
//            EntityTMMordorOrc entitymordororc = new EntityTMMordorOrc(this.world);
//            entitymordororc.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
//            entitymordororc.onInitialSpawn(difficulty, (IEntityLivingData)null);
//            this.world.spawnEntity(entitymordororc);
//            entitymordororc.startRiding(this);
//        }
//
//        this.setMobType(i);
//        return ientitylivingdata;
//    }
//
//    public static class MobTypeData implements IEntityLivingData
//    {
//        public int typeData;
//
//        public MobTypeData(int type)
//        {
//            this.typeData = type;
//        }
//    }
//
//    public double getMountedYOffset()
//    {
//        return (double)(this.height * 1.1F);
//    }
//
//    protected void initEntityAI(){
//        this.tasks.addTask(1, new EntityAISwimming(this));
//        this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4F));
//        this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.0D, true));
//        this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0D));
//        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityTMMordorOrc.class, 8.0F));
//        this.tasks.addTask(10, new EntityAILookIdle(this));
//        this.applyEntityAI();
//    }
//
//    private void applyEntityAI() {
//        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[]{EntityTMWarg.class}));
//        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, PlayerEntity.class, false));
//        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySheep.class, false));
//        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityRabbit.class, false));
//        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTMHobbit.class, true));
//    }
//
//    @Override
//    protected void applyEntityAttributes() {
//        super.applyEntityAttributes();
//        // Here we set various attributes for our mob. Like maximum health, armor, speed, ...
//        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
//        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
//        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
//        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
//        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0D);
//    }
//
//    @Override
//    protected void entityInit()
//    {
//        super.entityInit();
//        this.dataManager.register(SKIN_TYPE, Integer.valueOf(0));
//        this.dataManager.register(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
//        this.dataManager.register(BEGGING, Boolean.valueOf(false));
//        this.dataManager.register(COLLAR_COLOR, Integer.valueOf(EnumDyeColor.RED.getDyeDamage()));
//    }
//
//    public void setAttackTarget(@Nullable LivingEntity LivingEntityIn)
//    {
//        super.setAttackTarget(LivingEntityIn);
//
//        if (LivingEntityIn == null)
//        {
//            this.setAngry(false);
//        }
//        else if (!this.isTamed())
//        {
//            this.setAngry(true);
//        }
//    }
//
//    protected void playStepSound(BlockPos pos, Block blockIn)
//    {
//        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
//    }
//
//    protected SoundEvent getAmbientSound()
//    {
//        return SoundInit.soundIdleWarg;
//    }
//
//    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
//    {
//        return SoundInit.soundHurtWarg;
//    }
//
//    protected SoundEvent getDeathSound()
//    {
//        return SoundInit.soundDeathWarg;
//    }
//
//    protected float getSoundVolume()
//    {
//        return 0.4F;
//    }
//
//    public void onLivingUpdate()
//    {
//        super.onLivingUpdate();
//
//        if (!this.world.isRemote && this.isWet && !this.isShaking && !this.hasPath() && this.onGround)
//        {
//            this.isShaking = true;
//            this.timeWolfIsShaking = 0.0F;
//            this.prevTimeWolfIsShaking = 0.0F;
//            this.world.setEntityState(this, (byte)8);
//        }
//
//        if (!this.world.isRemote && this.getAttackTarget() == null && this.isAngry())
//        {
//            this.setAngry(false);
//        }
//    }
//
//    public void onUpdate()
//    {
//        super.onUpdate();
//        this.headRotationCourseOld = this.headRotationCourse;
//
//            this.headRotationCourse += (0.0F - this.headRotationCourse) * 0.4F;
//
//        if (this.isWet())
//        {
//            this.isWet = true;
//            this.isShaking = false;
//            this.timeWolfIsShaking = 0.0F;
//            this.prevTimeWolfIsShaking = 0.0F;
//        }
//        else if ((this.isWet || this.isShaking) && this.isShaking)
//        {
//            if (this.timeWolfIsShaking == 0.0F)
//            {
//                this.playSound(SoundEvents.ENTITY_WOLF_SHAKE, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
//            }
//
//            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
//            this.timeWolfIsShaking += 0.05F;
//
//            if (this.prevTimeWolfIsShaking >= 2.0F)
//            {
//                this.isWet = false;
//                this.isShaking = false;
//                this.prevTimeWolfIsShaking = 0.0F;
//                this.timeWolfIsShaking = 0.0F;
//            }
//
//            if (this.timeWolfIsShaking > 0.4F)
//            {
//                float f = (float)this.getEntityBoundingBox().minY;
//                int i = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float)Math.PI) * 7.0F);
//
//                for (int j = 0; j < i; ++j)
//                {
//                    float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
//                    float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
//                    this.world.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX + (double)f1, (double)(f + 0.8F), this.posZ + (double)f2, this.motionX, this.motionY, this.motionZ);
//                }
//            }
//        }
//    }
//
//    public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner)
//    {
//        if (!(target instanceof EntitySheep) && !(target instanceof EntityRabbit))
//        {
//            if (target instanceof EntityTMWarg)
//            {
//                EntityTMWarg entitywarg = (EntityTMWarg)target;
//
//                if (entitywarg.isTamed() && entitywarg.getOwner() == owner)
//                {
//                    return false;
//                }
//            }
//
//            if (target instanceof PlayerEntity && owner instanceof PlayerEntity && !((PlayerEntity)owner).canAttackPlayer((PlayerEntity)target))
//            {
//                return false;
//            }
//            else
//            {
//                return !(target instanceof PlayerEntity);
//            }
//        }
//        else
//        {
//            return false;
//        }
//    }
//
//    @SideOnly(Side.CLIENT)
//    public boolean isWolfWet()
//    {
//        return this.isWet;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public float getShadingWhileWet(float p_70915_1_)
//    {
//        return 0.75F + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * p_70915_1_) / 2.0F * 0.25F;
//    }
//
//    public boolean attackEntityAsMob(Entity entityIn)
//    {
//        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));
//
//        if (flag)
//        {
//            this.applyEnchantments(this, entityIn);
//        }
//
//        return flag;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public void handleStatusUpdate(byte id)
//    {
//        if (id == 8)
//        {
//            this.isShaking = true;
//            this.timeWolfIsShaking = 0.0F;
//            this.prevTimeWolfIsShaking = 0.0F;
//        }
//        else
//        {
//            super.handleStatusUpdate(id);
//        }
//    }
//
//    @Override
//    public void writeEntityToNBT(NBTTagCompound compound) {
//        super.writeEntityToNBT(compound);
//        compound.setInteger("SkinType", this.getMobType());
//    }
//
//    @Override
//    public void readEntityFromNBT(NBTTagCompound compound) {
//        super.readEntityFromNBT(compound);
//        this.setMobType(compound.getInteger("SkinType"));
//    }
//
//    @Override
//    @Nullable
//    protected ResourceLocation getLootTable() {
//        return LootInit.WARG;
//    }
//
//    @Override
//    public int getMaxSpawnedInChunk() {
//        return 1;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public float getTailRotation()
//    {
//        return 0.7696902F;
//    }
//
//    public int getMobType()
//    {
//        return ((Integer)this.dataManager.get(SKIN_TYPE)).intValue();
//    }
//
//    public void setMobType(int mobTypeId){
//        this.dataManager.set(SKIN_TYPE, Integer.valueOf(mobTypeId));
//    }
//
//    private int getRandomMobType()
//    {
//        int i = TTMRand.getRandomInteger(5, 1);
//        return i;
//    }
//
//    @Override
//    public boolean getCanSpawnHere() {
//        int willSpawn = TTMSpawnEvent.spawnChance();
//
//        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && willSpawn <= 10;
//    }
//
//    protected boolean isValidLightLevel()
//    {
//        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);
//
//        if (this.world.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32))
//        {
//            return false;
//        }
//        else
//        {
//            int i = this.world.getLightFromNeighbors(blockpos);
//
//            if (this.world.isThundering())
//            {
//                int j = this.world.getSkylightSubtracted();
//                this.world.setSkylightSubtracted(10);
//                i = this.world.getLightFromNeighbors(blockpos);
//                this.world.setSkylightSubtracted(j);
//            }
//
//            return i <= this.rand.nextInt(8);
//        }
//    }
//}