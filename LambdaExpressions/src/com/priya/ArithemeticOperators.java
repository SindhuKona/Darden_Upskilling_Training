package com.priya;

public class ArithemeticOperators {
	
	@FunctionalInterface 
	interface Arithmetic{
		int operators(int a, int b);
	}
	public static void main(String[] args) {
		
		//lambda expression to define the calculate method
		Arithmetic addition =(a,b)->a+b;
	    int answer = addition.operators(20,10);
	    System.out.println("The addition of the number is: " + answer);
	    
	    Arithmetic subtraction =(a,b)->a-b;
	    int answer1 = subtraction.operators(20,10);
	    System.out.println("The subtraction of the number is: " + answer1);
	    
	    Arithmetic multiplication =(a,b)->a*b;
	    int answer3 = multiplication.operators(20,10);
	    System.out.println("The multiplication of the number is: " + answer3);
	    
	    Arithmetic division =(a,b)->a/b;
	    int answer4 = division.operators(20,10);
	    System.out.println("The division of the number is: " + answer4);
	  }
}



