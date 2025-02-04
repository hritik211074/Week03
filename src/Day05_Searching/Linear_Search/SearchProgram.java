package Day05_Searching.Linear_Search;

import java.util.Arrays;

public class SearchProgram {

    // Function to find the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {

        int n = nums.length;  // Finding the length of arrays

        // Sort the array first
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        // Find the missing in below code
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    // Function to perform binary search on a sorted array
    public static int binarySearch(int[] nums, int target) {

        // Implementing the binary search algorithms
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Finding the mid
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;  // Finding in right part of array
            } else {
                right = mid - 1;  // Finding in left part of array
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 3;

        // Find the first missing positive integer
        int firstMissingPositive = findFirstMissingPositive(nums);

        System.out.println("The first missing positive integer is: " + firstMissingPositive);

        // Array is already sorted in above line
        int indexOfTarget = binarySearch(nums, target);
        System.out.println("The index of the target " + target + " is: " + indexOfTarget);
    }
}
