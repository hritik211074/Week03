package Day04_StringBuilder_String_Buffer_fileReader_InputStreamReader;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {

        // Define output file name
        String fileName = "D:\\JavaFull Stack\\Project_Producer_consumer\\src\\Main.java";

        // Try-with-resources to ensure automatic resource management
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            // Read user input
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line); // Write input to file
                writer.newLine(); // Move to next line
            }
            System.out.println("User input saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage()); // Handle input/output errors
        }
    }
}

