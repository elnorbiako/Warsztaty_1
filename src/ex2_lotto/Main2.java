package ex2_lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;


public class Main2 {
	
	public static void main(String[] args) {
		
		lottoResult();
		
	}	
/**
 * Lottery: 6 numbers from 1 to 49, sorted 
 * @return int[] with 6 numbers 
 */
	static int[] lotto6() {
		
		Integer[] arr = new Integer[49];
		for (int i = 0; i < arr.length; i++) {
		  arr[i] = i + 1;
		}
//		System.out.println(Arrays.toString(arr));
		Collections.shuffle(Arrays.asList(arr));
//		System.out.println(Arrays.toString(arr));
		
		int[] lottoSixNumbers = new int[6];
			for (int i=0; i<lottoSixNumbers.length; i++) {
				lottoSixNumbers[i] = arr[i];
			}
		System.out.println(Arrays.toString(lottoSixNumbers));
		return lottoSixNumbers;
	} 
	
	/**
	 * User input for lotto - 6 numbers from 1 to 49, unique, lettersproof
	 * @return sorted 6 user numbers 
	 */
	static int[] user6() {
		
		int[] userNumbers = new int[6];
		
		Scanner scan = new Scanner(System.in);
		int n =0;
		System.out.println("Type a number from 1-49: ");
		
		for (int i=0;i<6;i++) {
			while (scan.hasNextLine()) {
				
				try {
					
					n = Integer.parseInt( scan.nextLine() );
					
	    			if (ArrayUtils.contains(userNumbers, n)) {
	    				System.out.println("Numbers must be unique!");
	    				
	    			} else if (n > 49) {
	    	            System.out.println("Out of range - too high!");
	    	           
	    	        } else if (n <= 0) {
	    	            System.out.println("out of range - too low!");
	    	           
		        	} else {
		        		userNumbers[i] = n;
		        		System.out.println("Next number: ");
		        		break;
		        	}	    			
	    			
				}catch (NumberFormatException e) {
	    				
		            System.out.println("This is not a number!");
//				           
				}
			
			}
		}
		Arrays.sort(userNumbers);
//		int[] lottoConfirm =lotto6();
//		System.out.println("Lotto numbers: " + Arrays.toString(lottoConfirm));
		System.out.println("Your numbers: " + Arrays.toString(userNumbers));
		return userNumbers;
	}
	/**
	 * Matches two 6 int Arrays, checks how many times one value matches other  
	 * @return number of hits
	 */
	static int lottoMatcher() {
		
		
		int[] userNo = user6();
		int[] lottoNo = lotto6();
		int counter=0;
		for (int i=0; i<userNo.length; i++) {
			int n1 = userNo[i];
			for (int j=0; j<lottoNo.length; j++) {
				int n2 = lottoNo[j];
				if (userNo[i] == lottoNo[j]) {
					counter++;
				}				
			}
		}
		System.out.println(counter + " hits");
		return counter;
	}
	/**
	 * Depending on counter hits, gives a result 
	 */
	static void lottoResult() {
		
		int result = lottoMatcher();
		
		switch (result) {
		case 6:
			System.out.println("Congratulations, its a six!! You're a milionare!!" );
			break;
		case 5:	
			System.out.println("Five hits! Great!" );
			break;
		case 4:	
			System.out.println("Four, very good!");
			break;	
		case 3:	
			System.out.println("Three, at least something.");
			break;
		default:
			System.out.println("Sorry, better luck next time...");
			break;
		}
		
	}
	
}


	
		
