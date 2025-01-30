package Day02_Stack_Queue_HashMap.Hash_map;

import java.util.*;

public class PairWithTargetSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> present = new HashSet<>();

        /// Traverse the array
        for (int num : arr) {
            int remain = target - num;

            // If complement exists, return true
            if (present.contains(remain)) {
                System.out.println("Pair found: (" + remain + ", " + num + ")");
                return true;
            }

            // Store the current number
            present.add(num);
        }

        System.out.println("No pair found.");
        return false;
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        // Method to find the whether element present in array or not
        hasPairWithSum(arr, target);
    }
}

