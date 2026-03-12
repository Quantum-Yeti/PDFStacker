package com.theoria.commands;

import com.theoria.core.StackerLogic;

public interface Commands {

    String cmdName();

    void execute(String input, StackerLogic stacker) throws Exception;

}
