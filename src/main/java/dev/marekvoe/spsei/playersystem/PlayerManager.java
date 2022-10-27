package dev.marekvoe.spsei.playersystem;

import dev.marekvoe.spsei.Main;
import org.bukkit.entity.Player;

public class PlayerManager {

    private Main plugin;

    public PlayerManager(Main plugin) {
      this.plugin = plugin;
    }

    public void loadData(Player player) {
         PlayerMeta.getMeta(player).setLeader(plugin.getConfigManager().getConfig("player-data.yml")
                 .getBoolean(player.getName() + ".isLeader"));
         PlayerMeta.getMeta(player).setGuildName(plugin.getConfigManager().getConfig("player-data.yml").
                 getString(player.getName() + ".guildName"));

    }

    public void saveData(Player player) {
        plugin.getConfigManager().getConfig("player-data.yml")
                .set(player.getName() + ".isLeader", PlayerMeta.getMeta(player).isLeader());
        plugin.getConfigManager().getConfig("player-data.yml")
                .set(player.getName() + ".guildName", PlayerMeta.getMeta(player).getGuildName());
        plugin.getConfigManager().save("player-data.yml");
    }
}
