package Day04_StringBuilder_String_Buffer_fileReader_InputStreamReader;

import java.sql.Struct;
import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    // Method to remove duplicate character
    static StringBuilder removeDuplicate(String s){
        int len=s.length();  // Finding the length of string

        // Create a HashSet to check whether element is first time coming or not
        HashSet<Character>st=new HashSet<>();

        // Making StringBuilder to store distinct character
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<len;i++){
            if(!st.contains(s.charAt(i))){  // Checking the character present in sset or not
                sb.append(s.charAt(i));
                st.add(s.charAt(i));
            }
        }
        return sb;
    }
    public static void main(String[] args) {
        // Creating the object of Scanner class to read user input
        Scanner sc=new Scanner(System.in);

        String s=sc.nextLine();    // Take a string as user input
        StringBuilder distinctCharacter=removeDuplicate(s);

        System.out.println("String after removing duplicate: "+distinctCharacter);

    }
}
