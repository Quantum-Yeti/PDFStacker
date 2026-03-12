package com.theoria.commands;

import com.theoria.core.StackerLogic;

public class StartOverCommand implements Commands {

    @Override
    public String cmdName() {
        return "startOver";
    }

    @Override
    public void execute(String input, StackerLogic stacker) throws Exception {
        stacker.startNew();
    }

}
