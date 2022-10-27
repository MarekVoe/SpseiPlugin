package dev.marekvoe.spsei.guildsystem;

import org.bukkit.entity.Player;

public class GuildInviteRequest {

    private Player sender, receiver;


    public GuildInviteRequest(Player sender, Player receiver) {
         this.sender = sender;
         this.receiver = receiver;
    }

    public Player getSender() {
        return sender;
    }

    public Player getReceiver() {
        return receiver;
    }
}
