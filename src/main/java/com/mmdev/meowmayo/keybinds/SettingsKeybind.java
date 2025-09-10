//package com.mmdev.meowmayo.keybinds;
//
//import net.minecraft.client.settings.KeyBinding;
//import net.minecraftforge.fml.client.registry.ClientRegistry;
//import org.lwjgl.input.Keyboard;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ModKeybinds {
//
//    // List to keep track of all registered keybinds
//    private static final List<KeyBinding> keybinds = new ArrayList<>();
//
//    // Example keybinds
//    public static KeyBinding openSettings;
//
//    public static void init() {
//        // Initialize keybinds
//        openSettings = registerKey("Open Settings", Keyboard.KEY_M);
//
//        // ...register more keybinds here
//    }
//
//    private static KeyBinding registerKey(String name, int keyCode) {
//        KeyBinding kb = new KeyBinding(name, keyCode, "MeowMayo");
//        ClientRegistry.registerKeyBinding(kb);
//        keybinds.add(kb);
//        return kb;
//    }
//
//    // Utility to get all keybinds
//    public static List<KeyBinding> getKeybinds() {
//        return keybinds;
//    }
//}
