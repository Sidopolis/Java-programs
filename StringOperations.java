// Accept a String and a character from the keyboard and do the following operations
	//i.	convert the string in upper case
	//ii.	Convert the string in lowercase
	//iii.	Check whether the string is a palindrome or not
	//iv.	Find the length of the String
	//v.	Check that the accepted character is repeated how many times in the String and at what position.
	//vi.	Display the String in reverse order.
	//vii.	Count the number of words in the String.
	//viii.	Count the number of vowel in the String.
	//ix.	Display the initials of the string.
	//x.	Display the string in alphabetical order.

import java.util.Arrays;
import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Accepting the string and character from the keyboard
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();
        System.out.print("Enter a character: ");
        char ch = scanner.next().charAt(0);
        
        // Convert the string in upper case
        String upperCaseString = string.toUpperCase();
        System.out.println("Uppercase String: " + upperCaseString);
        
        // Convert the string in lowercase
        String lowerCaseString = string.toLowerCase();
        System.out.println("Lowercase String: " + lowerCaseString);
        
        // Check whether the string is a palindrome or not
        boolean isPalindrome = true;
        for (int i = 0; i < string.length()/2; i++) {
            if (string.charAt(i) != string.charAt(string.length()-i-1)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("String is a Palindrome");
        } else {
            System.out.println("String is not a Palindrome");
        }
        
        // Find the length of the String
        int lengthOfString = string.length();
        System.out.println("Length of the String: " + lengthOfString);
        
        // Check that the accepted character is repeated how many times in the string and at what position.
        int charCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ch) {
                charCount++;
                System.out.println("Character " + ch + " is present at position " + (i+1));
            }
        }
        System.out.println("Character " + ch + " is repeated " + charCount + " times in the string.");
        
        // Display the String in reverse order.
        String reverseString = "";
        for (int i = string.length()-1; i >= 0; i--) {
            reverseString += string.charAt(i);
        }
        System.out.println("Reverse of the String: " + reverseString);
        
        // Count the number of words in the String.
        int wordCount = 1;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ' && string.charAt(i+1) != ' ') {
                wordCount++;
            }
        }
        System.out.println("Number of words in the String: " + wordCount);
        
        // Count the number of vowel in the String.
        int vowelCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if ("AEIOUaeiou".indexOf(string.charAt(i)) != -1) {
                vowelCount++;
            }
        }
        System.out.println("Number of vowels in the String: " + vowelCount);
        
        // Display the initials of the string.
        String[] words = string.split(" ");
        String initials = "";
        for (String word : words) {
            initials += Character.toUpperCase(word.charAt(0));
        }
        System.out.println("Initials of the String: " + initials);
        
        // Display the string in alphabetical order.
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        String sortedString = new String(charArray);
        System.out.println("String in alphabetical order: " + sortedString);
    }
}
