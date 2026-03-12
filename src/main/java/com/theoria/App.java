package com.theoria;

import com.theoria.cli.StackerCLI;
import com.theoria.utils.CLILogger;

public class App {
    public static void main(String[] args) {

        try {
            StackerCLI.run();
        } catch (Exception e) {
            CLILogger.error("Unexpected error: " + e.getMessage());
        }
    }
}
