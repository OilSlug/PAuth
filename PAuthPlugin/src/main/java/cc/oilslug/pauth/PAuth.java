package cc.oilslug.pauth;

import cc.oilslug.pauth.commands.AuthCommand;
import cc.oilslug.pauth.commands.ForceAuthCommand;
import cc.oilslug.pauth.data.DataManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PAuth extends JavaPlugin {

    private static PAuth instance;
    private DataManager dataManager;

    @Override
    public void onEnable() {
        instance = this;
        dataManager = new DataManager();

        getCommand("auth").setExecutor(new AuthCommand());
        getCommand("forceauth").setExecutor(new ForceAuthCommand());
    }

    @Override
    public void onDisable() {

    }

    public static PAuth getInstance() {
        return instance;
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
