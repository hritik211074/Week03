package Day04_StringBuilder_String_Buffer_fileReader_InputStreamReader;

public class StringBufferVsStringBuilder {
    // Main method
    public static void main(String[] args) {

        final int ITERATIONS = 1_000_000;
        String text = "hello";

        // Measure and compare time taken by StringBuffer
        long startTime = System.nanoTime();

        // Create StringBuffer to store a string
        StringBuffer sbf = new StringBuffer();

        for (int i = 0; i < ITERATIONS; i++) sbf.append(text);

        long stringBufferTime = System.nanoTime() - startTime;

        // Measure and compare time taken by StringBuilder
        startTime = System.nanoTime();

        // Creating the StringBuilder to store a string
        StringBuilder sbd = new StringBuilder();

        for (int i = 0; i < ITERATIONS; i++) sbd.append(text);

        long stringBuilderTime = System.nanoTime() - startTime;

        System.out.println("StringBuffer: " + stringBufferTime + " ns");

        System.out.println("StringBuilder: " + stringBuilderTime + " ns");

        System.out.println((stringBufferTime > stringBuilderTime) ? "StringBuilder is faster by " + (stringBufferTime - stringBuilderTime) + " ns" : "StringBuffer is faster by " + (stringBuilderTime - stringBufferTime) + " ns");
    }
}
