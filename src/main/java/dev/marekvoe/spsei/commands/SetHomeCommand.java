package dev.marekvoe.spsei.commands;

import dev.marekvoe.spsei.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {

    private Main plugin;

    public SetHomeCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase(label)) {
            if (sender instanceof Player) {
                plugin.getHomeManager().setHome(player);
            } else {
                sender.sendMessage(ChatColor.RED + "Only players can use this home !");
            }
        }
        return false;
    }
}
