package Day05_Searching.BinarySearch;

public class FindRotationPoint {

    // Method to find the rotation point
    public static int findRotationPoint(int[] arr) {

        // Using the algorithms of binary search
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;   // Finding mid
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;  // Returning  the rotation point of given array
    }

    public static void main(String[] args) {

        // Store the sorted roated array in the array
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};

        // Calling method to store ratation point
        int rotationPoint = findRotationPoint(rotatedArray);

        System.out.println("The rotation point index is: " + rotationPoint);
    }
}

