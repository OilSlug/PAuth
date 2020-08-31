package cc.oilslug.pauth.bot.command.api;

import cc.oilslug.pauth.bot.command.impl.CodeGen;
import cc.oilslug.pauth.bot.command.impl.HelpCommand;

import java.util.ArrayList;

public class CommandManager {

    public ArrayList<Command> commands;

    public CommandManager(){
        commands = new ArrayList<>();
        registerCommands();
    }

    private void registerCommands(){
        addCommand(new HelpCommand("help", "Shows all commands and what they do."));
        addCommand(new CodeGen());
    }

    private void addCommand(Command command){
        if(!commands.contains(command)){
            commands.add(command);
        }
    }

}
