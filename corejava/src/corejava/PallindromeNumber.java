package corejava;

import java.util.Scanner;

public class PallindromeNumber {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your number");
		int input=sc.nextInt();
		int inputCopy=input;     // ******* imp line*******
		int reverse=0;

		while(inputCopy!=0)
		{
			reverse = reverse*10 + inputCopy%10;
			inputCopy=inputCopy/10;
		}

		if(reverse==input)
		{
			System.out.println(input+" is a Pallindrome");
		}
		else System.out.println(input+" is not a Pallindrome");

		sc.close(); 
		//or add "@SuppressWarnings("resource")" before the main method.

	}

}
