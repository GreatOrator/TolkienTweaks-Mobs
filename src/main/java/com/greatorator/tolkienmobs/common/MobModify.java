package com.greatorator.tolkienmobs.common;

import net.minecraft.entity.LivingEntity;

public abstract class MobModify {
    protected MobModify nextMod;
    private static LivingEntity attackTarget;

    public MobModify() {
    }

    public abstract String getModName();

    public boolean onUpdate(LivingEntity mob) {
        if (nextMod != null) {
            return nextMod.onUpdate(mob);
        } else {
            if (attackTarget == null) {
                attackTarget = mob.world.getClosestPlayer(mob, 7.5f);
            }

            if (attackTarget != null) {
                if (!attackTarget.isAlive() || attackTarget.getDistance(mob) > 15f) {
                    attackTarget = null;
                }
            }
        }

        return false;
    }

    public static LivingEntity getMobTarget() {
        return attackTarget;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof MobModify && ((MobModify) o).getModName().equals(getModName()));
    }
}