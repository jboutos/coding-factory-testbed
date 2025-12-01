package gr.aueb.cf.cf9.ch9;

import java.io.*;
import java.util.Scanner;
import java.util.UUID;

public class CopyBinaryFileApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Get file name from user
            System.out.print("Enter the name of the file to copy (e.g., myFile.pdf): ");
            String userInputFile = scanner.nextLine().trim();

            // Step 2: Set input and output paths for macOS/Linux
            // Replace <your-username> with your macOS username
            String inFolder = "/Users/jboutos/tmp/";
            String inputPath = inFolder + userInputFile;

            // Step 3: Create unique output file name
            String outFolder = inFolder;
            String uniqueFileName = outFolder + UUID.randomUUID().toString().replace(":", "_") + "_" + userInputFile;

            // Step 4: Copy file using Buffered Streams
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputPath));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(uniqueFileName))) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                long totalBytes = 0;
                long start = System.currentTimeMillis();

                while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                    totalBytes += bytesRead;
                }

                bos.flush(); // ensure all bytes are written
                long end = System.currentTimeMillis();
                double elapsedTime = (end - start) / 1000.0;

                System.out.printf("Copied %d bytes in %.3f seconds\n", totalBytes, elapsedTime);
            }

            // Step 5: Display metadata
            File originalFile = new File(inputPath);
            File copiedFile = new File(uniqueFileName);

            System.out.println("Original file absolute path: " + originalFile.getAbsolutePath());
            System.out.println("Copied file absolute path: " + copiedFile.getAbsolutePath());

            // Extract extension (without the dot)
            String extension = "";
            int dotIndex = userInputFile.lastIndexOf('.');
            if (dotIndex > 0 && dotIndex < userInputFile.length() - 1) {
                extension = userInputFile.substring(dotIndex + 1);
            }
            System.out.println("File extension: " + extension);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
