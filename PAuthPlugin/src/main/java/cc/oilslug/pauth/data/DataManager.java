package cc.oilslug.pauth.data;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class DataManager {

    public ArrayList<PlayerData> playerData;

    public DataManager(){
        playerData = new ArrayList<>();
    }

    public void addPlayerData(Player player){
        if(getData(player) == null) playerData.add(new PlayerData(player));
    }

    public PlayerData getData(Player player){
        for(PlayerData data : playerData)
            if(data.getPlayer().getUniqueId() == player.getUniqueId())return data;
        return null;
    }

}
