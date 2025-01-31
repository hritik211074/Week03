package Day03_Sorting;

import java.util.Arrays;

// Method for sorting
public class Insertion_Sort {
    static void insertionSort(int [] array){

        int len=array.length;  // Length of array

        // Traverse from 1 to len-1
        for(int i=1;i<len;i++){
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are
            // greater than key, to one position ahead
            // of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        // Here are the employeeId  of employee which are stored in array
        int []array={201,50,12,44,33,9,7,699,4};

        // Getting the employeeId of employee by calling insertionSort method
        insertionSort(array);

        System.out.println(Arrays.toString(array));
    }
}
