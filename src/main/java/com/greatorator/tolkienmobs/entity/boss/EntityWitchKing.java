package com.greatorator.tolkienmobs.entity.boss;

import com.greatorator.tolkienmobs.entity.EntityHostiles;
import com.greatorator.tolkienmobs.init.LootInit;
import com.greatorator.tolkienmobs.init.SoundInit;
import com.greatorator.tolkienmobs.init.TTMFeatures;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityWitchKing extends EntityHostiles {
    private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

    public EntityWitchKing(World worldIn) {
        super(worldIn);
        this.setSize(1.7F, 3.2F);
        this.setTtmAttack(true);
        this.setWeaponType(TTMFeatures.SWORD_WITCHKING);
        this.setLootTable(LootInit.WITCHKING);
        this.setMobAttributes(300.0D, 25.0D, 20.0D);
        this.setTtmEffect(MobEffects.BLINDNESS);
        this.setTtmDuration(200);
        this.setMobMentality(true, SoundInit.soundAngryWitchKing);
        this.setMadeBoss(true);
        this.isImmuneToFire = true;
        this.experienceValue = 200;
    }

    public void addTrackingPlayer(EntityPlayerMP player)
    {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void removeTrackingPlayer(EntityPlayerMP player)
    {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    public void setCustomNameTag(String name)
    {
        super.setCustomNameTag(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected void updateAITasks()
    {
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
        super.updateAITasks();
    }

    public void readEntityFromNBT(NBTTagCompound compound){
        if (this.hasCustomName())
        {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundInit.soundIdleWitchKing;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundInit.soundHurtWitchKing;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundInit.soundDeathWitchKing;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundInit.soundStepWitchKing, 0.25F, 1.0F);
    }
}