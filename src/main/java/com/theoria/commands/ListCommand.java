package com.theoria.commands;

import com.theoria.core.StackerLogic;

import java.util.List;

public class ListCommand implements Commands {

    @Override
    public String cmdName() {
        return "list";
    }

    @Override
    public void execute(String input, StackerLogic stacker) throws Exception {

        List<String> listPDFs = stacker.listPdfFiles();

        if (listPDFs.isEmpty()) {
            System.out.println("There are no pdf files in the stack.");
            return;
        }

        for (int i = 0; i < listPDFs.size(); i++) {
            System.out.println((i + 1) + ". " + listPDFs.get(i));

        }
        System.out.println("The PDF stack contains " + listPDFs.size() + " files.");

    }

}
