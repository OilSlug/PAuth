package cc.oilslug.pauth.data;

import org.bukkit.entity.Player;

public class PlayerData {

    private Player player;
    private boolean authenticated;

    public PlayerData(Player player){
        this.player = player;
        this.authenticated = false;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public Player getPlayer() {
        return player;
    }
}
