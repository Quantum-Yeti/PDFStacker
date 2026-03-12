package com.theoria.commands;

import com.theoria.core.StackerLogic;

public class RemoveCommand implements Commands {

    @Override
    public String cmdName() {
        return "remove";
    }

    @Override
    public void execute(String input, StackerLogic stacker) throws Exception {

        String[] parse = input.trim().split("\\s+");

        if (parse.length < 2) {
            System.out.println("Usage: remove <index>");
            return;
        }

        int index = Integer.parseInt(parse[1]);
        stacker.removePdfFile(index);

        System.out.println("Removed file number: " + index + " successfully.");

    }

}
