package com.theoria.commands;

import com.theoria.core.StackerLogic;

public class MergeCommand implements Commands {

    @Override
    public String cmdName() {
        return "merge";
    }

    @Override
    public void execute(String input, StackerLogic stacker) throws Exception {


        String[] parse = input.trim().split("\\s+");

        if (parse.length < 2) {
            System.out.println("Usage: merge <nameIt.pdf>");
            return;
        }

        stacker.mergePdfFile(parse[1]);

        System.out.println("The PDF stack has been merged successfully.");

    }

}
