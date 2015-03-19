package me.adam561.mep2;

import me.adam561.mep2.VersionManager.Metrics;
import me.adam561.mep2.VersionManager.Updater;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Adam561 on 3/19/2015.
 *
 * More Enchants Plus v2.0
 *
 * Main class for enchantment and Config management.
 *
 */
public class Main extends JavaPlugin implements Listener{

    protected Logger log;
    private Main plugin;

    public static boolean update = false;
    public static String name = "";
    public static Updater.ReleaseType type = null;
    public static String version = "";
    public static String link = "";

    public void onEnable(){

        this.log = this.getLogger();
        this.plugin = this;

        getConfig().options().copyDefaults(true);
        saveConfig();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);

        if(getConfig().getBoolean("canUpdate")) {
            Updater updater = new Updater(this, 79543, this.getFile(), Updater.UpdateType.NO_DOWNLOAD, false); // Start Updater but just do a version check
            this.update = updater.getResult() == Updater.UpdateResult.UPDATE_AVAILABLE; // Determine if there is an update ready for us
            this.name = updater.getLatestName(); // Get the latest name
            this.version = updater.getLatestGameVersion(); // Get the latest game version
            this.type = updater.getLatestType(); // Get the latest file's type
            this.link = updater.getLatestFileLink(); // Get the latest link
        }

        if (getConfig().getBoolean("metrics")) {
            try {
                Metrics metrics = new Metrics(this);
                metrics.start();
            } catch (IOException e) {
                // Failed to submit the stats :-(
            }
        }
    }



}
