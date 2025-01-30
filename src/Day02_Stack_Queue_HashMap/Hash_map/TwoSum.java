package Day02_Stack_Queue_HashMap.Hash_map;

import java.util.HashMap;

public class TwoSum {

    // Function to find two indices whose elements add up to the target

    public static int[] twoSum(int[] nums, int target) {

        // To store element values and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Find the complement

            // If complement exists in the map, return the indices
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            // Otherwise, store the current element and its index in the map
            map.put(nums[i], i);
        }

        // Return an empty array if no solution exists
        throw new IllegalArgumentException("No solution found");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Get the indices of the two elements that add up to the target
        int[] result = twoSum(nums, target);

        // Output the result
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}

