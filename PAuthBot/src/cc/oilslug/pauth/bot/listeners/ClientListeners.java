package cc.oilslug.pauth.bot.listeners;

import cc.oilslug.pauth.bot.Bot;
import cc.oilslug.pauth.bot.Settings;
import cc.oilslug.pauth.bot.command.api.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class ClientListeners extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if(args[0].equalsIgnoreCase(Settings.PREFIX)){
            if(args.length <= 1){
                EmbedBuilder embedBuilder = new EmbedBuilder();
                boolean inline = Bot.getInstance().getCommandManager().commands.size() > 3;
                embedBuilder.setColor(0xff000000);
                for(Command command : Bot.getInstance().getCommandManager().commands){
                    embedBuilder.addField(command.getCommand(), command.getDescription(), inline);
                }
                event.getMessage().getChannel().sendMessage(embedBuilder.build()).queue();
            }else{
                String commandArg = args[1].toLowerCase();
                for(Command command : Bot.getInstance().getCommandManager().commands){
                    if(commandArg.equalsIgnoreCase(command.getCommand())) {
                        command.handle(event, args);
                        return;
                    }
                }
                EmbedBuilder embedBuilder = new EmbedBuilder();
                boolean inline = Bot.getInstance().getCommandManager().commands.size() > 3;
                embedBuilder.setColor(0xff000000);
                for(Command command : Bot.getInstance().getCommandManager().commands){
                    embedBuilder.addField(command.getCommand(), command.getDescription(), inline);
                }
                event.getMessage().getChannel().sendMessage(embedBuilder.build()).queue();
            }
        }
    }

}
