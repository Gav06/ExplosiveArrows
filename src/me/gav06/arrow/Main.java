package me.gav06.arrow;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    //method to access methods only accessible if the class is extending "JavaPlugin"
    public static Main getPlugin() {
        return getPlugin(Main.class);
    }

    //method that plugin calls on startup
    @Override
    public void onEnable() {
        //creates the configuration file if one doesn't exist yet
        this.saveDefaultConfig();
        //registering the event listener
        this.getServer().getPluginManager().registerEvents(new ArrowCollideEvent(), this);
    }
}
