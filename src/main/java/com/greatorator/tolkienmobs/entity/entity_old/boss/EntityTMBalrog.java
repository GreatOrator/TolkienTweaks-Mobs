//package com.greatorator.tolkienmobs.entity.boss;
//
//import com.greatorator.tolkienmobs.entity.entityai.EntityAITTMAttack;
//import com.greatorator.tolkienmobs.entity.passive.EntityTMHobbit;
//import com.greatorator.tolkienmobs.init.LootInit;
//import com.greatorator.tolkienmobs.init.SoundInit;
//import com.greatorator.tolkienmobs.init.TTMFeatures;
//import net.minecraft.block.Block;
//import net.minecraft.block.material.Material;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.IEntityLivingData;
//import net.minecraft.entity.SharedMonsterAttributes;
//import net.minecraft.entity.ai.*;
//import net.minecraft.entity.monster.EntityMob;
//import net.minecraft.entity.monster.IMob;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.ServerPlayerEntity;
//import net.minecraft.entity.projectile.EntityLargeFireball;
//import net.minecraft.init.MobEffects;
//import net.minecraft.init.SoundEvents;
//import net.minecraft.inventory.EntityEquipmentSlot;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.network.datasync.DataParameter;
//import net.minecraft.network.datasync.DataSerializers;
//import net.minecraft.network.datasync.EntityDataManager;
//import net.minecraft.potion.PotionEffect;
//import net.minecraft.util.*;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Vec3d;
//import net.minecraft.world.*;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//import javax.annotation.Nullable;
//
//public class EntityTMBalrog extends EntityMob implements IMob {
//
//    private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.<Boolean>createKey(EntityTMBalrog.class, DataSerializers.BOOLEAN);
//    private static final DataParameter<Boolean> ATTACKING = EntityDataManager.<Boolean>createKey(EntityTMBalrog.class, DataSerializers.BOOLEAN);
//    private static final DataParameter<Byte> ON_FIRE = EntityDataManager.<Byte>createKey(EntityTMBalrog.class, DataSerializers.BYTE);
//
//    private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);
//
//    /** The explosion radius of spawned fireballs. */
//    private int explosionStrength = 1;
//    private final EntityAITTMAttack aiAttackOnCollide = new EntityAITTMAttack(this, 1.2D, false)
//    {
//        public void resetTask()
//        {
//            super.resetTask();
//            EntityTMBalrog.this.setSwingingArms(false);
//        }
//
//        public void startExecuting()
//        {
//            super.startExecuting();
//            EntityTMBalrog.this.setSwingingArms(true);
//        }
//    };
//
//    public EntityTMBalrog(World worldIn) {
//        super(worldIn);
//        this.setSize(2.3F, 7.0F);
//        this.isImmuneToFire = true;
//        this.experienceValue = 150;
//    }
//
//    protected void initEntityAI() {
//        this.tasks.addTask(1, new EntityAISwimming(this));
//        this.tasks.addTask(1, new EntityTMBalrog.AIFireballAttack(this));
//        this.tasks.addTask(2, new EntityAITTMAttack(this, 0.6D, false));
//        this.tasks.addTask(6, new EntityAILookIdle(this));
//        this.tasks.addTask(7, new EntityAIWander(this, 0.5D));
//        this.applyEntityAI();
//    }
//
//    private void applyEntityAI() {
//        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[]{EntityTMBalrog.class}));
//        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, PlayerEntity.class, true));
//        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTMHobbit.class, true));
//    }
//
//    @Override
//    protected void entityInit() {
//        super.entityInit();
//        this.dataManager.register(ATTACKING, Boolean.valueOf(false));
//        this.dataManager.register(SWINGING_ARMS, Boolean.valueOf(true));
//        this.dataManager.register(ON_FIRE, Byte.valueOf((byte)0));
//    }
//
//    @Override
//    protected void applyEntityAttributes() {
//        super.applyEntityAttributes();
//        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
//        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0D);
//        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
//        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
//        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
//    }
//
//    @SideOnly(Side.CLIENT)
//    public boolean isAttacking()
//    {
//        return ((Boolean)this.dataManager.get(ATTACKING)).booleanValue();
//    }
//
//    public void setAttacking(boolean attacking)
//    {
//        this.dataManager.set(ATTACKING, Boolean.valueOf(attacking));
//    }
//
//    public int getFireballStrength()
//    {
//        return this.explosionStrength;
//    }
//
//    public void addTrackingPlayer(ServerPlayerEntity player)
//    {
//        super.addTrackingPlayer(player);
//        this.bossInfo.addPlayer(player);
//    }
//
//    public void removeTrackingPlayer(ServerPlayerEntity player)
//    {
//        super.removeTrackingPlayer(player);
//        this.bossInfo.removePlayer(player);
//    }
//
//    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
//    {
//        super.setEquipmentBasedOnDifficulty(difficulty);
//        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(TTMFeatures.WHIP_FIRE));
//    }
//
//    protected void setEnchantmentBasedOnDifficulty(DifficultyInstance difficulty)
//    {
//    }
//
//    @Nullable
//    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
//    {
//        IEntityLivingData ientitylivingdata = super.onInitialSpawn(difficulty, livingdata);
//        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
//        this.setEquipmentBasedOnDifficulty(difficulty);
//        this.setCombatTask();
//        return ientitylivingdata;
//    }
//
//    public void setCombatTask()
//    {
//        if (this.world != null && !this.world.isRemote)
//        {
//            this.tasks.removeTask(this.aiAttackOnCollide);
//            ItemStack itemstack = this.getHeldItemMainhand();
//
//            if (itemstack.getItem() == TTMFeatures.WHIP_FIRE)
//            {
//                this.tasks.addTask(4, this.aiAttackOnCollide);
//            }
//            else
//            {
//                int i = 20;
//
//                if (this.world.getDifficulty() != EnumDifficulty.HARD)
//                {
//                    i = 40;
//                }
//            }
//        }
//    }
//
//    protected void updateAITasks()
//    {
//        super.updateAITasks();
//        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
//    }
//
//    public boolean isNonBoss()
//    {
//        return false;
//    }
//
//    public boolean attackEntityAsMob(Entity entityIn)
//    {
//        if (!super.attackEntityAsMob(entityIn))
//        {
//            return false;
//        }
//        else
//        {
//            if (entityIn instanceof LivingEntity)
//            {
//                ((LivingEntity)entityIn).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 200));
//            }
//
//            return true;
//        }
//    }
//
//    public void setItemStackToSlot(EntityEquipmentSlot slotIn, ItemStack stack)
//    {
//        super.setItemStackToSlot(slotIn, stack);
//
//        if (!this.world.isRemote && slotIn == EntityEquipmentSlot.MAINHAND)
//        {
//            this.setCombatTask();
//        }
//    }
//
//    public void setSwingingArms(boolean swingingArms)
//    {
//        this.dataManager.set(SWINGING_ARMS, Boolean.valueOf(swingingArms));
//    }
//
//    public void writeEntityToNBT(NBTTagCompound compound)
//    {
//        super.writeEntityToNBT(compound);
//        compound.setInteger("ExplosionPower", this.explosionStrength);
//    }
//
//    public void readEntityFromNBT(NBTTagCompound compound)
//    {
//        super.readEntityFromNBT(compound);
//
//        if (this.hasCustomName())
//        {
//            this.bossInfo.setName(this.getDisplayName());
//        }
//
//        if (compound.hasKey("ExplosionPower", 99))
//        {
//            this.explosionStrength = compound.getInteger("ExplosionPower");
//        }
//    }
//
//    public void setCustomNameTag(String name)
//    {
//        super.setCustomNameTag(name);
//        this.bossInfo.setName(this.getDisplayName());
//    }
//
//    public SoundCategory getSoundCategory()
//    {
//        return SoundCategory.HOSTILE;
//    }
//
//    protected SoundEvent getAmbientSound()
//    {
//        return SoundInit.soundIdleBalrog;
//    }
//
//    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
//    {
//        return SoundInit.soundHurtBalrog;
//    }
//
//    protected SoundEvent getDeathSound()
//    {
//        return SoundInit.soundDeathBalrog;
//    }
//
//    @Override
//    protected void playStepSound(BlockPos pos, Block blockIn)
//    {
//        this.playSound(SoundInit.soundStepBalrog, 0.25F, 1.0F);
//    }
//    public boolean isBurning()
//    {
//        return this.isCharged();
//    }
//
//    public boolean isCharged()
//    {
//        return (((Byte)this.dataManager.get(ON_FIRE)).byteValue() & 1) != 0;
//    }
//
//    public void setOnFire(boolean onFire)
//    {
//        byte b0 = ((Byte)this.dataManager.get(ON_FIRE)).byteValue();
//
//        if (onFire)
//        {
//            b0 = (byte)(b0 | 1);
//        }
//        else
//        {
//            b0 = (byte)(b0 & -2);
//        }
//
//        this.dataManager.set(ON_FIRE, Byte.valueOf(b0));
//    }
//
//    @SideOnly(Side.CLIENT)
//    public boolean isSwingingArms()
//    {
//        return ((Boolean)this.dataManager.get(SWINGING_ARMS)).booleanValue();
//    }
//
//    static class AIFireballAttack extends EntityAIBase
//    {
//        private final EntityTMBalrog parentEntity;
//        public int attackTimer;
//
//        public AIFireballAttack(EntityTMBalrog balrog)
//        {
//            this.parentEntity = balrog;
//        }
//
//        /**
//         * Returns whether the EntityAIBase should begin execution.
//         */
//        public boolean shouldExecute()
//        {
//            return this.parentEntity.getAttackTarget() != null;
//        }
//
//        /**
//         * Execute a one shot task or start executing a continuous task
//         */
//        public void startExecuting()
//        {
//            this.attackTimer = 0;
//        }
//
//        /**
//         * Reset the task's internal state. Called when this task is interrupted by another one
//         */
//        public void resetTask()
//        {
//            this.parentEntity.setAttacking(false);
//        }
//
//        /**
//         * Keep ticking a continuous task that has already been started
//         */
//        public void updateTask()
//        {
//            LivingEntity LivingEntity = this.parentEntity.getAttackTarget();
//            double d0 = 64.0D;
//
//            if (LivingEntity.getDistanceSq(this.parentEntity) < 4096.0D && this.parentEntity.canEntityBeSeen(LivingEntity))
//            {
//                World world = this.parentEntity.world;
//                ++this.attackTimer;
//
//                if (this.attackTimer == 20)
//                {
//                    double d1 = 4.0D;
//                    Vec3d vec3d = this.parentEntity.getLook(1.0F);
//                    double d2 = LivingEntity.posX - (this.parentEntity.posX + vec3d.x * 4.0D);
//                    double d3 = LivingEntity.getEntityBoundingBox().minY + (double)(LivingEntity.height / 2.0F) - (0.5D + this.parentEntity.posY + (double)(this.parentEntity.height / 2.0F));
//                    double d4 = LivingEntity.posZ - (this.parentEntity.posZ + vec3d.z * 4.0D);
//                    world.playEvent((PlayerEntity)null, 1018, new BlockPos(this.parentEntity), 0);
//                    EntityLargeFireball entitylargefireball = new EntityLargeFireball(world, this.parentEntity, d2, d3, d4);
//                    entitylargefireball.explosionPower = this.parentEntity.getFireballStrength();
//                    entitylargefireball.posX = this.parentEntity.posX + vec3d.x * 4.0D;
//                    entitylargefireball.posY = this.parentEntity.posY + (double)(this.parentEntity.height / 2.0F) + 0.5D;
//                    entitylargefireball.posZ = this.parentEntity.posZ + vec3d.z * 4.0D;
//                    world.spawnEntity(entitylargefireball);
//                    this.parentEntity.setOnFire(true);
//                    this.attackTimer = -20;
//                }
//            }
//            else if (this.attackTimer > 0)
//            {
//                --this.attackTimer;
//                this.parentEntity.setOnFire(false);
//            }
//
//            this.parentEntity.setAttacking(this.attackTimer > 10);
//        }
//    }
//
//    public void onLivingUpdate()
//    {
//        if (this.world.isRemote)
//        {
//            if (this.rand.nextInt(24) == 0 && !this.isSilent())
//            {
//                this.world.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, SoundEvents.ENTITY_BLAZE_BURN, this.getSoundCategory(), 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
//            }
//
//            for (int i = 0; i < 2; ++i)
//            {
//                this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
//            }
//        }
//
//        super.onLivingUpdate();
//    }
//
//    @Override
//    @Nullable
//    protected ResourceLocation getLootTable() {
//        return LootInit.BALROG;
//    }
//
//    @Override
//    protected boolean isValidLightLevel() {
//        return true;
//    }
//
//    @Override
//    public int getMaxSpawnedInChunk() {
//        return 1;
//    }
//
//    protected boolean canDespawn()
//    {
//        return false;
//    }
//
//    @Override
//    public boolean getCanSpawnHere() {
//        boolean nearLava = false;
//        int i = (int) Math.floor(posX);
//        int j = (int) Math.floor(posY);
//        int k = (int) Math.floor(posZ);
//        for (int i1 = i - 16; i1 <= i + 16; i1++) {
//            for (int j1 = j - 6; j1 <= j + 6; j1++) {
//                for (int k1 = k - 16; k1 <= k + 16; k1++) {
//                    BlockPos pos = new BlockPos(i1, j1, k1);
//                    if (world.getBlockState(pos).getMaterial() == Material.LAVA && !this.world.canSeeSky(new BlockPos(this)) && this.posY < 35.0D)
//                        nearLava = true;
//                }
//            }
//        }
//        return nearLava;
//    }
//}