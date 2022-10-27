package dev.marekvoe.spsei.tpasystem;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TpaManager {

    private ArrayList<TpaRequest> requests = new ArrayList<TpaRequest>();

    public ArrayList<TpaRequest> getRequests() {
        return requests;
    }

    public TpaRequest getRequest(Player user) {
        for (TpaRequest request: requests) {
            if (request.getReceiver().getName().equalsIgnoreCase(user.getName())) {
                return request;
            }
        }
        return null;
    }

    public void addRequest(Player sender, Player receiver, TpaType type) {
        TpaRequest tpaRequest = new TpaRequest(sender, receiver, type);
        requests.add(tpaRequest);
    }

    public void removeRequest(Player user) {
        requests.remove(getRequest(user));
    }
}
