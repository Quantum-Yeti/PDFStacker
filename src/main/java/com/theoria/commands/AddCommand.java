package com.theoria.commands;

import com.theoria.core.StackerLogic;

import java.io.File;

public class AddCommand implements Commands {

    @Override
    public String cmdName() {
        return "add";
    }

    @Override
    public void execute(String input, StackerLogic stacker) throws Exception {

        String[] parse = input.trim().split("\\s+");

        if (parse.length < 2) {
            System.out.println("Use: add <pdfFilePath>");
            return;
        }

        String pdfFilePath = parse[1];
        stacker.addPdfFile(pdfFilePath);

        String fileName = new File(pdfFilePath).getName();
        System.out.println("PDF added to merge stack: " + fileName);
    }

}
