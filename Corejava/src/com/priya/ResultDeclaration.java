package com.priya;

import java.util.Scanner;

public class ResultDeclaration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter marks for subject1:");
		int subject1 = sc.nextInt();
		System.out.println("Enter marks for subject2:");
		int subject2 = sc.nextInt();

		System.out.println("Enter marks for subject3:");
		int subject3 = sc.nextInt();
		if (subject1 > 60 && subject2 > 60 && subject3 > 60) {
			System.out.println("Result:Passed");
		} else if ((subject1 > 60 && subject2 > 60) || (subject1 > 60 && subject3 > 60)
				|| (subject2 > 60 && subject3 > 60)) {
			System.out.println("Result:Promoted");
		}

		else if (subject1 > 60 || subject2 > 60 || subject3 > 60 || (subject1 < 60 && subject2 < 60 && subject3 < 60)) {
			System.out.println("Result:failed");
		}

	}

}
