package plugin.panaderocore.Methods;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import plugin.panaderocore.Commands.AFK;
import plugin.panaderocore.Commands.Core;
import plugin.panaderocore.Events.PlayerJoin;
import plugin.panaderocore.Events.PlayerMove;
import plugin.panaderocore.Events.PlayerQuit;

import java.util.Objects;

public class Startup {

   public static void registerEvents() {
      Bukkit.getPluginManager().registerEvents(new PlayerJoin(), CoreConfig.plugin);
      Bukkit.getPluginManager().registerEvents(new PlayerMove(), CoreConfig.plugin);
      Bukkit.getPluginManager().registerEvents(new PlayerQuit(), CoreConfig.plugin);
   }

   public static void registerCommands() {
      registerCommand("panadero", new Core(), new Core());
      registerCommand("afk", new AFK(), new AFK());
   }

   private static void registerCommand(String command, CommandExecutor executor, TabCompleter completer) {
      PluginCommand pluginCommand = Objects.requireNonNull(Bukkit.getPluginCommand(command));
      pluginCommand.setExecutor(executor);
      pluginCommand.setTabCompleter(completer);
   }

}
