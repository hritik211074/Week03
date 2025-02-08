package com.day06_runtime_analysis_bigonotation;


import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Implementing the bubble Sort
    public static void bubbleSort(int[] arr) {

        int n = arr.length;  // Finding the length of array
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Implementing the merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;   // Finding the mid

            mergeSort(arr, left, mid);  // Left side merge sort

            mergeSort(arr, mid + 1, right);  // Right side merge sort

            merge(arr, left, mid, right);  // It's a merge part
        }
    }
    // Implementing the merging part for merge sort
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];   // Take left side array
        int[] rightArr = new int[n2];  // Take right side array

        System.arraycopy(arr, left, leftArr, 0, n1);  // Copy the part of array in Left Arr

        System.arraycopy(arr, mid + 1, rightArr, 0, n2);  // Copy the part of array in right arr

        int i = 0, j = 0, k = left;

        // Merging the two sorted list
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // Implementing the quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);  // Finding the pivote here

            quickSort(arr, low, pi - 1);  // Apply quick sort for left part of array

            quickSort(arr, pi + 1, high);  // Apply quick sort for right part of array
        }
    }

    //method for quick sorting
    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        // Taking different dataset sizes
        int[] sizes = {1000, 10000, 1000000};

        Random rand = new Random();

        for (int size : sizes) {
            int[] dataset = new int[size];  // Creating the array size
            for (int i = 0; i < size; i++) {
                dataset[i] = rand.nextInt(size * 10); // Random values
            }

            // Copying arrays for genuine output
            int[] datasetBubble = Arrays.copyOf(dataset, dataset.length);

            int[] datasetMerge = Arrays.copyOf(dataset, dataset.length);

            int[] datasetQuick = Arrays.copyOf(dataset, dataset.length);

            System.out.println("Dataset Size: " + size);

            // Measuring Bubble Sort time
            if (size <= 10000) {
                long startTime = System.nanoTime();  // Starting time

                bubbleSort(datasetBubble);

                long endTime = System.nanoTime();  // Ending time

                System.out.println("Bubble Sort Time: " + (endTime - startTime) / 1e6 + " ms");
            } else {
                System.out.println("Bubble Sort Time: Unfeasible");
            }

            // Measuring Merge Sort time
            long startTime = System.nanoTime(); // Starting time

            mergeSort(datasetMerge, 0, datasetMerge.length - 1);

            long endTime = System.nanoTime();  // Ending time

            System.out.println("Merge Sort Time: " + (endTime - startTime) / 1e6 + " ms");

            // Measuring Quick Sort time
            startTime = System.nanoTime();  // Starting time

            quickSort(datasetQuick, 0, datasetQuick.length - 1);

            endTime = System.nanoTime();  // Ending time

            System.out.println("Quick Sort Time: " + (endTime - startTime) / 1e6 + " ms");

            System.out.println("-----------------------------------");
        }
    }
}