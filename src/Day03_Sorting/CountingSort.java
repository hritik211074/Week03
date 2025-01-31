package Day03_Sorting;
import java.util.Arrays;

public class CountingSort {

    // Method to sort the array by using  counting sort
    public static void countingSort(int[] ages, int minAge, int maxAge) {

        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        //  Count occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in the correct positions
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted output back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] ages = {12, 15, 10, 18, 17, 10, 14, 16, 15, 12};

        System.out.println("Before Sorting: " + Arrays.toString(ages));

        countingSort(ages, 10, 18);

        System.out.println("After Sorting: " + Arrays.toString(ages));
    }
}
