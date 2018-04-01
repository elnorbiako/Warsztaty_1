package dice_game;

import java.util.Arrays;
import java.util.Random;

public class Main4 {
	
	public static void main(String[] args)  {
		
		String str = "1d6";
		
		diceRoller(str);
		
		
	}
	
	


	static void diceRoller(String input)  {
		
				
		String[] array = new String[3] ;
		System.out.println(Arrays.asList(array));
		array = (input.split("D|d|\\+|-") ) ;
		
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
	    	if (input.contains("\\+")) {
	    		for (int i=0; i<= numThrows; i++) {
	    			int a = r.nextInt(numSides+1);
	    			result += a;}
	    		result = result + numExtra;
	    	}	    	
	    	else if (input.contains("-") ) {
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
	    	System.out.println("Nie ma takiej kostki!");
	    }
	    
	    System.out.println("Wynik rzutu to: " + result);
	    
	}
}
	




	