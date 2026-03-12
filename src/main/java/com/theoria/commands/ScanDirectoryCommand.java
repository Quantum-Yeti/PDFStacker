package com.theoria.commands;

import com.theoria.core.StackerLogic;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class ScanDirectoryCommand implements Commands {

    @Override
    public String cmdName() {
        return "scanfd";
    }

    @Override
    public void execute(String input, StackerLogic stacker) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the folder path to scan its directory: ");
        String folderPath = scanner.nextLine().trim();

        List<File> pdfsFound = stacker.scanFolderDirectory(folderPath);

        if (pdfsFound.isEmpty()) {
            System.out.println("No PDFs found in the folder or its subfolders.");
            return;
        }

        System.out.println("Found " + pdfsFound.size() + " PDFs total.");

        for (File pdf : pdfsFound) {
            System.out.println(" - " + pdf.getAbsolutePath());
            System.out.print("Add this PDF to the merge stack? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("y") || response.equals("yes")) {
                try {
                    stacker.addPdfFile(pdf.getAbsolutePath());
                    System.out.println("Added: " + pdf.getName());
                } catch (Exception e) {
                    System.out.println("Failed to add: " + pdf.getName() + "\nReason: " + e.getMessage());
                }
            }

        }

    }

}
