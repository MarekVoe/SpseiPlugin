package dev.marekvoe.spsei.commands;

import dev.marekvoe.spsei.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GuildCommand implements CommandExecutor {

    private Main plugin;

    public GuildCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase(label)) {
            if (sender instanceof Player) {
               if (args.length == 0) {
                   player.sendMessage(plugin.getGuildPrefix() + ChatColor.RED + "Not enough arguments !");
               } else if (args.length == 1) {

               } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("create") && args[1] != null) {
                        plugin.getGuildManager().createGuild(player, args[1]);
                    } else if (args[0].equalsIgnoreCase("invite") && args[1] != null) {
                        Player receiver = Bukkit.getPlayer(args[1]);
                        plugin.getGuildManager().guildInvite(player, receiver);
                    }
               }
            } else {
                sender.sendMessage(plugin.getGuildPrefix() + ChatColor.RED + "ERROR - Only players can use this command !");
            }
        }
        return false;
    }
}
