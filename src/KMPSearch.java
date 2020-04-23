import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// JAVA program for implementation of KMP pattern 
	// searching algorithm 
	  
public class KMPSearch 
{ 
    void KMPSearch(String pat, String txt) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
  
        // create lps[] that will hold the longest 
        // prefix suffix values for pattern 
        int lps[] = new int[M]; 
        int j = 0; // index for pat[] 
  
        // Preprocess the pattern (calculate lps[] 
        // array) 
        computeLPSArray(pat, M, lps); 
  
       int i = 0;
       
       while(i<N)
       {
    	   if(pat.charAt(j)==txt.charAt(i))
    	   {
    		   j++;
    		   i++;
    	   }
    	   
    	   if(j==M)
    	   {
    		 //i-j as i will be at last char of pattern so need to subtract j to find index of first char
    		  System.out.println("KMP: Pattern found at index " + (i-j)); 
    		  j = lps[j - 1];
    	   }
    	   else if(i<N && pat.charAt(j)!=txt.charAt(i))
    	   {
               if (j != 0) 
                   j = lps[j - 1]; 
               else
                   i = i + 1;   
    	   }
       }
        
    } 
  
    void computeLPSArray(String pat, int M, int lps[]) 
    { 
        // length of the previous longest prefix suffix 
        int len = 0; 
        int i = 1; 
        lps[0] = 0; // lps[0] is always 0 
  
        // the loop calculates lps[i] for i = 1 to M-1 
        while (i < M) { 
            if (pat.charAt(i) == pat.charAt(len)) { 
                len++; 
                lps[i] = len; 
                i++; 
            } 
            else // (pat[i] != pat[len]) 
            { 
                // This is tricky. Consider the example. 
                // AAACAAAA and i = 7. The idea is similar 
                // to search step. 
                if (len != 0) { 
                    len = lps[len - 1]; 
  
                    // Also, note that we do not increment 
                    // i here 
                } 
                else // if (len == 0) 
                { 
                    lps[i] = len; 
                    i++; 
                } 
            } 
        } 
    } 
  
    // Driver program to test above function 
    public static void main(String args[]) throws FileNotFoundException 
    { 
		String txt;
		String pat = "ABABCABAB"; 
	    File file = new File("kmpSearch.txt");
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
	    	new KMPSearch().KMPSearch(pat, txt); 
	    	long elapsedTime = System.currentTimeMillis() - startTime; 
	    	System.out.println("the time taken for selection " + elapsedTime); 
	    }  
	    
	    sc.close(); 
    } 
}