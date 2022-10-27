package dev.marekvoe.spsei.listeners;

import dev.marekvoe.spsei.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private Main plugin;

    public JoinListener(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.DARK_GRAY + "] "
                + ChatColor.GREEN + player.getName());
        sendNews(player);

    }

    private void sendNews(Player player) {
        player.sendMessage(ChatColor.DARK_GRAY + "----[" + ChatColor.GREEN + "" + ChatColor.BOLD + "NEWS" + ChatColor.DARK_GRAY + "]----");
        player.sendMessage(ChatColor.GREEN +  "- Pridan prikaz /tpdeny");
        player.sendMessage(ChatColor.GREEN + "-  Pridany guildy: /guild create $jmeno_guildy$, /guild invite $jmeno_hrace$, /guild leave");
        player.sendMessage(ChatColor.GREEN + "- Pridany hracske statistiky, momentalne pracuji na web interface pro graficke znazorneni :)");
        player.sendMessage(ChatColor.GREEN + "- Jestli se nekdo chce podivat na kod je dostupny na github.com/MarekVoe");
    }
}
