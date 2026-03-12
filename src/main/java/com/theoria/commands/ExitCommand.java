package com.theoria.commands;

import com.theoria.core.StackerLogic;

public class ExitCommand implements Commands {

    @Override
    public String cmdName() {
        return "exit";
    }

    @Override
    public void execute(String input, StackerLogic stacker) throws Exception {
        System.out.println("Goodbye!");

        Thread.sleep(3000);
        System.exit(0);
    }

}
