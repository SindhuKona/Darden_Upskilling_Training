package com.priya;

import java.util.Scanner;

public class incomeTax {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Double incomeRange=sc.nextDouble();
		Double it=0.0;
		
		if(incomeRange>=0 && incomeRange<=180000) {
			it=0.0;
		}
		else if(incomeRange>181000 && incomeRange<=300000) {
			it= 0.1*(incomeRange-1800000);
		}
		else if(incomeRange>300001 && incomeRange<=500000) {
			it=0.2*(incomeRange-300000);
		}
		else if(incomeRange>500001 && incomeRange<=1000000) {
			it =0.3*(incomeRange-500000);
		}
		System.out.println("the income tax for the given income is : "+ it);

}

}