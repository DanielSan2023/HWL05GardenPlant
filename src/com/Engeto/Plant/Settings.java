package com.Engeto.Plant;

public class Settings {
    private static final String fileItemDelimiterValue = "\t";

    private static final String fileLoadNameValue = "Kvetiny.txt";
    private static final String fileSaveNameValue = "NewKvetiny.txt";

    public static String fileItemDelimiter() {
        return fileItemDelimiterValue;
    }

    public static String fileNameforLoad() {
        return fileLoadNameValue;
    }
    public static String fileNameforSave() {
        return fileSaveNameValue;
    }

}
