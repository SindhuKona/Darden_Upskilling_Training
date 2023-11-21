package com.priya;

import java.util.Scanner;

public class SimpleAndCompound {

	public static Double simpleInterest(double principal, double rate, double time) {
		return principal * rate * time / 100;
	}

	public static Double compoundInterest(double principal, double rate, double time, int number) {
		return principal * (Math.pow((1 + rate / 100), (time * number))) - principal;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the principal: ");
		double principal = sc.nextDouble();

		System.out.print("Enter the rate: ");
		double rate = sc.nextDouble();

		System.out.print("Enter the time: ");
		double time = sc.nextDouble();

		System.out.print("Enter number of times interest is compounded: ");
		int number = sc.nextInt();

		System.out.println("simple Interest=" + simpleInterest(principal, rate, time));
		System.out.println("compoundInterest=" + compoundInterest(principal, rate, time, number));

	}
}
