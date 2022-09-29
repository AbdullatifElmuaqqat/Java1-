/*
 * Class: CMSC203 
 * Instructor: Professor Thai.
 * Description: (Build an application that will receive a guess and report if your guess is the 
 * random number that was generated.  Your application will narrow 
 * down the choices according to your previous guesses and 
 * continue to prompt you to enter a guess until you guess correctly).
 * 
 * Due: 10/01/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Print your Name here: Abdullatif Elmuaqqat
*/ 

import java.util.Random;
import java.util.Scanner;

public class RandomNumberGuesser {

	
	

	public static void main(String[] args) 
	
	{	
			Scanner input = new Scanner(System.in);//Create a scanner object
			boolean re_run = false; //Create a boolean data type and initialize it
			final int MIN = 0; // Create a constent variable calls Min which work as the possible min value the user can insert.
			final int MAX = 100; // Create a constent variable calls Max which work as the possible max value the user can insert. 
			int correct_guess = 40; //Generates a random number.
			int integerchoice; //Store the guesses
			int lowguess = 0; // Low guess
			int highguess = 100; // High guess
			String programmer = "Abdullatif Elmuaqqat";
			
			System.out.println("This application generates a ranbdom integer between 0 and 100 \n"
					+ "and ask the user to guess repeatedly until they guess correctly");
			
			
			do { //Open a do while loop for the first guess to loop until the user insert a valid number 0 - 100 
					
				
				RNG.resetCount();
				
				do {
					RNG count1 = new RNG(); 
					int count = RNG.getCount(); //Call the getter and store it in count variable.
					RNG.resetCount();
				//enter the first guess
				System.out.println("Enter your first guess:\n");
				integerchoice = input.nextInt(); //Store the value
				
				// If the guess is bigger than the 100 and smaller than 0 loop into valudation method.
				if(integerchoice >= MAX || integerchoice <= MIN) {
					--count;
					RNG.inputValidation(integerchoice,  MIN, MAX);
					++count;
				}
				++count;

			} while ( integerchoice >= MAX || integerchoice <= MIN);
				
				RNG increment = new RNG();
				int count = RNG.getCount(); //Call the getter and store it in count variable.
				
				while(integerchoice != correct_guess && count <= 7)
				{	
					
					// if the integer is higher than the random number.
					if(integerchoice < correct_guess) {

						toolow(); //Display that the guess is too low
						lowguess = integerchoice; //Save the guess 
						
					} else {
						
						//guess is too high 
						toohigh();
						
						//store the high value in this variable
						highguess= integerchoice;
					}
						
					    System.out.println("Number of guesses: " + count);
						System.out.printf("Enter your guesses between %d and  %d \n", lowguess, highguess);
						integerchoice = input.nextInt();
						
						// If the guess is less than the low guess or higher than the max guess loop the validation method
						if(integerchoice <= lowguess || integerchoice >= highguess) {
						while(integerchoice <= lowguess || integerchoice >= highguess) {
							--count;
							RNG.inputValidation(integerchoice, lowguess, highguess);
							integerchoice = input.nextInt();
							++count;
						}
					}
						++count;
						
						if (count > 7) {
						
							System.out.print("\nYou have exceeded the maximum number of guesses, 7. Try again.\n");
							break;
							
							}
				}
					
				
						
						if  (integerchoice == correct_guess && count != 7) {
							System.out.println("Congradulation, you guessed correctly\n");	
					}
										
					
					System.out.println("Try again (yes/no)\n");
					String choice = input.next();
					char letter = choice.charAt(0);
				
					if(letter =='y' || letter == 'Y'){
						
						re_run = true;

						
					} else {
						
						re_run = false;
					}
					
					
				} while(re_run);
			
			System.out.print("\nThanks for testing my code. \n Programmer name: " + programmer);
		}
			
	
	
	public static void toohigh() {
		
		System.out.println("Your guess is too high\n");
		//System.out.println("Number of guesses: " + count);
		
	}
	
	public static void toolow()
	
	{
		System.out.println("Your guess is too low\n");
		//System.out.println("Number of guess: " + count);
		
		}
	
	
	}