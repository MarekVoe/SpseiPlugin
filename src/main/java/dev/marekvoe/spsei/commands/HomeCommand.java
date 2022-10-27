package dev.marekvoe.spsei.commands;

import dev.marekvoe.spsei.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

    private Main plugin;

    public HomeCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase(label)) {
                player.teleport(plugin.getHomeManager().getHome(player));
            }
        }
        return false;
    }
}
