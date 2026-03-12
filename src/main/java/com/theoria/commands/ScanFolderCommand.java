package com.theoria.commands;

import com.theoria.core.StackerLogic;

public class ScanFolderCommand implements Commands {

    @Override
    public String cmdName() {
        return "scanf";
    }

    @Override
    public void execute(String input, StackerLogic stacker) throws Exception {
        stacker.scanFolder();
    }

}
