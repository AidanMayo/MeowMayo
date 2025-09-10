package com.mmdev.meowmayo.config;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import com.mmdev.meowmayo.config.settings.*;

import com.mmdev.meowmayo.config.ConfigSettings;

public class ModConfig {

    private static File configFile;

    private static List<SettingCategory> settings = new ArrayList<>();

    /**
     * Initialize the configuration. Should be called from the main mod class preInit.
     * @param mcConfigDir The Minecraft config directory (passed from FMLPreInitializationEvent)
     */
    public static void init(File mcConfigDir) {
        // Ensure the config directory exists
        if (!mcConfigDir.exists()) mcConfigDir.mkdirs();

        // Use a file inside the config folder
        configFile = new File(mcConfigDir, "meowmayo.meow");

        if (!configFile.exists()) { // ensure the user has a config file to read
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        load();
    }

    /** Load the configuration from the file */
    public static void load() {
        ConfigSettings.init(configFile);
        settings = ConfigSettings.sortSettings();

        for (SettingCategory s: settings) {
            System.out.println(s.getName());
            System.out.println("\tMisc:");
            for (Setting sc : s.getMiscSettings()) {
                System.out.println("\t\t" + sc.getTitle());
            }
            System.out.println("\tSubcategories:");
            for (SettingSubcategory ss : s.getSubcategories()) {
                System.out.println("\t\t" + ss.getName());
                for (Setting ssc : ss.getSettings()) {
                    System.out.println("\t\t\t" + ssc.getTitle());
                }
            }
        }
    }

    public static List<SettingCategory> getSettings() {
        return settings;
    }

    /** Save the configuration to the file */
    public static void edit(String setting, Object value) {
        ConfigSettings.edit(setting, value); // i love objects
    }
}
