import java.io.*;

public class Utils {
    public static String readContentFromFile(String path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void writeContentToFile(String path, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendContentToFile(String path, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    return file;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String filePath = "E:\\Data\\Kì 1 năm 2\\OOP\\Code\\Java_code\\Input_Output\\src\\";
        String fileContent = readContentFromFile(filePath + "input.txt");
        System.out.println("File content: " + fileContent);

        String contentToWrite = "Reset.";
        writeContentToFile(filePath + "output.txt", contentToWrite);
        System.out.println("Success.");

        String additionalContent = "Addition.";
        appendContentToFile(filePath + "output.txt", additionalContent);
        System.out.println("Success.");


        File foundFile = findFileByName(filePath, "input.txt");
        if (foundFile != null) {
            System.out.println("File found: " + foundFile.getAbsolutePath());
        } else {
            System.out.println("File not found.");
        }
    }
}