package cc.oilslug.pauth.commands;

import cc.oilslug.pauth.PAuth;
import cc.oilslug.pauth.data.PlayerData;
import cc.oilslug.pauth.settings.MessageSettings;
import cc.oilslug.pauth.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ForceAuthCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("pauth.command.forceauth")){
                if(args.length == 0){
                    PlayerData data = PAuth.getInstance().getDataManager().getData(player);
                    if(data.isAuthenticated() || data == null){
                        player.sendMessage(ChatUtils.colour("&cYou are already Authenticated!"));
                        return true;
                    }else{
                        data.setAuthenticated(true);
                        player.sendMessage(ChatUtils.colour("&aYou are now authenticated!"));
                        return true;
                    }
                }else{
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target == null){
                        player.sendMessage(ChatUtils.colour("&cPlayer not found!"));
                        return true;
                    }else{
                        PlayerData data = PAuth.getInstance().getDataManager().getData(target);
                        if(data.isAuthenticated() || data == null){
                            player.sendMessage(ChatUtils.colour("&c" + target.getName() + " is already Authenticated!"));
                        }else{
                            data.setAuthenticated(true);
                            player.sendMessage(ChatUtils.colour("&aYou have authenticated " + target.getName() + "!"));
                        }
                        return true;
                    }
                }
            }else{
                player.sendMessage(ChatUtils.colour(MessageSettings.ERROR_NO_PERMISSIONS));
            }
        }else{
            sender.sendMessage(ChatUtils.colour(MessageSettings.ERROR_NOT_PLAYER));
        }
        return true;
    }

}
