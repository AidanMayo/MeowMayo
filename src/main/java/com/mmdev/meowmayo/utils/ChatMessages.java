package com.mmdev.meowmayo.utils;

import net.minecraft.client.Minecraft;

public class ChatMessages {
    public static void allChat(String message, Minecraft mc) {
        mc.thePlayer.sendChatMessage("/ac " + message);
    }

    public static void guildChat(String message, Minecraft mc) {
        mc.thePlayer.sendChatMessage("/gc " + message);
    }

    public static void partyChat(String message, Minecraft mc) {
        mc.thePlayer.sendChatMessage("/pc " + message);
    }

    public static void command(String command, Minecraft mc) {
        mc.thePlayer.sendChatMessage("/" + command);
    }
}