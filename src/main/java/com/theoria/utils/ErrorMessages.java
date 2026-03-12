package com.theoria.utils;

public class ErrorMessages {

    public static String invalidPDFPath(String pdfFilePath){
        return "Invalid PDF file path: " + "[" + pdfFilePath + "]\n" +
                "Please check the file path and file name and try again.";
    }

    public static String minimumPDFMerge(){
        return "Need a minimum of 2 PDFs to merge.";
    }

    public static String invalidPDFIndex(){
        return "Invalid index: ";
    }

}
