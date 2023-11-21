package com.priya;

import java.util.Scanner;

public class ArmstrongNumber2 {
	public static void main (String args[]) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a Number");
		int number=sc.nextInt();
		if(isArmstrongNumber(number)) {
			System.out.println(number +"is an Armstrong Number");
			
		}
		else {
			System.out.println(number+ "is not an armstrong number");
		}
	}

	private static boolean isArmstrongNumber(int number) {
		int originalNumber, remainder,result=0,n=0;
		originalNumber=number;
		while(originalNumber!=0) {
			originalNumber/=10;
			n++;
		}
		originalNumber=number;
		while(number!=0) {
			remainder = originalNumber % 10;
			result+= Math.pow(remainder, n);
			originalNumber = originalNumber/ 10;

		}
	return result==originalNumber;
		}

}
