package Day03_Sorting;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Building the  Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move the root (max element) to the end
            swap(salaries, 0, i);

            // Heapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Method to heapify
    private static void heapify(int[] arr, int n, int i) {

        int largest = i; // Root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // Check if left child is larger
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child is larger
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the largest is not the root, swap and continue heapifying
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] salaries = {500, 70, 40, 900, 650, 800};

        System.out.println("Before Sorting: " + Arrays.toString(salaries));

        heapSort(salaries);

        System.out.println("After Sorting (Ascending Order): " + Arrays.toString(salaries));
    }
}
