package plugin.panaderocore.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import plugin.panaderocore.Methods.AFKManager;

public class PlayerMove implements Listener {

   @EventHandler
   public void onPlayerMoveAFK(PlayerMoveEvent event) {
      Player player = event.getPlayer();
      if (event.hasChangedOrientation()) return;
      AFKManager.lastMovementHashMap.put(player, System.currentTimeMillis());
      if (!AFKManager.afkStatusHashMap.containsKey(player)) return;
      AFKManager.afkStatusHashMap.remove(player);
      AFKManager.removeToAFKTeam(player, AFKManager.afkTeam());
   }

}
