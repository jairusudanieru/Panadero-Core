package plugin.panaderocore;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.panaderocore.Methods.Startup;

public final class Panadero_Core extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Startup.registerCommands();
        Startup.registerEvents();
    }

    @Override
    public void onDisable() {
    }

}
