package com.xuzhongjian.rxjava.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author zjxu97 at 12/18/20 4:15 PM
 */
public class FileUtil {

    public static Scanner getFileAsScanner(String path) {
        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(String.format("file not found, file: %s", path));
        }
        return scanner;
    }

    public static String getFileAsString(String path) {
        Scanner scanner = FileUtil.getFileAsScanner(path);
        StringBuilder resultBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String thisLine = scanner.nextLine();
            resultBuilder.append(thisLine);
        }
        return resultBuilder.toString();
    }
}
