package cc.oilslug.pauth.commands;

import cc.oilslug.pauth.settings.MessageSettings;
import cc.oilslug.pauth.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AuthCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("pauth.command.auth")){
                if(args.length == 0){
                    player.sendMessage(ChatUtils.colour("&7Usage: /auth <auth_code>"));
                    return true;
                }else{
                    //TODO finish authenticating.
                    String authCode = args[0];
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
