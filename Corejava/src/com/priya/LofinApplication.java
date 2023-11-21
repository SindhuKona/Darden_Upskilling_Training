package com.priya;

import java.util.Scanner;
	
	public class LofinApplication {
	    private static final int MAX_ATTEMPTS = 3;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int attempts = 0;

	        while (attempts < MAX_ATTEMPTS) {
	            System.out.print("Enter Login Name: ");
	            String Username = scanner.nextLine();
	            System.out.print("Enter Password: ");
	            String Password = scanner.nextLine();

	            if (validateLogin(Username, Password)) {
	                System.out.println("Welcome, " + Username + "!");
	                break; // Successful login, exit the loop
	            } else {
	                attempts++;
	                System.out.println("Invalid credentials. Attempts left: " + (MAX_ATTEMPTS - attempts));
	            }
	        }

	        if (attempts == MAX_ATTEMPTS) {
	            System.out.println("Contact Admin. Too many unsuccessful login attempts.");
	        }
	    }

	    // Function to validate login credentials
	    private static boolean validateLogin(String Username, String Password) {
	        // Replace these with actual valid credentials
	        String validUsername = "admin";
	        String validPassword = "password";

	        return Username.equals(validUsername) && Password.equals(validPassword);


}
	}
