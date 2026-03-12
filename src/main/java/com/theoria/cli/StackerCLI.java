package com.theoria.cli;

import com.theoria.core.StackerLogic;
import com.theoria.utils.CLIFontColors;
import com.theoria.utils.CLIHeader;

import java.util.Scanner;

public class StackerCLI {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        StackerLogic stacker = new StackerLogic();
        CLIHeader.printHeader();
        mainLoop(stacker, scanner);
    }

    private static void mainLoop(StackerLogic stacker, Scanner scanner) {
        CommandRouter router = new CommandRouter();

        try {
            do {
                System.out.print(CLIFontColors.CYAN + ">> " + CLIFontColors.RESET);
                String userInput = scanner.nextLine().trim();
                if (userInput.isEmpty()) continue;

                try {
                    router.route(userInput, stacker);
                } catch (Exception e) {
                    System.out.println(CLIFontColors.RED + e.getMessage() + CLIFontColors.RESET);
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(CLIFontColors.RED + e.getMessage() + CLIFontColors.RESET);
        } finally {
            scanner.close();
        }

    }

}
