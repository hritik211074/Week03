package Day02_Stack_Queue_HashMap.Hash_map;

import java.util.*;

public class SubarraysWithZeroSum {

    public static void findZeroSumSubarrays(int[] arr) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        int sum = 0;

        // To store results
        List<int[]> result = new ArrayList<>();

        // Initialize map with sum 0 at index -1 (to handle cases where subarray starts from index 0)
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum is already seen, it means a subarray with zero sum exists
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(new int[]{start + 1, i});  // Store subarray indices
                }
            }

            // Add this sum to the map
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        // Print all found subarrays
        if (result.isEmpty()) {
            System.out.println("No subarrays with sum zero found.");
        } else {
            System.out.println("Zero-sum subarrays:");
            for (int[] subarray : result) {
                System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6, -3, -3, 1, 4};

        findZeroSumSubarrays(arr);
    }
}

