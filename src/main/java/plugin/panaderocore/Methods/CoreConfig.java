package plugin.panaderocore.Methods;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.panaderocore.Panadero_Core;

public class CoreConfig {

   public static final JavaPlugin plugin = JavaPlugin.getPlugin(Panadero_Core.class);

   public static Component getComponent(String key) {
      String string = plugin.getConfig().getString(key);
      if (string == null) return null;
      MiniMessage miniMessage = MiniMessage.miniMessage();
      return miniMessage.deserialize(string);
   }

   public static Component text(String text) {
      MiniMessage miniMessage = MiniMessage.miniMessage();
      return miniMessage.deserialize(text);
   }

   public static String getString(String key) {
      return plugin.getConfig().getString(key);
   }

   public static ConfigurationSection getConfigSection(String key) {
      return plugin.getConfig().getConfigurationSection(key);
   }

   public static Location getLocation(String key) {
      return plugin.getConfig().getLocation(key);
   }

   public static World getWorld(String key) {
      String string = plugin.getConfig().getString(key);
      if (string == null) return null;
      return Bukkit.getWorld(string);
   }

}
