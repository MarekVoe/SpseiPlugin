package dev.marekvoe.spsei.commands;

import dev.marekvoe.spsei.Main;
import dev.marekvoe.spsei.tpasystem.TpaRequest;
import dev.marekvoe.spsei.tpasystem.TpaType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpAcceptCommand implements CommandExecutor {

    private Main plugin;

    public TpAcceptCommand(Main plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.getTpaPrefix() + ChatColor.RED + "Error #01");
            return true;
        }
        Player user = (Player) sender;

        if (plugin.getTpaManager().getRequest(user) == null) {
            sender.sendMessage(plugin.getTpaPrefix()  + ChatColor.RED + "You do not have existing request !");
            return true;
        }

        TpaRequest request = plugin.getTpaManager().getRequest(user);
        String targetName = request.getSender().getName();

        Bukkit.getOnlinePlayers().toArray();

        Player recipient = Bukkit.getPlayer(targetName);

        if (recipient == null) {
            sender.sendMessage(plugin.getTpaPrefix() + ChatColor.RED + targetName + " is not online anymore");
            return true;
        }

        if (request.getType() == TpaType.TPA) {
            sender.sendMessage(ChatColor.DARK_GRAY + "Teleporting... " + ChatColor.GOLD + recipient.getName());
            recipient.teleport(user);
        }
        plugin.getTpaManager().removeRequest(user);

        return true;
    }
}

