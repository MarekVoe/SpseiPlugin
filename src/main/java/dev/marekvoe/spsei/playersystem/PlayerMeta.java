package dev.marekvoe.spsei.playersystem;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerMeta {

    private static HashMap<String, PlayerMeta> metaTable = new HashMap<String, PlayerMeta>();

    public static PlayerMeta getMeta(Player player) {
        return getMeta(player.getName());
    }

    public static PlayerMeta getMeta(String username) {
        if (!metaTable.containsKey(username)) {
            metaTable.put(username, new PlayerMeta());
        }
        return metaTable.get(username);
    }

    public static void reset() {
        metaTable.clear();
    }

    private boolean isLeader;
    private String guildName;


    public boolean isLeader() {
        return isLeader;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }
}
