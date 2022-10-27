package dev.marekvoe.spsei.playersystem;

import dev.marekvoe.spsei.Main;
import org.bukkit.entity.Player;

public class PlayerManager {

    private Main plugin;

    public PlayerManager(Main plugin) {
      this.plugin = plugin;
    }

    public void loadData(Player player) {
         PlayerMeta.getMeta(player).setLeader(plugin.getConfigManager().getConfig("player-data.yml").getBoolean(player.getName() + ".isLeader"));
    }

    public void saveData(Player player) {

    }
}
