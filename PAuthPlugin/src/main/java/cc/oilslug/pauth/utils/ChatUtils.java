package cc.oilslug.pauth.utils;

import org.bukkit.ChatColor;

public class ChatUtils {
    public static String colour(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
