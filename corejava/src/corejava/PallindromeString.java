package corejava;

import java.util.Scanner;

public class PallindromeString {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your String");
		String input = sc.next();
		String inputCopy = input; // ******* imp line*******
		String reverse = "";      //******* imp line*******

		for (int i = inputCopy.length() - 1; i >= 0; i--) {
			reverse = reverse + inputCopy.charAt(i);
		}

//		if(reverse.contentEquals(input)) 
//		// boolean java.lang.String.contentEquals(CharSequence cs)--Compares this string to the specified CharSequence
//
//		{
//			System.out.println(input+" is a Palindrome");
//		}
//		else System.out.println(input+" is not a Palindrome");

//		if(reverse.equalsIgnoreCase(input))
//		//boolean java.lang.String.equalsIgnoreCase(String anotherString) -- Compares this String to another String,
//		//ignoring case considerations. 
//
//		{
//			System.out.println(input+" is a Palindrome");
//		}
//		else System.out.println(input+" is not a Palindrome");
//			
		  if(reverse.equals(input))  {      // ******* imp line******* instead reverse==input
		  System.out.println(input+" is a Pallindrome"); } 
		  else System.out.println(input+" is not a Pallindrome");
		 	 
	}

}
