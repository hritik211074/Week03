package Day05_Searching.Linear_Search;

import java.util.Scanner;

public class WordFindInSentence {
    static String findWord(String[] arr, int n, String target) {
        for (int i = 0; i < n; i++) {
            if (arr[i].contains(target)) {
                return arr[i];
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of sentences we want to store in array
        System.out.print("Enter the number of sentence: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Array to store n elements
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        // Target string that you want to find in a sentence
        String target = sc.nextLine();

        // Calling the method to find the sentence containing the target word
        String checkFound = findWord(arr, n, target);

        if (!checkFound.equals("")) {
            System.out.println("Word found in a sentence: " + checkFound);
        } else {
            System.out.println("Not found");
        }

        sc.close(); // Close the scanner
    }
}
