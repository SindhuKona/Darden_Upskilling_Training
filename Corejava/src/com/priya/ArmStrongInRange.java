package com.priya;

public class ArmStrongInRange {
	    public static void main(String[] args) {
	        System.out.println("Armstrong numbers between 100 and 999:");

	        for (int i = 100; i <= 999; i++) {
	            if (isArmstrongNumber(i)) {
	                System.out.println(i);
	            }
	        }
	    }

	    // Function to check if a number is an Armstrong number
	    private static boolean isArmstrongNumber(int num) {
	        int originalNum = num;
	        int numDigits = String.valueOf(num).length();
	        int result= 0;

	        while (num > 0) {
	            int digit = num % 10;
	            result += Math.pow(digit, numDigits);
	            num /= 10;
	        }

	        return result == originalNum;
	    }
	}


