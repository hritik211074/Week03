package Day03_Sorting;

import java.util.Arrays;

//Here a main class selection sort
public class Selection_sort {

    // Here a static  method to implement selection sort
    static void selectionSort(int [] arrays){
        int len=arrays.length;   // Finding thr length of array

        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(arrays[i]>arrays[j]){
                    // swapping the elements
                    int temp=arrays[i];
                    arrays[i]=arrays[j];
                    arrays[j]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        // Here are the score  of student which are stored in array
        int []array={201,50,12,44,33,9,7,699,4};

        // Getting the sorted marks of students by calling insertionSort method
        selectionSort(array);

        System.out.println(Arrays.toString(array));
    }
}
