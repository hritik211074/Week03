package Day02_Stack_Queue_HashMap.Hash_map;

import java.util.*;


public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();

        // Length of maximum consecutive number
        int maxLength = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {

                int left = map.getOrDefault(num - 1, 0);

                int right = map.getOrDefault(num + 1, 0);

                int currentLength = left + right + 1;

                // Store the sequence length for this number
                map.put(num, currentLength);

                // Update the boundary values
                 map.put(num - left, currentLength); // Leftmost boundary

                map.put(num + right, currentLength);  // Rightmost boundary

                // Update max length found so far

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
    // Main method here
    public static void main(String[] args) {

        // Array
        int[] arr = {100, 4, 200, 1, 3, 2, 5, 101};

        // Displaying the answer
        System.out.println("Longest consecutive sequence length: " + longestConsecutive(arr));
    }
}


