package com.day06_runtime_analysis_bigonotation;

import java.util.Random;

public class StringConcatenationPerformance
{
    // Main method
    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 1000000};  // Different size of dataset
        Random random = new Random();  // Making the random

        for (int size : sizes) {
            String text = "hello";

            // Measure and compare time taken by StringBuffer
            long startTime = System.nanoTime();

            // Create StringBuffer to store a string
            StringBuffer sbf = new StringBuffer();

            for (int i = 0; i < size; i++) sbf.append(text);

            long stringBufferTime = System.nanoTime() - startTime;  // Time Taken by StringBuffer

            // Measure and compare time taken by StringBuilder
            startTime = System.nanoTime();

            // Creating the StringBuilder to store a string
            StringBuilder sbd = new StringBuilder();

            for (int i = 0; i < size; i++) sbd.append(text);

            long stringBuilderTime = System.nanoTime() - startTime;  // Time Taken by string Builder

            // Create a string to store string

            String st=new String();
            // Measure and compare time taken by StringBuilder
            startTime = System.nanoTime();

            for (int i = 0; i < size; i++) st.concat(text);

            long stringTime = System.nanoTime() - startTime;  // Time Taken by String

            System.out.println("StringBuffer: " + stringBufferTime + " ns");

            System.out.println("StringBuilder: " + stringBuilderTime + " ns");

            System.out.println("String: " + stringTime + " ns");

        }

    }
}