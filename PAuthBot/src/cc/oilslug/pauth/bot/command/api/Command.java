package cc.oilslug.pauth.bot.command.api;

import lombok.Getter;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

@Getter
public class Command {

    private String command, description;

    public Command(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public void handle(GuildMessageReceivedEvent event, String[] args){}

}
