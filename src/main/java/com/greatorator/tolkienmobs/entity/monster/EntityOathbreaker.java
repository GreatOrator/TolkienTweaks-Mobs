package com.greatorator.tolkienmobs.entity.monster;

import com.greatorator.tolkienmobs.entity.EntityHostiles;
import com.greatorator.tolkienmobs.init.LootInit;
import com.greatorator.tolkienmobs.init.SoundInit;
import com.greatorator.tolkienmobs.init.TTMFeatures;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.init.MobEffects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityOathbreaker extends EntityHostiles {

    public EntityOathbreaker(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 2.0F);
        this.setWeaponType(TTMFeatures.SWORD_MORGULIRON);
        this.setLootTable(LootInit.OATHBREAKER);
        this.setTtmEffect(MobEffects.POISON);
        this.setTtmDuration(1);
        this.setMobAttributes(16.0D, 5.0D, 3.0D);
        this.setRndMinMax(1,5);
    }

    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    @Override
    public SoundCategory getSoundCategory()
    {
        return SoundCategory.HOSTILE;
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundInit.soundIdleOathbreaker;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundInit.soundHurtBarrowWight;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundInit.soundHurtBarrowWight;
    }
}