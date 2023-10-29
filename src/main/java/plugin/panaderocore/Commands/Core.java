package plugin.panaderocore.Commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.Plugin;
import plugin.panaderocore.Methods.CoreConfig;
import plugin.panaderolobby.PluginMethods.LobbyConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Core implements TabCompleter, CommandExecutor {

   @Override
   public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
      if (args.length != 1) return new ArrayList<>();
      return Arrays.asList("reload","info");
   }

   @Override
   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (args.length != 1) {
         Component message = CoreConfig.getComponent("message.invalidCommand");
         if (message == null) return true;
         sender.sendMessage(message);
         return true;
      }

      if (args[0].equals("reload")) {
         reloadCore(sender);
         reloadLobby(sender);
      } else if (args[0].equals("info")) {
         Component message = CoreConfig.getComponent("message.pluginInfoMessage");
         if (message == null) return true;
         sender.sendMessage(message);
      } else {
         Component message = CoreConfig.getComponent("message.invalidCommand");
         if (message == null) return true;
         sender.sendMessage(message);
      }
      return true;
   }

   private void reloadCore(CommandSender sender) {
      CoreConfig.plugin.reloadConfig();
      Component message = CoreConfig.getComponent("message.reloadMessage");
      if (message == null) return;
      sender.sendMessage(message);
   }

   private void reloadLobby(CommandSender sender) {
      Plugin lobbyPlugin = Bukkit.getPluginManager().getPlugin("PanaderoLobby");
      if (lobbyPlugin == null) return;
      LobbyConfig.reloadConfig();
      sender.sendMessage("");
   }

}
