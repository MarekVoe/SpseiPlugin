package dev.marekvoe.spsei;

import dev.marekvoe.spsei.commands.*;
import dev.marekvoe.spsei.configuration.ConfigManager;
import dev.marekvoe.spsei.guildsystem.GuildManager;
import dev.marekvoe.spsei.homesystem.HomeManager;
import dev.marekvoe.spsei.listeners.JoinListener;
import dev.marekvoe.spsei.listeners.QuitListener;
import dev.marekvoe.spsei.playersystem.PlayerManager;
import dev.marekvoe.spsei.tpasystem.TpaManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private String tpaPrefix = (ChatColor.translateAlternateColorCodes('&', "&8[&6TPA&8] "));
    private String homePrefix = (ChatColor.translateAlternateColorCodes('&', "&8[&6Home&8] "));
    private String guildPrefix = (ChatColor.translateAlternateColorCodes('&', "&8[&6Guilds&8] "));
    private PlayerManager playerManager;
    private GuildManager guildManager;
    private ConfigManager configManager;
    private HomeManager homeManager;
    private TpaManager tpaManager;

    @Override
    public void onEnable() {
          configManager = new ConfigManager(this);
          configManager.loadConfigFiles("config.yml", "homes.yml", "guilds.yml", "player-data.yml");
          this.homeManager = new HomeManager(this);
          this.tpaManager = new TpaManager();
          this.playerManager = new PlayerManager(this);
          this.guildManager = new GuildManager(this);
          registerCommands();
          registerListeners();
    }

    public void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JoinListener(this),this);
        pm.registerEvents(new QuitListener(this),this);
    }

    public void registerCommands() {
       getCommand("tpa").setExecutor(new TpaCommand(this));
       getCommand("tpaccept").setExecutor(new TpAcceptCommand(this));
       getCommand("tpdeny").setExecutor(new TpDenyCommand(this));
       getCommand("home").setExecutor(new HomeCommand(this));
       getCommand("sethome").setExecutor(new SetHomeCommand(this));
    }

    @Override
    public void onDisable() {

    }

    public String getHomePrefix() {
        return homePrefix;
    }

    public String getTpaPrefix() {
        return tpaPrefix;
    }

    public TpaManager getTpaManager() {
        return tpaManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public HomeManager getHomeManager() {
        return homeManager;
    }

    public GuildManager getGuildManager() {
        return guildManager;
    }

    public String getGuildPrefix() {
        return guildPrefix;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }
}
