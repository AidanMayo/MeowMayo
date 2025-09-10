package com.mmdev.meowmayo.features.kuudra;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.client.Minecraft;

import com.mmdev.meowmayo.utils.ChatMessages;

public class KuudraExtras {
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String msg = event.message.getUnformattedText();
        Minecraft mc = Minecraft.getMinecraft();

        if (mc.thePlayer == null) return;

        if (msg.equals("Your Fresh Tools Perk bonus doubles your building speed for the next 10 seconds!")) {
            ChatMessages.partyChat("FRESH!", mc);

            // Show title
            mc.ingameGUI.displayTitle("Warping!", "Hold on...", 10, 40, 10);

            // Play sound
            mc.thePlayer.playSound("minecraft:random.levelup", 1.0F, 1.0F);
        }
    }
}
