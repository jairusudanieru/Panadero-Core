package plugin.panaderocore.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import plugin.panaderocore.Methods.AFKManager;
import plugin.panaderocore.Methods.CoreConfig;

public class PlayerQuit implements Listener {

   @EventHandler
   public void onPlayerQuit(PlayerQuitEvent event) {
      Plugin panaderoLobby = Bukkit.getPluginManager().getPlugin("PanaderoLobby");
      if (panaderoLobby != null) return;
      Player player = event.getPlayer();
      String quitMessage = CoreConfig.getString("quitMessage");
      if (quitMessage == null || quitMessage.isEmpty()) return;
      quitMessage = quitMessage.replace("%player%", player.getName());
      event.quitMessage(CoreConfig.text(quitMessage));
   }

   @EventHandler
   public void onPlayerQuitAFK(PlayerQuitEvent event) {
      Player player = event.getPlayer();
      AFKManager.lastMovementHashMap.remove(player);
      if (!AFKManager.afkStatusHashMap.containsKey(player)) return;
      AFKManager.afkStatusHashMap.remove(player);
      AFKManager.removeToAFKTeam(player, AFKManager.afkTeam());
   }


}
