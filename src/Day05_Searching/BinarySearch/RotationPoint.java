package Day05_Searching.BinarySearch;

import java.util.Scanner;

public class RotationPoint {
    static int findRotatedPoint(int arr[],int n){
        // Here counting how many number is greater than it's  next element
        int count=0;
        int rotatedPoint=-1;   // Initialized by -1
        for(int i=0;i<n;i++){
            if(arr[i]>arr[(i+1)%n]) {
                count++;
                rotatedPoint=arr[i];
            }
        }
        // Checking if count is leass than equal to one then it is possible that there is rotated point
        if(count==1) return rotatedPoint;
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

        // Calling method to find the rotated point of the array
        int rotatedPoint=findRotatedPoint(arr,n);

        if(rotatedPoint==-1){
            System.out.println("There is no any rotation point in this array");
        }else{
            System.out.println("Rotation point is: "+rotatedPoint);
        }

    }
}
