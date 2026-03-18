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

        System.out.println(CLIFontColors.CYAN + "================ PDFStacker CLI - All Merge & Sort Commands =================================================" + CLIFontColors.RESET);
        System.out.println(CLIFontColors.YELLOW + "Available Commands:" + CLIFontColors.RESET);
        System.out.println(CLIFontColors.GREEN + "  add           <path>        " + CLIFontColors.RESET + "                   - Add a PDF file to the list");
        System.out.println(CLIFontColors.GREEN + "  list              " + CLIFontColors.RESET + "                             - Show current PDFs in the list");
        System.out.println(CLIFontColors.GREEN + "  startOver             " + CLIFontColors.RESET + "                         - Remove everything and start over");
        System.out.println(CLIFontColors.GREEN + "  remove        <indexNumber>   " + CLIFontColors.RESET + "                 - Remove PDF at given position");
        System.out.println(CLIFontColors.GREEN + "  move          <currentIndex> -> <newIndex> " + CLIFontColors.RESET + "    - Move PDF up in the list");
        System.out.println(CLIFontColors.GREEN + "  merge         <output.pdf>" + CLIFontColors.RESET + "                     - Merge all PDFs into one file");
        System.out.println(CLIFontColors.GREEN + "  scanf             " + CLIFontColors.RESET + "                             - Scan a folder for PDFs");
        System.out.println(CLIFontColors.GREEN + "  scanfd             " + CLIFontColors.RESET + "                            - Scan a folder and its subdirectories for all PDFs");
        System.out.println(CLIFontColors.GREEN + "  donate             " + CLIFontColors.RESET + "                            - Donate to support development");
        System.out.println(CLIFontColors.GREEN + "  exit              " + CLIFontColors.RESET + "                             - Exit the application");
        System.out.println(CLIFontColors.CYAN + "=============================================================================================================" + CLIFontColors.RESET);

    }

}
