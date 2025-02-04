package Day04_StringBuilder_String_Buffer_fileReader_InputStreamReader;

import java.io.*;

public class CompareStringAndFileReaders {

    public static void main(String[] args) {
        // Compare StringBuilder and StringBuffer
        compareStringBuilders();

        // Compare FileReader and InputStreamReader
        compareFileReaders("D:\\JavaFull Stack\\Project_Producer_consumer\\src\\Main.java");
    }

    // Method to compare StringBuilder and StringBuffer
    private static void compareStringBuilders() {
        final int iterations = 1_000_000;
        String text = "hello";

        long start = System.nanoTime();  // Starting of time

        StringBuilder sb = new StringBuilder();  // Declaring the StringBuilder

        for (int i = 0; i < iterations; i++) sb.append(text); // Appending the string into StringBuilder

        long stringBuilderTime = System.nanoTime() - start;  // Finding the time taken

        start = System.nanoTime();  // Starting time

        StringBuffer sbf = new StringBuffer();  // Declaring the StringBuilder

        for (int i = 0; i < iterations; i++) sbf.append(text);  // Appending the string into StringBuffer
        long stringBufferTime = System.nanoTime() - start;

        System.out.println("StringBuilder time: " + stringBuilderTime / 1e6 + " ms");

        System.out.println("StringBuffer time: " + stringBufferTime / 1e6 + " ms");
    }

    // Method to compare FileReader and InputStreamReader

    private static void compareFileReaders(String fileName) {

        long start, fileReaderTime, inputStreamReaderTime;
        int wordCount = 0;

        // Using FileReader
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            start = System.nanoTime();
            String line;
            while ((line = reader.readLine()) != null) wordCount += line.split("\\s+").length;
            fileReaderTime = System.nanoTime() - start;
        } catch (IOException e) {
            System.err.println("FileReader error: " + e.getMessage());  // Handling the exception here and getting the message
            return;
        }

        wordCount = 0; // Reset word count

        // Using InputStreamReader
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            start = System.nanoTime();
            String line;
            while ((line = reader.readLine()) != null) wordCount += line.split("\\s+").length;
            inputStreamReaderTime = System.nanoTime() - start;
        } catch (IOException e) {
            System.err.println("InputStreamReader error: " + e.getMessage());
            return;
        }

        System.out.println("Word Count: " + wordCount);
        System.out.println("FileReader time: " + fileReaderTime / 1e6 + " ms");
        System.out.println("InputStreamReader time: " + inputStreamReaderTime / 1e6 + " ms");
    }
}
