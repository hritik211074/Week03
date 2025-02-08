package Day04_StringBuilder_String_Buffer_fileReader_InputStreamReader;

import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        // Define file name
        String fileName = "D:\\JavaFull Stack\\Project_Producer_consumer\\src\\Main.java";

        // Try-with-resources ensures automatic resource management

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Read each line until EOF
            while ((line = reader.readLine()) != null) {

                // Print the line to the console
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle file read errors
            System.err.println("Error: " + e.getMessage());

        }
    }
}

