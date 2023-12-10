package week9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static String readContentFromFile(String path) throws IOException {
        Path filePath = Paths.get(path);
        List<String> file = Files.readAllLines(filePath);
        StringBuilder result = new StringBuilder();
        for (String i : file) {
            result.append(i);
        }
        return result.toString();
    }

    public static void writeContentToFile(String path) throws IOException {
        Path filePath = Paths.get(path);
        try (FileWriter fileWriter = new FileWriter(filePath.toFile(), false)) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            fileWriter.write(s);
        }
    }

    public static void writeContentToLastFile(String path) throws IOException {
        Path filePath = Paths.get(path);
        try (FileWriter printWriter = new FileWriter(filePath.toFile(), true)) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            printWriter.append(s);
        }
    }

    public static File findFileByName(String folderPath, String fileName) {
        Path folder = Paths.get(folderPath);
        File checkFolder = folder.toFile();
        File[] files = checkFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    return file;
                }
            }
        }
        return null;
    }

}
