import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BruteForceSearch 
{  
	public static void search(String txt, String pat) 
	{ 
	   int n = txt.length(); //Text to search for pattern in
	   int m = pat.length(); //Pattern that we are looking for
	   
	   /*Search through positions in text file up until n-m
	    as pattern of size m cannot be found in text with size < m*/
	   for(int pos = 0; pos<=n-m; pos++)
	   {
		   int j;
		   //Check character by character if pattern matches
		   for(j = 0; j<m; j++)
		   {
			   if(txt.charAt(pos+j)!=pat.charAt(j))
				   break;
		   }
		   
		   if(j==m)
		   {
			   System.out.println("Brute Force: Pattern found at index " + pos);
		   }
	   } 
	} 
	  
	public static void main(String[] args) throws FileNotFoundException 
	{ 
		String txt;
		String pat = "ABABCABAB"; 
	    File file = new File("bruteForce.txt");
	    Scanner sc = new Scanner(file);
	    int i = 0;
	    
	    /*Each line in file is separate text to search for pattern
	      print each line that there is a match in and at which index*/
	    while(sc.hasNextLine())
	    {
	    	txt = sc.nextLine();
	    	System.out.print("Line " + i + ": ");
	    	i++;
	    	long startTime = System.currentTimeMillis();
	    	search(txt, pat);
	    	long elapsedTime = System.currentTimeMillis() - startTime; 
	    	System.out.println("the time taken for selection " + elapsedTime);  
	    }  
	    
	    sc.close();
	} 
} 
