package cc.oilslug.pauth.events;

import cc.oilslug.pauth.PAuth;
import cc.oilslug.pauth.data.PlayerData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class BukkitEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(event.getPlayer().hasPermission("pauth.command.auth")) PAuth.getInstance().getDataManager().addPlayerData(event.getPlayer());
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        PlayerData data = PAuth.getInstance().getDataManager().getData(event.getPlayer());
        if(data == null)return;

        //Checking if the player isnt authenticated by the discord bot.
        if(!data.isAuthenticated()){
            event.setCancelled(true);
        }

    }

    //Blocking a players commands if they are not authenticated.
    @EventHandler
    public void onCommandEvent(PlayerCommandPreprocessEvent event){
        PlayerData data = PAuth.getInstance().getDataManager().getData(event.getPlayer());
        if(!data.isAuthenticated() && data.getPlayer().hasPermission("pauth.command.auth")){
            if(!event.getMessage().toLowerCase().contains("auth") || !event.getMessage().toLowerCase().contains("forceauth")) event.setCancelled(true);
        }
    }

}
