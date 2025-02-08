package com.day06_runtime_analysis_bigonotation;

import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Implementing the Linear Search
    public static boolean linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    // Implementing the binary Search
    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;   // Finding the mid
            if (arr[mid] == target) {
                return true;  // Meet the target
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;  // Target not found
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 1000000};  // Different size of dataset
        Random random = new Random();  // Making the random

        for (int size : sizes) {
            int[] data = new int[size];  // Making the array of  size N

            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size);  // Storing random values
            }
            int target = random.nextInt(size);  // Finding the target

            // Linear Search
            long startTime = System.nanoTime(); // Starting when linear search start

            boolean flag1=linearSearch(data, target);

            if(flag1)  System.out.println("Target get found in nums using linear search");

            long endTime = System.nanoTime(); // Ending when linear search start

            // Finding the time taken by linear serach
            long linearSearchTime = endTime - startTime;

            // Binary Search (requires a sorted array)
            Arrays.sort(data);  // Sorting the data

            startTime = System.nanoTime();  // Starting when binary search start

            boolean flag2=binarySearch(data, target);
            endTime = System.nanoTime();  // Ending when binary search start
            if(flag2)  System.out.println("Target get found in nums using binary search");

            // Finding the time taken by binarySearch
            long binarySearchTime = endTime - startTime;

            System.out.println("Dataset Size: " + size);

            System.out.println("Linear Search Time: " + linearSearchTime + " ns");

            System.out.println("Binary Search Time: " + binarySearchTime + " ns");

            System.out.println("_________________________________________________________________________");
        }
    }
}

