package dev.marekvoe.spsei.commands;

import dev.marekvoe.spsei.Main;
import dev.marekvoe.spsei.tpasystem.TpaType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpaCommand implements CommandExecutor {
    private Main plugin;

    public TpaCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Error #P3326");
            return true;
        }
        Player recipient = Bukkit.getPlayer(args[0]);

        if (recipient == null) {
            sender.sendMessage(plugin.getTpaPrefix() + ChatColor.RED + "Player could not be found.");
            return true;
        }

        if (recipient.getName().equalsIgnoreCase(sender.getName())) {
            sender.sendMessage(plugin.getTpaPrefix() + ChatColor.RED + "You cannot teleport to yourself.");
            return true;
        }

        if (plugin.getTpaManager().getRequest(recipient) != null) {
            sender.sendMessage(plugin.getTpaPrefix() + ChatColor.RED + args[0] + " already has active request !");
            return true;
        }

        plugin.getTpaManager().addRequest((Player) sender, recipient, TpaType.TPA);
        recipient.playSound(recipient.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1,1);
        recipient.sendMessage(plugin.getTpaPrefix() + ChatColor.GREEN + sender.getName() +
                ChatColor.DARK_GRAY + " wants to teleport to you. " + ChatColor.GREEN + "Do /tpaccept or /tpdeny");
        sender.sendMessage(plugin.getTpaPrefix() + ChatColor.DARK_GRAY + "Tpa request sent to " + ChatColor.GREEN + args[0]);

        return true;
    }
}
