package com.greatorator.tolkienmobs.events;

import com.greatorator.tolkienmobs.entity.monster.EntityCrebain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class CrebainTameEvent extends LivingEvent {
        private final EntityCrebain theBird;
        private final EntityPlayer tamer;

        /**
         * Instantiates a new bird tame event.
         *
         * @param parBird the par bird
         * @param parTamer the par tamer
         */
        public CrebainTameEvent(EntityCrebain parBird, EntityPlayer parTamer)
        {
            super(parBird);
            theBird = parBird;
            tamer = parTamer;
        }

        /**
         * Gets the animal.
         *
         * @return the animal
         */
        public EntityCrebain getAnimal()
        {
            return theBird;
        }

        /**
         * Gets the tamer.
         *
         * @return the tamer
         */
        public EntityPlayer getTamer()
        {
            return tamer;
        }
}
