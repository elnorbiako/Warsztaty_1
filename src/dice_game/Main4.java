package dice_game;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

public class Main4 {
	
	public static void main(String[] args)  {
		
		String str = "d6+5";
		
		diceRoller(str);
		
		
	}
	

	static void diceRoller(String input) throws NumberFormatException {
		
		String[] array = new String[3];
		array = (input.split("D|d|\\+|-") ) ;
		
		System.out.println(Arrays.asList(array));
		
			if (array[0]== null) {
				array[0]="1";}
			else if (array[2] == null) {
				array[2]="0";}
			
		
		System.out.println(Arrays.asList(array));
		
		Random r = new Random(); 
		
		
		int numThrows = Integer.valueOf(array[0]) ;
	    int numSides = Integer.valueOf(array[1]);
	    int numExtra = Integer.valueOf(array[2]);	
		int result = 0;
		
		
				
	    if (numThrows == 0) {
	    	numThrows =1;
	    }

	    System.out.println(input);
	    
	    if (numSides == 3 || numSides == 4 || numSides == 6 || numSides == 8 || numSides == 10 || numSides == 12
	    		|| numSides ==20 || numSides == 100 ) {
	    	if ( (input.indexOf('+') ) >=0 ) {
	    		for (int i=0; i<= numThrows; i++) {
	    			int a = r.nextInt(numSides+1);
	    			result += a;}
	    		result = result + numExtra;
	    	}	    	
	    	else if ( (input.indexOf('-') ) >=0 ) {
	    		for (int j=0; j<= numThrows; j++) {
	    			int a = r.nextInt(numSides+1);
	    			result += a;}
	    		result = result - numExtra;
	    	}
	    	else {for (int k=0; k<= numThrows; k++) {
    			int a = r.nextInt(numSides+1);
    			result += a;}
    	    }
	    	
	    }
	    else {
	    	System.out.println("There is no such a dice!");
	    }
	    
	    System.out.println("Wynik rzutu to: " + result);
	    
	}
}
	




	