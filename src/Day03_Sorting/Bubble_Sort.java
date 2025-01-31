package Day03_Sorting;

import java.util.Arrays;

// Method for sorting
public class Bubble_Sort {
    static void bubbleSort(int [] array){

        int len=array.length;  // Length of array

        /// Traverse array (n-1) times
        for(int i=0;i<len-1;i++){

            for(int j=0;j<len-i-1;j++){
                // Checking adjacent element
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {

        // Here a marks of student which are store in array
        int []array={2,5,1,4,3,9,7,6,4};

        // Getting the sorted marks of student by calling bubbleSort method
        bubbleSort(array);

        System.out.println(Arrays.toString(array));
    }
}
