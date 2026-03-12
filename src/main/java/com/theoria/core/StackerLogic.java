package com.theoria.core;

import com.theoria.utils.ErrorMessages;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StackerLogic {

    // Private list storing PDF file paths
    private final ArrayList<String> pdfFiles;

    // Constructor initializing the list
    public StackerLogic() {
        pdfFiles = new ArrayList<>();
    }

    public void addPdfFile(String pdfFilePath) {
        File file = new File(pdfFilePath);

        if (file.exists() && file.getName().toLowerCase().endsWith(".pdf")) {
            pdfFiles.add(pdfFilePath);
        } else {
            throw new IllegalArgumentException(ErrorMessages.invalidPDFPath(pdfFilePath)
            );
        }
    }

    public void removePdfFile(int index) throws Exception {
        if (index < 1 || index > pdfFiles.size()) {
            throw new Exception(ErrorMessages.invalidPDFIndex() + index);
        }
        pdfFiles.remove(index - 1);
    }

    public List<String> listPdfFiles() {
        return new ArrayList<>(pdfFiles);
    }

    public void mergePdfFile(String outputFileName) throws Exception {
        if (pdfFiles.size() < 2) {
            throw new IllegalArgumentException(ErrorMessages.minimumPDFMerge());
        }

        Scanner scanner = new Scanner(System.in);

        // Ask user for directory
        System.out.print("Enter the directory to save the merged PDF: ");
        String dirPath = scanner.nextLine().trim();

        // Use default if user presses Enter
        if (dirPath.isEmpty()) {
            dirPath = "PDFStacker" + File.separator + "Merged";
        }

        File mergedDir = new File(dirPath);

        // Create directory if it doesn't exist
        if (!mergedDir.exists()) {
            boolean success = mergedDir.mkdirs();
            if (!success) {
                throw new Exception("Failed to create directory: " + mergedDir.getAbsolutePath());
            }
        }

        // Ensure output file has .pdf extension
        if (!outputFileName.toLowerCase().endsWith(".pdf")) {
            outputFileName += ".pdf";
        }

        String fullOutputPath = mergedDir + File.separator + outputFileName;

        // Merge PDFs
        PDFMergerUtility merger = new PDFMergerUtility();
        for (String pdfFilePath : pdfFiles) {
            merger.addSource(new File(pdfFilePath));
        }
        merger.setDestinationFileName(fullOutputPath);
        merger.mergeDocuments(null); // default MemoryUsageSetting

        System.out.println("Merged PDF saved to: " + fullOutputPath);
    }

    public enum MoveDirection { UP, DOWN, NONE }

    public MoveDirection movePDF(int currentIndex, int newIndex) throws Exception {
        if (currentIndex < 1 || currentIndex > pdfFiles.size()) {
            throw new Exception(ErrorMessages.invalidPDFIndex() + currentIndex);
        }
        if (newIndex < 1 || newIndex > pdfFiles.size()) {
            throw new Exception(ErrorMessages.invalidPDFIndex() + newIndex);
        }
        if (currentIndex == newIndex) return MoveDirection.NONE;

        int oldIdx = currentIndex - 1;
        int newIdx = newIndex - 1;

        String pdf = pdfFiles.remove(oldIdx);

        // Insert at target index
        pdfFiles.add(newIdx, pdf);

        return oldIdx < newIdx ? MoveDirection.DOWN : MoveDirection.UP;
    }

    public void scanFolder() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the folder path to scan for PDFs: ");
        String folderPath = scanner.nextLine().trim();

        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Folder does not exist or is not a directory.");
            return;
        }

        File[] listOfFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

        if (listOfFiles == null || listOfFiles.length == 0) {
            System.out.println("No pdfs found in the folder.");
            return;
        }

        System.out.println("Found " + listOfFiles.length + " PDFs in the folder.");

        for (File pdf : listOfFiles) {
            System.out.println(" - " + pdf.getName());

            System.out.println("Add this PDF to the merge stack? (y/n): ");
            String response  = scanner.nextLine().trim();
            if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
                try {
                    addPdfFile(pdf.getAbsolutePath());
                    System.out.println("Added: " + pdf.getName());
                } catch (Exception e) {
                    System.out.println("Failed to add: " + pdf.getName());
                }
            }
        }
    }

    public List<File> scanFolderDirectory(String folderPath) {
        List<File> pdfFilesFound = new ArrayList<>();
        File rootFolder = new File(folderPath);

        if (!rootFolder.exists() || !rootFolder.isDirectory()) {
            System.out.println("Folder does not exist or is not a directory.");
            return pdfFilesFound;
        }

        File[] filesInDir = rootFolder.listFiles();
        if (filesInDir == null) {
            return pdfFilesFound;
        }

        for (File file : filesInDir) {
            if (file.isDirectory()) {
                pdfFilesFound.addAll(scanFolderDirectory(file.getAbsolutePath()));
            } else if (file.getName().toLowerCase().endsWith(".pdf")) {
                pdfFilesFound.add(file);
            }
        }
        return pdfFilesFound;
    }

    public void startNew() {
        pdfFiles.clear();
        System.out.println("PDF stack has been reset. You may start over.");
    }
}
