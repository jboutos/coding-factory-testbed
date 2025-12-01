package gr.aueb.cf.cf9.ch9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class LocationsApp {
    public static void main(String[] args) {
        File file = new File("/tmp/locations.txt");
        File outFilePath = new File("tmp/locations-new.txt");
        String[][] geoData;

        try {
            geoData = getGeoData(file);
            writeGeoData(outFilePath, geoData);
            System.out.println("File created successfully: " + outFilePath.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    public static String[][] getGeoData(File file) throws FileNotFoundException {
        String line;
        String[] parts;
        int count = -1;
        String[][] returnedArray = new String[1000][3];

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                count++;
                line = scanner.nextLine();
                parts = line.split(",");

                returnedArray[count] = parts;
            }
            return Arrays.copyOf(returnedArray, count + 1) ;
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public static void writeGeoData(File outFile, String[][] geoData) {
        try (PrintStream ps = new PrintStream(outFile)) {

            for (String[] row : geoData) {
                ps.printf("{ location: '%s', latitude: %s, longitude: %s },%n",
                        row[0], row[1], row[2]);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Cannot write file: " + e.getMessage());
        }
    }
}
