package cc.oilslug.pauth.bot;

import cc.oilslug.pauth.bot.command.api.CommandManager;
import cc.oilslug.pauth.bot.listeners.ClientListeners;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Bot {

    private static Bot instance;
    private JDA client;
    private JDABuilder builder;

    private CommandManager commandManager;

    public Bot() throws Exception{
        instance = this;
        commandManager = new CommandManager();

        builder = new JDABuilder();
        builder.setToken(Settings.TOKEN);
        builder.setActivity(Activity.watching("http://discord.oilslug.cc/"));

        builder.addEventListeners(new ClientListeners());

        client = builder.build();
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public JDA getClient() {
        return client;
    }

    public static Bot getInstance() {
        return instance;
    }
}
