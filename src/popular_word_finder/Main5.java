package popular_word_finder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main5 {
	
	public static void main(String[] args)  {
		
		String input = "http://www.onet.pl/";
		wordFinder(input);
		
		
	}
	
/**
 * Based on a given url, method scans all span with class title, separates to words, eliminates shorter then 3 chars, 
 * compares with excluded list, and finally saves to a file list of popular words.  
 * @param input
 * @return txt file 
 */
	static void wordFinder(String input) {
		
		Connection connect = Jsoup.connect(input);
		try {
		    Document document = connect.get();
		    Elements links = document.select("span.title");
		    
		    String str = "popular_words.txt";
		    String str2 = "filtered_popular_words.txt";
		    Path p1 = Paths.get(str); 
		    Path p2 = Paths.get(str2); 
		    
		    FileWriter in = new FileWriter(str, false);	
		    String wordIn = new String();
		    
		    
		    for (Element elem : links) {
		     StringTokenizer wordInToken = new StringTokenizer(elem.text() );
		     	while (wordInToken.hasMoreTokens()) {
		     		String s = wordInToken.nextToken();
		     		s.replaceAll("\\.,:-\\?\\!", "");
		     		in.append(s + "\n");		     
		     	}		    
		    
		    }
		    in.close();	
		    
		    String[] excluded = {"oraz", "ponieważ", "dla" };
		    List nonValid = Arrays.asList(excluded);
		    
		    FileWriter out = new FileWriter(str2, false);	
		    File fileIn = new File(str);
		    Scanner scan = new Scanner(fileIn);
		    while (scan.hasNextLine()) {
		        String wordToFiltr = scan.nextLine();
		        if (wordToFiltr.length()> 2 && !nonValid.contains(wordToFiltr) )
		        { out.append(wordToFiltr + "\n");  }
		         
		    }		    
		    out.close();
		    
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
}