package dev.marekvoe.spsei.guildsystem;

import dev.marekvoe.spsei.Main;
import dev.marekvoe.spsei.playersystem.PlayerMeta;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GuildManager {

    private Main plugin;

    public GuildManager(Main plugin) {
        this.plugin = plugin;
    }

    public void createGuild(Player owner, String guildName) {
        plugin.getConfigManager().getConfig("player-data.yml").set(owner.getName() + ".isLeader", true);
        plugin.getConfigManager().getConfig("player-data.yml").set(owner.getName() + ".guildName", guildName);
    }

    public void guildInvite(Player sender, Player receiver) {
        if (PlayerMeta.getMeta(sender).isLeader()) {

        } else {
            sender.sendMessage(plugin.getGuildPrefix() + ChatColor.RED + "You are not leader of this guild !");
        }
    }

    public void joinGuild(Player player) {

    }
}
