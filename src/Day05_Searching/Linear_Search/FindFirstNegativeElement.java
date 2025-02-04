package Day05_Searching.Linear_Search;

import java.util.Scanner;

public class FindFirstNegativeElement {

    // Static method to find the first negative element
    static int findNegative(int [] arr,int n){

        // Traversing the array and find the negative element
        for(int i=0;i<n;i++){
            if(arr[i]<0) return i;
        }
        return -1;  // If not found
    }
    public static void main(String[] args) {

         // Making the scanner object to read user input
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of value");
        int n=sc.nextInt();  // N element

        // // Make the array to store n element
        int [] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        // Calling the method to find the index of first negative element
        int index=findNegative(arr,n);

        if(index!=-1){
            System.out.println("First negative element at: "+index);
        }else{
            System.out.println("No negative element found");
        }
    }
}
