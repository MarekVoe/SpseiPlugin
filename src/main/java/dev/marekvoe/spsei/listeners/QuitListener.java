package dev.marekvoe.spsei.listeners;

import dev.marekvoe.spsei.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    private Main plugin;

    public QuitListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "-" + ChatColor.DARK_GRAY + "] "
                + ChatColor.RED + player.getName());
        plugin.getPlayerManager().saveData(player);
    }
}
