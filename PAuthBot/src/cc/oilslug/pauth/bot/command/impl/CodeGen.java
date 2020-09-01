package cc.oilslug.pauth.bot.command.impl;

import cc.oilslug.pauth.bot.command.api.Command;
import cc.oilslug.pauth.bot.utils.CodeGenUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CodeGen extends Command {

    public CodeGen() {
        super("gencode", "Generates 2FA code for minecraft");
    }

    @Override
    public void handle(GuildMessageReceivedEvent event, String[] args) {
        if (event.getChannel().getType() == ChannelType.PRIVATE) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.addField("Code", "``" + CodeGenUtil.transform(CodeGenUtil.generate2FA()) + "``", true);
            event.getChannel().sendMessage(embed.build()).queue();
        }else{
            EmbedBuilder embed = new EmbedBuilder();
            embed.addField("ERROR", "This command must be ran in dms", true);
            event.getChannel().sendMessage(embed.build()).queue();
        }
    }

}
