package plugin.panaderocore.Methods;

import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class WorldGroups {

   public static List<String> sameGroupWorlds(World world) {
      ConfigurationSection section = CoreConfig.getConfigSection("worldGroups");
      if (section == null) return new ArrayList<>();
      for (String groupName : section.getKeys(false)) {
         List<String> worldNames = section.getStringList(groupName);
         if (!worldNames.contains(world.getName())) continue;
         return worldNames;
      }
      return new ArrayList<>();
   }

}
