package com.theoria.cli;

import com.theoria.commands.*;
import com.theoria.core.StackerLogic;

import java.util.HashMap;
import java.util.Map;

public class CommandRouter {

    private final Map<String, Commands> commands = new HashMap<>();

    public CommandRouter() {
        register(new AddCommand());
        register(new RemoveCommand());
        register(new MoveCommand());
        register(new ListCommand());
        register(new MergeCommand());
        register(new ScanFolderCommand());
        register(new ScanDirectoryCommand());
        register(new StartOverCommand());
        register(new ExitCommand());
        register(new HelpCommand());
        register(new DonateCommand());
    }

    private void register(Commands command) {
        commands.put(command.cmdName(), command);
    }

    public void route(String input, StackerLogic stacker) throws Exception {
        String cmd = input.split("\\s+")[0].toLowerCase();

        Commands command = commands.get(cmd);

        if (command == null) {
            System.out.println("Invalid command. Type 'help'.");
            return;
        }

        command.execute(input, stacker);

    }

}
