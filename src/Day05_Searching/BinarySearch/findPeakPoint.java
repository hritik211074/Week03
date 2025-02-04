package Day05_Searching.BinarySearch;

import java.util.Scanner;

public class findPeakPoint {
    static int findpeakPoint(int [] arr,int n){
        // Initialize the  start and end pointer
        int st=0,end=n-1;

        // Perform binary search operation
        while(st<end){
            int mid=(end-(end-st)/2);   // Finding mid here

            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return arr[mid];  // Peak condition


            else if(arr[mid]<arr[mid-1]) end=mid-1;  // finding the left part of array
            else st =mid+1;  // Finding the right part of array
        }
        return -1;
    }
    public static void main(String[] args) {
        // Making the scanner object to read user input
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of value ");
        int n=sc.nextInt();  // N element

        // Store n element in array
        int [] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();  // Read the user input
        }
        // Call method to find the peak point of the array
        int peakElement=findpeakPoint(arr,n);

        if(peakElement==-1) System.out.println("Rotated point cannot be finded");

        else System.out.println("Peak point of array is: "+peakElement);
    }
}
