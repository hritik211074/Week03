package Day03_Sorting;

import java.util.Arrays;

public class MergeSort {

    // To divide the array
    static void mergeSort(int []array,int left,int right){
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);  // Make a recursive call
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);   // Merging the array
        }

    }

    // Merging the array
    static void merge(int []array,int left,int mid,int right){

        int n1=mid-left+1;   // First array size
        int n2=right-mid;  // Second array size

        int []arr1=new int[n1];
        int []arr2=new int[n2];

        // Copy the left part of array in arr1
        System.arraycopy(array,left,arr1,0,n1);

        // Copy the right part of array in arr2
        System.arraycopy(array,mid+1,arr2,0,n2);

        int k=left;
        int i=0,j=0;
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]){
                array[k++]=arr1[i++];
            }else{
                array[k++]=arr2[j++];
            }
        }
        while(i<n1){
            array[k++]=arr1[i++];
        }
        while(j<n2){
            array[k++]=arr2[j++];
        }
    }

    public static void main(String[] args) {
        // Here a book price which are stored in array
        int []array={201,50,12,44,33,9,7,699,4};

        // Getting the sorted marks of students by calling insertionSort method
        mergeSort(array,0,array.length-1);

        System.out.println(Arrays.toString(array));
    }
}
