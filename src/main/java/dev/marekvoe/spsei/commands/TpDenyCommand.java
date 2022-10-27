package dev.marekvoe.spsei.commands;

import dev.marekvoe.spsei.Main;
import dev.marekvoe.spsei.tpasystem.TpaRequest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpDenyCommand implements CommandExecutor {

    private Main plugin;

    public TpDenyCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.getTpaPrefix() + ChatColor.RED + "Error #PD428");
            return true;
        }

        TpaRequest request = plugin.getTpaManager().getRequest((Player) sender);
        Player recipient = Bukkit.getPlayer(request.getSender().getName());

        if (request == null) {
            sender.sendMessage(plugin.getTpaPrefix() + ChatColor.RED + "You do not have any existing requests.");
            return true;
        }

        sender.sendMessage(plugin.getTpaPrefix() + ChatColor.DARK_GRAY + "Request from " + ChatColor.GREEN + recipient.getName() +
                ChatColor.DARK_GRAY + " was denied.");
        recipient.sendMessage(plugin.getTpaPrefix() + ChatColor.DARK_GRAY + "Your request to " + ChatColor.GREEN + sender.getName()
        + ChatColor.DARK_GRAY + " was denied");
        plugin.getTpaManager().removeRequest((Player) sender);

        return true;
    }

}
