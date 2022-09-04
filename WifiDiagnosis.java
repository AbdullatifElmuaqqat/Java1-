import java.util.Scanner;

/*
 * Class: CMSC203 
 * Instructor: Mr. Gary Thai.
 * Description: An application that will step through some possible problems to restore internet connectivity.  
 * Due: 09/07/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Abdullatif Elmuaqqat.
*/

public class WifiDiagnosis {

	public static void main(String[] args) {
		//Create a scanner object to get the user input.
		Scanner input = new Scanner(System.in);			
		//Create a boolean to help in the repeating process.
		boolean answer = true;
		//My name string
		String myname = "Abdullatif Elmuaqqat";
		final String decision = "Yes";
		final String decision1 = "yes";
		final String decision2 = "no";
		final String decision3 = "No";
		
		//Open a do-while loop 
		do {
		
			//Promote the user the first way to resolve the conncetion problem
			System.out.print("If you have a problem with internet connectivity this "
					+ "WiFi Diagnosis might work\n\n");
			System.out.println("Reboot the computer and try to connect\n");
			//Ask the user if it fixed the isuue
			System.out.println("\nDid that fixed the problem? (yes/no)\n");
			String check = input.nextLine();
			//Create if statement with the possible answers 
			if(check.equals(decision) || check.equals(decision1)) {
				System.out.println("\nDone");
				// If no, promote the user to the second solution
			} else if (check.equals(decision2)||check.equals(decision3)) {
				System.out.println("Reboot the router and try to connect\n");
				System.out.println("Did that fixed the problem? (yes/no)\n");
				String check1= input.nextLine();
				// Create if statement with the possible answers
				if(check1.equals(decision) || check1.equals(decision1)){
					System.out.println("\nDone");
					
					//if no, promote the user to the third solution
				} else if(check.equals(decision2)||check.equals(decision3)) {
					System.out.println("Make sure are the cables connceting"+
				" the router are firmly plugged in " + " and power is getting to the router\n");
					System.out.println("Did that fixed the problem? (yes/no)\n");
					String check2 = input.nextLine();
					//create if statemnt with the possible answers
					if(check2.equals(decision) || check2.equals(decision1)){
						System.out.println("\nDone");
						
						//if no, promote the user to the fourth solution
					} else if(check.equals(decision2)||check.equals(decision3)){
						System.out.println("Move the computer closer to the router " + 
					"and try to conncet\n");
						System.out.println("Did that fixed the problem? (yes/no)\n");
						String check3 = input.nextLine();
						//create if statment with the possible answers
						if(check3.equals(decision) || check3.equals(decision1)){
							System.out.println("\nDone");
							
							//if no, promote the user to the last solution
						} else if(check.equals(decision2)||check.equals(decision3)){
							System.out.println(" Contact your ISP\n");
							//exist the user from the loop because it is the last solution 
							System.out.println("\nDone");
				
							/*create 4 elses saing that the input is uncorrect,
							if the user answered with neither yes or no.
							*/ 
						} else {
							System.out.println("Invalud input. please try again!");
						}
					} else {
						System.out.println("Invalid input. please try again!");
					}

				} else {
					System.out.println("Invalid input. please try again!");
				}
			} else {
				System.out.println("Invalid input. please try again!");
			}
			//ask the user if he wants to repeat the program
			System.out.println("\nWould you like to run this Diagnosis again? ( yes/no) only\n");
			String answer1 = input.nextLine();
			//if statments with the possible solutions
			if(answer1.equals(decision)|| answer1.equals(decision1)) {
				//if the user wants to repeat the program will do it
				 answer = true;
			 } else{
				 //anything else just close the programe.
				 answer = false;
				 System.out.println("\nDone");
			 } 
			  
		} while(answer);
		//print my name.
		System.out.println("Programmer name " + myname);
		
		}
	}