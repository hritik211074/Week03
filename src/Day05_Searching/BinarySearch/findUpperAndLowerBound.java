package Day05_Searching.BinarySearch;

import java.util.Scanner;

public class findUpperAndLowerBound {
    // Method that find upper bound of target
    static int findUpperBound(int [] arr,int n, int target){

        int left=0;
        int right=n-1;

        int upperBound=-1;   // Initialize the upper bound with -1
        while(left<right){
            int mid=(right-(right-left)/2);   // Finding the mid
            if(arr[mid]==target){    // Hit the actual target at arr[mid]
                upperBound=mid;
                left=mid+1;
            }
            else if(arr[mid]<target) left=mid+1;  // Checking in right part of array

            else right=mid-1;  // Checking in left part of array
        }
        return upperBound;
    }

    // Method that find lower bound of target
    static int findLowerBound(int [] arr,int n, int target){
        int left=0;
        int right=n-1;

        int lowerBound=-1;  // Initialize the upper bound with -1
        while(left<right) {

            int mid=(right-(right-left)/2);   // Finding the mid
            if(arr[mid]==target){  // Hit the actual target at arr[mid]
                lowerBound=mid;
                right=mid-1;
            }
            else if(arr[mid]<target) left=mid+1;   // Checking in right part of array

            else right=mid-1;  // Checking in left part of array
        }
        return lowerBound;
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
        // Taking target as a input
        int target=sc.nextInt();


        // Calling method to find uppper and lower bound of target in array
        int upperBound=findUpperBound(arr,n,target);
        int lowerBound=findLowerBound(arr,n,target);

        if(upperBound==-1 || lowerBound==-1){
            System.out.println("Target not found");
        }else {
            System.out.println("Lower bound of the array is: " + lowerBound);

            System.out.println("Upper bound of the array is: " + upperBound);

        }

    }
}
