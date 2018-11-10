package com.greatorator.tolkienmobs.entity.entityai;

import com.greatorator.tolkienmobs.entity.EntityGoblin;
import net.minecraft.entity.ai.EntityAIAttackMelee;

public class EntityAIGoblinAttack extends EntityAIAttackMelee {
    private int raiseArmTicks;
    private EntityGoblin Goblin;

    public EntityAIGoblinAttack(EntityGoblin zombieIn, double speedIn, boolean longMemoryIn) {
        super(zombieIn, speedIn, longMemoryIn);
        this.Goblin = zombieIn;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        super.startExecuting();
        this.raiseArmTicks = 0;
    }

    /**
     * Resets the task
     */
    @Override
    public void resetTask() {
        super.resetTask();
        this.Goblin.setArmsRaised(false);
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask() {
        super.updateTask();
        ++this.raiseArmTicks;

        if (this.raiseArmTicks >= 5 && this.attackTick < 10) {
            this.Goblin.setArmsRaised(true);
        } else {
            this.Goblin.setArmsRaised(false);
        }
    }
}