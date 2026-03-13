package com.theoria.commands;

import com.theoria.core.StackerLogic;

public class DonateCommand implements Commands {

    @Override
    public String cmdName() {
        return "donate";
    }

    @Override
    public void execute (String input, StackerLogic stacker) {
        stacker.buyCoffee();
    }

}
