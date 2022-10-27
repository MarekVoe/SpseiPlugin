package dev.marekvoe.spsei.guildsystem;

import dev.marekvoe.spsei.Main;
import dev.marekvoe.spsei.playersystem.PlayerMeta;
import dev.marekvoe.spsei.tpasystem.TpaRequest;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GuildManager {

    private Main plugin;

    public GuildManager(Main plugin) {
        this.plugin = plugin;
    }

    private ArrayList<GuildInviteRequest> invites = new ArrayList<GuildInviteRequest>();

    public ArrayList<GuildInviteRequest> getInvites() {
        return invites;
    }

    public GuildInviteRequest getInvite(Player user) {
        for (GuildInviteRequest invite: invites) {
            if (invite.getReceiver().getName().equalsIgnoreCase(user.getName())) {
                return invite;
            }
        }
        return null;
    }

    public void createGuild(Player owner, String guildName) {
        plugin.getConfigManager().getConfig("player-data.yml").set(owner.getName() + ".isLeader", true);
        plugin.getConfigManager().getConfig("player-data.yml").set(owner.getName() + ".guildName", guildName);
        owner.sendMessage(plugin.getGuildPrefix() + ChatColor.GREEN + "Guild " + guildName + " was created !");
    }

    public void guildInvite(Player sender, Player receiver) {
        if (PlayerMeta.getMeta(sender).isLeader()) {
          GuildInviteRequest invite = new GuildInviteRequest(sender, receiver);
          invites.add(invite);
        } else {
            sender.sendMessage(plugin.getGuildPrefix() + ChatColor.RED + "You are not leader of this guild !");
        }
    }

    public void removeInvite(Player user) {
        invites.remove(getInvite(user));
    }

    public void joinGuild(Player player, String guildName) {
          PlayerMeta.getMeta(player).setGuildName(guildName);
    }
}
