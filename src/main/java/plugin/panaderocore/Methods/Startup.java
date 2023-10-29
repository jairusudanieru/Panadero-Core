package plugin.panaderocore.Methods;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import plugin.panaderocore.Commands.Core;
import plugin.panaderocore.Events.PlayerJoin;
import plugin.panaderocore.Events.PlayerQuit;

import java.util.Objects;

public class Startup {

   public static void registerEvents() {
      Bukkit.getPluginManager().registerEvents(new PlayerJoin(), CoreConfig.plugin);
      Bukkit.getPluginManager().registerEvents(new PlayerQuit(), CoreConfig.plugin);
   }

   public static void registerCommands() {
      getPluginCommand("panadero").setTabCompleter(new Core());
      getPluginCommand("panadero").setExecutor(new Core());
   }

   private static PluginCommand getPluginCommand(String command) {
      return Objects.requireNonNull(Bukkit.getPluginCommand(command));
   }

}
