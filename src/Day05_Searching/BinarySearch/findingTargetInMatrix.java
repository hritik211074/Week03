package Day05_Searching.BinarySearch;

import java.util.Scanner;

public class findingTargetInMatrix {
    // Method to find that element exist or not
    static boolean searchMatrix(int [][] matrix, int row,int col ,int target) {

        int low=0;   // Left pointer
        int high=row*col-1;  // Last pointer

        // Using the algorithms of bninary search
        while(low<=high){
            int mid=low+(high-low)/2;  // Finding the mid

            if(matrix[mid/col][mid%col]==target){
                return true;
            }

            else if(matrix[mid/col][mid%col]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // Making the scanner object to read user input
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of row ");
        int row=sc.nextInt();  // N element

        System.out.println("Enter the number of col ");
        int col=sc.nextInt();  // M element

        // Making the matrix
        int [][] matrix=new int[row][col];

        // Taking the input in matrix
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        // Taking target as a input
        int target=sc.nextInt();

        // Calling method to check whether element exist in matrix or not
        boolean check=searchMatrix(matrix,row,col,target);

        if(check) System.out.println("Target found");
        else {
            System.out.println("Target not found");
        }
    }
}
