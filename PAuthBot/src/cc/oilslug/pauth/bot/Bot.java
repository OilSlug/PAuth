package cc.oilslug.pauth.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Bot {

    private static Bot instance;
    private JDA client;
    private JDABuilder builder;

    public Bot() throws Exception{
        instance = this;
        builder = new JDABuilder();
        builder.setToken(Settings.TOKEN);
        builder.setActivity(Activity.watching("http://pauth.oilslug.cc/"));

        client = builder.build();
    }

    public static Bot getInstance() {
        return instance;
    }
}
