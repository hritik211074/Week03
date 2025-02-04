package Day04_StringBuilder_String_Buffer_fileReader_InputStreamReader;

import java.util.Scanner;

public class ConcatinateString {
    static StringBuffer concatinationOfString(String [] arr,int n){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<n;i++){
            sb.append(arr[i]);
        }
        return sb;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of sentences we want to store in array
        System.out.print("Enter the number of words: ");
        int n = sc.nextInt();

        System.out.println("Enter the words: ");
        // Array to store n elements
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        StringBuffer concatString=concatinationOfString(arr,n);

        System.out.println("After the concatination of all string in array is"+concatString);

    }
}
