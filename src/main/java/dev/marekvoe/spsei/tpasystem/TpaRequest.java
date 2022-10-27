package dev.marekvoe.spsei.tpasystem;

import org.bukkit.entity.Player;

public class TpaRequest {

    private Player sender, receiver;
    private TpaType type;

    public TpaRequest(Player sender, Player receiver, TpaType type) {
        this.sender = sender;
        this.receiver = receiver;
        this.type = type;
    }

    public Player getReceiver() {
        return receiver;
    }

    public Player getSender() {
        return sender;
    }

    public TpaType getType() {
        return type;
    }
}
