package plugin.panaderocore.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import plugin.panaderocore.Methods.CoreConfig;

public class PlayerJoin implements Listener {

   @EventHandler
   public void onPlayerJoin(PlayerJoinEvent event) {
      Plugin panaderoLobby = Bukkit.getPluginManager().getPlugin("PanaderoLobby");
      if (panaderoLobby != null) return;
      Player player = event.getPlayer();
      String joinMessage = CoreConfig.getString("joinMessage");
      if (joinMessage == null || joinMessage.isEmpty()) return;
      joinMessage = joinMessage.replace("%player%",player.getName());
      event.joinMessage(CoreConfig.text(joinMessage));
   }

}
