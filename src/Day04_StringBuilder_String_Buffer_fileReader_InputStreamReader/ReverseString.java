package Day04_StringBuilder_String_Buffer_fileReader_InputStreamReader;

import java.util.Scanner;

public class ReverseString {

    // Static method to reverse the string
    static String reverse(String s){
        StringBuilder sb=new StringBuilder(s);  // Using StringBuilder class

        sb.reverse();  // Uses inbuilt method reverse
        return sb.toString();
    }
    public static void main(String[] args) {
        // Creating the object of Scanner class to read user input
        Scanner sc=new Scanner(System.in);

        String s=sc.nextLine();    // Take a string as user input

        System.out.println("Old string is"+s);   // Old string

        String reverseString = reverse(s);  // Reverse string

        System.out.println("Reversed string is: "+reverseString);

    }
}
