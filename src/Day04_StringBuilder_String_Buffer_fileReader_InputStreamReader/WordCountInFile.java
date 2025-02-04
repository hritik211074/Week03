package Day04_StringBuilder_String_Buffer_fileReader_InputStreamReader;

import java.io.*;

public class WordCountInFile {
    // Main method
    public static void main(String[] args) {

        // Define file name
        String fileName = "D:\\JavaFull Stack\\Project_Producer_consumer\\src\\Main.java";

        // Word to count
        String targetWord = "hello";
        int count = 0; // Counter to count the number of occurrence of targetWord

        // Try-with-resources ensures automatic resource management
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = reader.readLine()) != null) { // Read each line until EOF

                // Split line into words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) count++; // Case-insensitive match
                }
            }
            System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
        }   catch (IOException e) {
            System.err.println("Error: " + e.getMessage()); // Handle file read errors
        }
    }
}
