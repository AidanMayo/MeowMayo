package com.mmdev.meowmayo;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.ClientCommandHandler;

//how to import commands
import com.mmdev.meowmayo.config.ModConfig;
import com.mmdev.meowmayo.gui.GuiHandler;
import com.mmdev.meowmayo.commands.SettingsCommand;
import com.mmdev.meowmayo.features.chat;

@Mod(modid = MeowMayo.MODID, version = MeowMayo.VERSION, clientSideOnly = true)
public class MeowMayo {
    public static final String MODID = "meowmayo";
    public static final String VERSION = "0.0.1";

    // Initialization
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        org.lwjgl.opengl.Display.setTitle("MeowMayo");
        ModConfig.init(event.getSuggestedConfigurationFile().getParentFile());
        System.out.println(event.getSuggestedConfigurationFile().getParentFile());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Register commands
        ClientCommandHandler.instance.registerCommand(new SettingsCommand());

        MinecraftForge.EVENT_BUS.register(new GuiHandler());
        // Register event handlers
        MinecraftForge.EVENT_BUS.register(new chat());
    }
}
