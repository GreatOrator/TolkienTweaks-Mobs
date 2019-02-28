package com.greatorator.tolkienmobs.proxy;

import com.greatorator.tolkienmobs.TolkienMobs;
import com.greatorator.tolkienmobs.client.TTMClientEvents;
import com.greatorator.tolkienmobs.client.render.entity.RenderBirds;
import com.greatorator.tolkienmobs.client.render.entity.RenderHerds;
import com.greatorator.tolkienmobs.client.render.entity.ammo.RenderBoulder;
import com.greatorator.tolkienmobs.client.render.entity.ammo.RenderFellBeastFireball;
import com.greatorator.tolkienmobs.client.render.entity.boss.RenderBalrog;
import com.greatorator.tolkienmobs.client.render.entity.boss.RenderFellBeast;
import com.greatorator.tolkienmobs.client.render.entity.special.RenderNazgul;
import com.greatorator.tolkienmobs.client.render.entity.boss.RenderWitchKing;
import com.greatorator.tolkienmobs.client.render.entity.monster.*;
import com.greatorator.tolkienmobs.client.render.entity.passive.*;
import com.greatorator.tolkienmobs.client.render.entity.special.RenderGollum;
import com.greatorator.tolkienmobs.client.render.model.monster.ModelCrebain;
import com.greatorator.tolkienmobs.client.render.model.passive.ModelAuroch;
import com.greatorator.tolkienmobs.client.render.model.passive.ModelMumakil;
import com.greatorator.tolkienmobs.entity.ammo.EntityBoulder;
import com.greatorator.tolkienmobs.entity.ammo.EntityFellBeastFireball;
import com.greatorator.tolkienmobs.entity.boss.EntityTMBalrog;
import com.greatorator.tolkienmobs.entity.boss.EntityTMFellBeast;
import com.greatorator.tolkienmobs.entity.special.EntityTMNazgul;
import com.greatorator.tolkienmobs.entity.boss.EntityTMWitchKing;
import com.greatorator.tolkienmobs.entity.monster.*;
import com.greatorator.tolkienmobs.entity.passive.*;
import com.greatorator.tolkienmobs.entity.special.EntityTMGollum;
import com.greatorator.tolkienmobs.handler.FogHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    public void registerModel(Item item, int metadata)
    {
        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        MinecraftForge.EVENT_BUS.register(new TTMClientEvents());

        OBJLoader.INSTANCE.addDomain(TolkienMobs.MODID);
        /* Bosses */
        RenderingRegistry.registerEntityRenderingHandler(EntityTMBalrog.class, RenderBalrog.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMFellBeast.class, RenderFellBeast::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMWitchKing.class, RenderWitchKing.FACTORY);

        /* Monsters */
        RenderingRegistry.registerEntityRenderingHandler(EntityTMHuron.class, RenderHuron.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMOathbreaker.class, RenderOathbreaker.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMTreeEnt.class, RenderTreeEnt.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMMirkwoodSpider.class, RenderMirkwoodSpider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMGoblin.class, RenderGoblin.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMMordorOrc.class, RenderMordorOrc.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMWarg.class, RenderWarg.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(
                EntityTMCrebain.class,
                RenderBirds.getRenderFactory(
                        new ModelCrebain(),
                        new ModelCrebain(),
                        0.5F,
                        new ResourceLocation(TolkienMobs.MODID + ":textures/entity/crebain.png"),
                        new ResourceLocation(TolkienMobs.MODID + ":textures/entity/bird_legband.png")
                )
        );
        RenderingRegistry.registerEntityRenderingHandler(EntityTMTroll.class, RenderTroll.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMUrukHai.class, RenderUrukHai.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMBarrowWight.class, RenderBarrowWight.FACTORY);

        /* Special */
        RenderingRegistry.registerEntityRenderingHandler(EntityTMGollum.class, RenderGollum.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMNazgul.class, RenderNazgul.FACTORY);

        /* Passive */
        RenderingRegistry.registerEntityRenderingHandler(EntityTMHobbit.class, RenderHobbit.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMDwarf.class, RenderDwarf.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMHuman.class, RenderHuman.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMElves.class, RenderElves.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMGoat.class, RenderGoat.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMSquirrel.class, RenderSOSquirrel.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityTMToad.class, RenderToaddle.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(
                EntityTMMumakil.class,
                RenderHerds.getRenderFactory(
                        new ModelMumakil(),
                        2.0F,
                        new ResourceLocation(TolkienMobs.MODID + ":textures/entity/mumakil.png")
                )
        );
        RenderingRegistry.registerEntityRenderingHandler(
                EntityTMAuroch.class,
                RenderHerds.getRenderFactory(
                        new ModelAuroch(),
                        0.5F,
                        new ResourceLocation(TolkienMobs.MODID + ":textures/entity/auroch.png")
                )
        );

        /* Miscellaneous */
        RenderingRegistry.registerEntityRenderingHandler(EntityBoulder.class, RenderBoulder.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityFellBeastFireball.class, RenderFellBeastFireball.FACTORY);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(new FogHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}