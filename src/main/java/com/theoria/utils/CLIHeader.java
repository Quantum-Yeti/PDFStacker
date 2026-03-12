package com.theoria.utils;

public class CLIHeader {

    public static void printHeader() {
        System.out.println(CLIFontColors.PURPLE +
                "██████╗ ██████╗ ███████╗███████╗████████╗ █████╗  ██████╗██╗  ██╗███████╗██████╗ \n" +
                "██╔══██╗██╔══██╗██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔════╝██║ ██╔╝██╔════╝██╔══██╗\n" +
                "██████╔╝██║  ██║█████╗  ███████╗   ██║   ███████║██║     █████╔╝ █████╗  ██████╔╝\n" +
                "██╔═══╝ ██║  ██║██╔══╝  ╚════██║   ██║   ██╔══██║██║     ██╔═██╗ ██╔══╝  ██╔══██╗\n" +
                "██║     ██████╔╝██║     ███████║   ██║   ██║  ██║╚██████╗██║  ██╗███████╗██║  ██║\n" +
                "╚═╝     ╚═════╝ ╚═╝     ╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝\n" +
                CLIFontColors.RESET);

        int boxWidth = 60;
        String line = "═".repeat(boxWidth);

        System.out.println(CLIFontColors.CYAN + "╔" + line + "╗" + CLIFontColors.RESET);
        printCenteredLine("PDFSTACKER CLI", boxWidth, CLIFontColors.PURPLE);
        printCenteredLine("Author: Quantum Yeti | v1.0", boxWidth, CLIFontColors.CYAN);
        printCenteredLine("Utility for merging and sorting PDF files", boxWidth, CLIFontColors.YELLOW);
        System.out.println(CLIFontColors.CYAN + "╚" + line + "╝" + CLIFontColors.RESET);

        System.out.println(CLIFontColors.CYAN + "╔" + "═".repeat(60) + "╗" + CLIFontColors.RESET);
        System.out.println(CLIFontColors.PURPLE + "║ GET STARTED:" + " ".repeat(47) + "║" + CLIFontColors.RESET);
        System.out.println(CLIFontColors.CYAN + "║   1. Add PDF files:    add <filePath>" + " ".repeat(22) + "║" + CLIFontColors.RESET);
        System.out.println(CLIFontColors.CYAN + "║   2. List your files:  list" + " ".repeat(32) + "║" + CLIFontColors.RESET);
        System.out.println(CLIFontColors.CYAN + "║   3. Merge files:      merge <output.pdf>" + " ".repeat(18) + "║" + CLIFontColors.RESET);
        System.out.println(CLIFontColors.CYAN + "║   ** Type 'help' for all commands **" + " ".repeat(23) + "║" + CLIFontColors.RESET);
        System.out.println(CLIFontColors.CYAN + "╚" + "═".repeat(60) + "╝" + CLIFontColors.RESET);
    }

    public static void printCenteredLine(String text, int boxWidth, String color) {
        if (text.length() >= boxWidth) {
            // Just print the text if it’s too long
            System.out.println(color + "║" + text + "║" + CLIFontColors.RESET);
            return;
        }
        int paddingTotal = boxWidth - text.length();
        int paddingLeft = paddingTotal / 2;
        int paddingRight = paddingTotal - paddingLeft;

        System.out.println(color + "║"
                + " ".repeat(paddingLeft)
                + text
                + " ".repeat(paddingRight)
                + "║"
                + CLIFontColors.RESET);
    }

}
