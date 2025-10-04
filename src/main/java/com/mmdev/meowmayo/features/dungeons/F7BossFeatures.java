package com.mmdev.meowmayo.features.dungeons;

import com.mmdev.meowmayo.config.ConfigSettings;
import com.mmdev.meowmayo.config.settings.ToggleSetting;
import com.mmdev.meowmayo.utils.PlayerUtils;
import com.mmdev.meowmayo.utils.events.S02ChatReceivedEvent;
import com.mmdev.meowmayo.utils.events.S32ReceivedEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class F7BossFeatures {
    private ToggleSetting p3Death = (ToggleSetting) ConfigSettings.getSetting("Phase 3 Death Warning");
    public static int bossPhase = 0;
    // 1 = maxor, 2 = storm, 3 = terms, 4 = tunnel, 5 = necron, 6 = relics, 7 = dragons

    private static int p3TickTimer = 0;

    @SubscribeEvent
    public void onServerTick(S32ReceivedEvent event) {
        if (p3Death.getValue()) {
            if (bossPhase == 3) {
                if (p3TickTimer > 45) {
                    PlayerUtils.makeTextAlert("DAMAGE TICK INCOMING!", "note.pling", 20);
                }
                if (p3TickTimer >= 60) {
                    PlayerUtils.makeTextTitle("DAMAGE TICK PASSED!", 100);
                    p3TickTimer = 0;
                }
                p3TickTimer++;
            }
        }
    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        bossPhase = 0;
    }

    @SubscribeEvent
    public void onChatPacket(S02ChatReceivedEvent event) {
        String msg = event.getUnformattedMessage();

        if (msg.equals("[BOSS] Maxor: WELL! WELL! WELL! LOOK WHO'S HERE!")) {
            bossPhase = 1;
        }

        if (msg.equals("[BOSS] Storm: Pathetic Maxor, just like expected.")) {
            bossPhase = 2;
        }

        if (msg.equals("[BOSS] Goldor: Who dares trespass into my domain?")) {
            bossPhase = 3;
            p3TickTimer = 0;
        }

        if (msg.equals("The Core entrance is opening!")) {
            bossPhase = 4;
        }

        if (msg.equals("[BOSS] Necron: You went further than any human before, congratulations.")) {
            bossPhase = 5;
        }

        if (msg.equals("[BOSS] Necron: All this, for nothing...")) {
            bossPhase = 6;
        }

        if (msg.equals("[BOSS] Wither King: You... again?")) {
            bossPhase = 7;
        }
    }
}
