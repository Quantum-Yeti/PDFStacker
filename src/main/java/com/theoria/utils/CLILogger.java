package com.theoria.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CLILogger {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String LOG_FILE = "PDFStacker.log";

    // Info messages
    public static void info(String message) {
        String text = String.format("[%s] \u001B[36mINFO\u001B[0m: %s", dtf.format(LocalDateTime.now()), message);
        System.out.println(text);
        writeToFile(text);
    }

    // Success messages
    public static void success(String message) {
        String text = String.format("[%s] \u001B[32m✔\u001B[0m %s", dtf.format(LocalDateTime.now()), message);
        System.out.println(text);
        writeToFile(text);
    }

    // Warnings
    public static void warn(String message) {
        String text = String.format("[%s] \u001B[33m⚠\u001B[0m %s", dtf.format(LocalDateTime.now()), message);
        System.out.println(text);
        writeToFile(text);
    }

    // Errors
    public static void error(String message) {
        String text = String.format("[%s] \u001B[31m✖\u001B[0m %s", dtf.format(LocalDateTime.now()), message);
        System.err.println(text);
        writeToFile(text);
    }

    private static void writeToFile(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write(message + "\n");
        } catch (IOException e) {
            System.err.println("\u001B[31mFailed to write to log file\u001B[0m: " + e.getMessage());
        }
    }
}
