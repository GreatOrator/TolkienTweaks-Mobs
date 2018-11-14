package com.greatorator.tolkienmobs.proxy;

import com.greatorator.tolkienmobs.client.render.entity.*;
import com.greatorator.tolkienmobs.entity.*;
import com.greatorator.tolkienmobs.handler.FogHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        RenderingRegistry.registerEntityRenderingHandler(EntityTreeEnt.class, RenderTreeEnt.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityMirkwoodSpider.class, RenderMirkwoodSpider.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityGoblin.class, RenderGoblin.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityMordorOrc.class, RenderMordorOrc.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityWarg.class, RenderWarg.FACTORY);
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
