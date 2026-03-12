package com.theoria.commands;

import com.theoria.utils.CLIFontColors;
import com.theoria.core.StackerLogic;

public class HelpCommand implements Commands {

    @Override
    public String cmdName() {
        return "help";
    }

    @Override
    public void execute(String name, StackerLogic stacker) throws Exception {

        System.out.println(CLIFontColors.CYAN + "================ PDFStacker CLI - All Merge & Sort Commands =================" + CLIFontColors.RESET);
        System.out.println(CLIFontColors.YELLOW + "Available Commands:" + CLIFontColors.RESET);
        System.out.println(CLIFontColors.GREEN + "  add    <path>        " + CLIFontColors.RESET + "                 - Add a PDF file to the stack");
        System.out.println(CLIFontColors.GREEN + "  list              " + CLIFontColors.RESET + "                    - Show current PDFs in the stack");
        System.out.println(CLIFontColors.GREEN + "  remove <number>   " + CLIFontColors.RESET + "                    - Remove PDF at given position");
        System.out.println(CLIFontColors.GREEN + "  move   <currentIndex> -> <newIndex> " + CLIFontColors.RESET + "  - Move PDF up in the stack");
        System.out.println(CLIFontColors.GREEN + "  merge  <output.pdf>" + CLIFontColors.RESET + "                   - Merge all PDFs into one file");
        System.out.println(CLIFontColors.GREEN + "  exit              " + CLIFontColors.RESET + "                    - Exit the application");
        System.out.println(CLIFontColors.CYAN + "=============================================================================" + CLIFontColors.RESET);

    }

}
