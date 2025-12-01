package gr.aueb.cf.cf9.ch9;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.UUID;

public class Revisions2App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // predefined folder
        Path folder = Path.of("/tmp/");

        // ask user for filename
        System.out.print("Enter the name of the file to copy (with extension): ");
        String filename = scanner.nextLine().trim();

        Path source = folder.resolve(filename);

        // generate unique file name for copy
        String uniqueName = UUID.randomUUID().toString().replace(":", "_") + "-" + filename;
        Path targetFile = folder.resolve(uniqueName);

        try {
            binaryReadWrite(source, targetFile);

            // display metadata
            System.out.println("File copied successfully!");
            System.out.println("Original file absolute path: " + source.toAbsolutePath());
            System.out.println("Copied file absolute path:   " + targetFile.toAbsolutePath());
            System.out.println("File extension: " + getFileExtension(source));

        } catch (IOException e) {
            System.out.println("Κάποιο λάθος συνέβη.");
            e.printStackTrace();
        }

        scanner.close();
    }

    public static void binaryReadWrite(Path source, Path target) throws IOException {
        try (var sourceStream = Files.newInputStream(source);
             var targetStream = Files.newOutputStream(target)) {
            sourceStream.transferTo(targetStream);  // efficient, streams chunks
        }
    }

    public static String getFileExtension(Path path) {
        String name = path.getFileName().toString();
        int dotIndex = name.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == name.length() - 1) {
            return ""; // no extension found
        }
        return name.substring(dotIndex + 1);
    }
}
