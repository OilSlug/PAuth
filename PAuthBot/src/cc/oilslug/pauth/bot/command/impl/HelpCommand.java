package cc.oilslug.pauth.bot.command.impl;

import cc.oilslug.pauth.bot.Bot;
import cc.oilslug.pauth.bot.command.api.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class HelpCommand extends Command {

    public HelpCommand(String command, String description) {
        super(command, description);
    }

    @Override
    public void handle(GuildMessageReceivedEvent event, String[] args) {

        EmbedBuilder embedBuilder = new EmbedBuilder();
        boolean inline = Bot.getInstance().getCommandManager().commands.size() > 3;
        for(Command command : Bot.getInstance().getCommandManager().commands){
            embedBuilder.addField(command.getCommand(), command.getDescription(), inline);
        }
        event.getMessage().getChannel().sendMessage(embedBuilder.build()).queue();

    }
}
