package guess_number2;

import java.util.Scanner; 

public class Main3
{
	//Guess number game - user thinks a number from 0-1000, cpu guesses in 10 max attempts to guess
	public static void main(String[] args) throws InterruptedException 
	{
		
		Scanner scan = new Scanner(System.in);

		boolean solved = false;		
		int numberOfGuesses = 0;
		int min = 0;
		int max = 1000;
		int guess;
		

		System.out.println("Think of a number between " + min + " and " + max);
		//Cpu goes into users mind... 
		Thread.sleep(1500);
		
		while(!solved)
		{
			
			//according to binary search, max attempts is 10. If after 10 he dont confirm correct guess receives 'play fair'  
			if (numberOfGuesses == 10)   
				{
				System.out.println("Hey, play fair!");
				numberOfGuesses--;
				guess = min;				
				}
			else 
				{				
				//binary search			
				guess = (max+min)/2;
				//answer options
				System.out.println("My guess: " + guess + "?  Answers: higher, lower, bullseye" );
				numberOfGuesses++;
			
					
				String input = scan.nextLine();
				
				if(input.equals("higher"))
				{
					min = guess;
				}
				else if (input.equals("lower"))
				{
					max = guess;
				}
				else if (input.equals("bullseye"))
				{					
					System.out.println("Your number: " + guess);
					System.out.println("Algorithm took " + numberOfGuesses + " to guess Your number. Clever, huh?");
					solved=true;
				}
				//in case of other inputs 
				else if (!input.equals("higher") && !input.equals("lower") && !input.equals("bullseye") ) {
					System.out.println("Wrong input, try again.");
					numberOfGuesses--;
				}
				
			}
		}
	}
}
	

