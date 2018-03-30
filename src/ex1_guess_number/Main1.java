package ex1_guess_number;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main1 {
	
	public static void main(String[] args) {
		
		guessNumber();		
		
	}
	
/**
 * A guess 1-100 game, asking again if user puts letter instead of number
 */
	static void guessNumber() {
		
		Random r = new Random(); 
		int a = r.nextInt(101);
		
		Scanner scan = new Scanner(System.in);
    	int n = 0;
    	
    		
    	System.out.println("Try to guess a number from 0-100: ");	
				    		
		while (scan.hasNextLine()) {
			
			try {
				
				n = Integer.parseInt( scan.nextLine() );
				
    			if(n == a) {
    				break;
    			}else if (n > a) {
    	            System.out.println("Too high!");
    	           
    	        } else if (n < a) {
    	            System.out.println("Too low!");
    	           
	        	}
    			
    			
			}catch (InputMismatchException e) {
    				
	            System.out.println("This is not a number!");
//			            n = scan.nextInt();
	            
			}catch (Exception e) {
					// TODO: handle exception
			}
		}	    	
	
	    System.out.println("Congratulations! The secret number was " + a + ".");
		
	}

}
