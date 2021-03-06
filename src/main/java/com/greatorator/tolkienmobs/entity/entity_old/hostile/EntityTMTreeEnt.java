//package com.greatorator.tolkienmobs.entity.hostile;
//
//import com.greatorator.tolkienmobs.entity.ammo.EntityBoulder;
//import com.greatorator.tolkienmobs.entity.boss.EntityTMGoblinKing;
//import com.greatorator.tolkienmobs.entity.passive.EntityTMHobbit;
//import com.greatorator.tolkienmobs.init.LootInit;
//import com.greatorator.tolkienmobs.init.SoundInit;
//import com.greatorator.tolkienmobs.utils.TTMRand;
//import com.greatorator.tolkienmobs.utils.TTMSpawnEvent;
//import io.netty.buffer.ByteBuf;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.IEntityLivingData;
//import net.minecraft.entity.IRangedAttackMob;
//import net.minecraft.entity.SharedMonsterAttributes;
//import net.minecraft.entity.ai.*;
//import net.minecraft.entity.monster.EntityMob;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.math.MathHelper;
//import net.minecraft.world.DifficultyInstance;
//import net.minecraft.world.EnumDifficulty;
//import net.minecraft.world.World;
//import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
//
//import javax.annotation.Nullable;
//
//public class EntityTMTreeEnt extends EntityMob implements IRangedAttackMob, IEntityAdditionalSpawnData {
//    private int texture_index;
//
//    public EntityTMTreeEnt(World worldIn) {
//        super(worldIn);
//        setSize(1.35F, 5.5F);
//        this.texture_index = rand.nextInt(4);
//    }
//
//    public int getTextureIndex() {
//        return this.texture_index;
//    }
//
//    @Override
//    protected void entityInit() {
//        super.entityInit();
//    }
//
//    private void applyEntityAI() {
//        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[]{EntityTMTreeEnt.class}));
//        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityTMMordorOrc.class, false));
//        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityTMUrukHai.class, false));
//        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityTMGoblin.class, true));
//        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityTMGoblinKing.class, true));
//    }
//
//    @Override
//    protected void initEntityAI() {
//        this.tasks.addTask(0, new EntityAISwimming(this));
//        this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));
//        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
//        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
//        this.tasks.addTask(8, new EntityAIWatchClosest(this, PlayerEntity.class, 8.0F));
//        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityTMHobbit.class, 8.0F));
//        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTMGoblin.class, true));
//        this.tasks.addTask(8, new EntityAILookIdle(this));
//        this.applyEntityAI();
//    }
//
//    @Override
//    protected void applyEntityAttributes() {
//        super.applyEntityAttributes();
//        // Here we set various attributes for our mob. Like maximum health, armor, speed, ...
//        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
//        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
//        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
//        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(9.0D);
//        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(45.0D);
//    }
//
//    @Nullable
//    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
//    {
//        IEntityLivingData ientitylivingdata = super.onInitialSpawn(difficulty, livingdata);
//        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
//        if (texture_index == 0){
//            texture_index = TTMRand.getRandomInteger(5, 1);
//        }
//        return ientitylivingdata;
//    }
//
//    @Override
//    @Nullable
//    protected ResourceLocation getLootTable() {
//        return LootInit.TREEENT;
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
//    @Override
//    public boolean getCanSpawnHere() {
//        int willSpawn = TTMSpawnEvent.spawnChance();
//
//        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && willSpawn <= 10;
//    }
//
//    @Override
//    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
//        EntityBoulder entityboulder = new EntityBoulder(this.world, this);
//        double d0 = target.posY + (double)target.getEyeHeight() - 1.100000023841858D;
//        double d1 = target.posX - this.posX;
//        double d2 = d0 - entityboulder.posY;
//        double d3 = target.posZ - this.posZ;
//        float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
//        entityboulder.shoot(d1, d2 + (double)f, d3, 1.6F, 12.0F);
//        this.playSound(SoundInit.soundBoulderShoot, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
//        this.world.spawnEntity(entityboulder);
//    }
//
//    @Override
//    public void writeEntityToNBT(NBTTagCompound compound) {
//        super.writeEntityToNBT(compound);
//        compound.setInteger("texture_index", texture_index);
//    }
//
//    @Override
//    public void readEntityFromNBT(NBTTagCompound compound) {
//        super.readEntityFromNBT(compound);
//        texture_index = compound.getInteger("texture_index");
//    }
//
//    @Override
//    public void setSwingingArms(boolean swingingArms) {
//
//    }
//
//    @Override
//    public void writeSpawnData(ByteBuf buffer) {
//        buffer.writeInt(this.texture_index);
//    }
//
//    @Override
//    public void readSpawnData(ByteBuf buffer) {
//        this.texture_index = buffer.readInt();
//    }
//}