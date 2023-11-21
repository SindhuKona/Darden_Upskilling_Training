package com.priya;

public class ArmstrongNumber {

	public static void main(String[] args) {

		int number = 153, originalNumber, remainder;
		double result = 0;

		originalNumber = number;

		while (originalNumber != 0) {
			remainder = originalNumber % 10;
			result = result+ Math.pow(remainder, 3);
			originalNumber = originalNumber/ 10;
		}

		if (result == number)
			System.out.println(number + " is an Armstrong number.");
		else
			System.out.println(number + " is not an Armstrong number.");
	}

}
