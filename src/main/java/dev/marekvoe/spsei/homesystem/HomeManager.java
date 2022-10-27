package dev.marekvoe.spsei.homesystem;

import dev.marekvoe.spsei.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class HomeManager {
    private Main plugin;
    private String prefix = (ChatColor.translateAlternateColorCodes('&', "&8[&6Home&8] "));

    public HomeManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setHome(Player player) {
        plugin.getConfigManager().getConfig("homes.yml").set(player.getName() + ".home", player.getLocation());
        player.sendMessage(getPrefix() + ChatColor.GREEN + "Home set.");
        plugin.getConfigManager().save("homes.yml");
    }

    public Location getHome(Player player) {
        return (Location) plugin.getConfigManager().getConfig("homes.yml").get(player.getName() + ".home");
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
