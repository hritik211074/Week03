package Day03_Sorting;

import java.util.Arrays;

public class QuickSort {
    // Static method to implement the quick sort
    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(arr, low, high);  // Find the pivot index

            quickSort(arr, low, pivotIndex - 1);  // Apply sorting to the left array


            quickSort(arr, pivotIndex + 1, high);  // Apply sorting to the left array
        }
    }

    // Method to find pivot index
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];   // Initialize the pivot with last of array part
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);  //Method to swap the element

        return i + 1;  // Return the pivot index
    }

    // Method to swap the element of array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Here a main method
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
