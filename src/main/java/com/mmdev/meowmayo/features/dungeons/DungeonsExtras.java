package com.mmdev.meowmayo.features.dungeons;

import com.mmdev.meowmayo.config.ConfigSettings;
import com.mmdev.meowmayo.config.settings.ToggleSetting;
import com.mmdev.meowmayo.utils.ChatUtils;
import com.mmdev.meowmayo.utils.events.S02ChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DungeonsExtras {
    private ToggleSetting announceLeap = (ToggleSetting) ConfigSettings.getSetting("Announce Spirit Leap");

    private Pattern spiritLeap = Pattern.compile("You have teleported to (.+)!");

    @SubscribeEvent
    public void onChatPacket(S02ChatReceivedEvent event) {
        String message = event.getUnformattedMessage();

        if (announceLeap.getValue()) {
            Matcher matcher = spiritLeap.matcher(message);
            if (matcher.matches()) {
                ChatUtils.partyChat("Leaped to " + matcher.group(1));
            }
        }
    }
}
