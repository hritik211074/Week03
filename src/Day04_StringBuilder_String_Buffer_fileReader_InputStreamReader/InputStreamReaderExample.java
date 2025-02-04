package Day04_StringBuilder_String_Buffer_fileReader_InputStreamReader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderExample {
    public static void main(String[] args) {

        // Define file name
        String fileName = "D:\\JavaFull Stack\\Project_Producer_consumer\\src\\Main.java";

        // Try-with-resources ensures automatic resource management
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) { // Read each line until EOF

                System.out.println(line); // Print the line
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage()); // Handle file read errors
        }
    }
}

