import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner methodIn = new Scanner(System.in);

        System.out.println("Please enter the number which corresponds to the method you wish to run.");
        System.out.println("1 = Fibonacci, 2 = Hanoi, 3 = Russian Peasant, 4 = ThreeSumA\n5 = ThreeSumB, 6 = Sorting, "
        		+ "7 = BruteForceSearch\n8 = KMPSearch, 9 = Trie, 10 = CompressString");
        System.out.println("Enter number here: ");
        int method = methodIn.nextInt();
        methodIn.close();
        
        switch(method)
        {
        	case 1:
        		System.out.println("Fibonacci class chosen:");
				int n = 10;
				/* Check each method with different values for n */
				while (n < 45) 
				{
					long startTimeFib = System.nanoTime();
					//Fibonacci.fibonacciIterative(n);
					Fibonacci.fibonacciRecursive(n);
					long elapsedTimeFib = System.nanoTime() - startTimeFib;
					System.out.println(n + " " + elapsedTimeFib);
					n *= 1.2;
	
				}
				break;
        	case 2:
        		System.out.println("Hanoi class chosen:");
                int n1 = 3; // Number of disks 
            	long startTimeHanoi = System.nanoTime();
            	Hanoi.towersOfHanoi(n1, "A", "C", "B");  // A, B and C are names of rods 
            	long elapsedTimeHanoi = System.nanoTime() - startTimeHanoi;
            	System.out.println(n1 + " " + elapsedTimeHanoi);
            	break;
        	case 3:
        		System.out.println("RussianPeasant class chosen:");
                RussianPeasant r = new RussianPeasant();
                final long startTimeRP = System.nanoTime();
                System.out.println(r.RussianMultiply(233, 100000)); //Input different sizes for numbers to record time taken
                final long elapsedTimeRP = System.nanoTime() - startTimeRP;
                System.out.println("the time taken " + elapsedTimeRP);
                break;
        	case 4:
        		System.out.println("ThreeSumA class chosen (make sure you entered name of file as cmd line argument):");
            	long startTimeTSA = System.nanoTime();
                In inTSA = new In(args[0]); //Muster enter name of file as cmd line argument in run configs
                int[] a = inTSA.readAllInts();
                int count = ThreeSumA.count(a);
                long elapsedTimeTSA = System.nanoTime() - startTimeTSA; 
                System.out.println("Count: " + count);
                System.out.println("the time taken " + elapsedTimeTSA); 
        		break;
        	case 5:
        		System.out.println("ThreeSumB class chosen (make sure you entered name of file as cmd line argument):");
            	long startTimeTSB = System.currentTimeMillis();
                In inTSB = new In(args[0]); //Muster enter name of file as cmd line argument in run configs
                int[] aTSB = inTSB.readAllInts();
                int countB = ThreeSumB.count(aTSB);               
                long elapsedTimeTSB = System.currentTimeMillis() - startTimeTSB; 
                System.out.println("count =" + countB);
                System.out.println("the time taken " + elapsedTimeTSB); 
                break;
        	case 6:
        		System.out.println("Sorting class chosen:");
            	int nSorting = 10;
            	
            	//use an integer variable to decide which sorting algorithm to use below
            	int typeSort = 5;
            	while(nSorting<=100000)
            	{
                	int[] aSorting = new int[nSorting];
                	
                	Random random = new Random();
                	
                	for(int i=0; i<aSorting.length; i++)
                	{
                		aSorting[i] = random.nextInt(nSorting);
                	}
                	
                	long startTimeSorting = System.nanoTime();
                	
                	switch (typeSort)
                	{
        	        	case 0:
        	        		Sorting.selection_sort(aSorting);
        	        		break;
        	        	case 1:
        	        		Sorting.insertionSort(aSorting);
        	        		break;
        	        	case 2:
        	        		Sorting.bogoSort(aSorting);
        	        		break;
        	        	case 3:
        	        		Sorting.mergeSort(aSorting, 0, nSorting-1);
        	        		break;
        	        	case 4:
        	        		Sorting.enhancedMergeSort(aSorting, 0, nSorting-1);
        	        		break;
        	        	case 5:
        	        		Sorting.quickSort(aSorting, 0, nSorting-1);
        	        		break;
        	        	case 6:
        	        		Sorting.enhancedQuickSort(aSorting, 0, nSorting-1);
        	        		break;
        				default:
        					System.err.printf("\nBad sort ID '%d'", typeSort);
        					System.exit(-2);
                	}
          
                	long elapsedTimeSorting = System.nanoTime() - startTimeSorting; 
                	System.out.println(nSorting + " " + elapsedTimeSorting + " " + Sorting.isSorted(aSorting));

                	nSorting*=1.5;
            	}
            	break;
        	case 7:
        		System.out.println("BruteForceSearch class chosen:");
        		String txt;
        		String pat = "ABABCABAB"; 
        	    File file = new File("bruteForce.txt");
				Scanner sc;
				try {
					sc = new Scanner(file);
	        	    int i = 0;
	        	    
	        	    /*Each line in file is separate text to search for pattern
	        	      print each line that there is a match in and at which index*/
	        	    while(sc.hasNextLine())
	        	    {
	        	    	txt = sc.nextLine();
	        	    	System.out.print("Line " + i + ": ");
	        	    	i++;
	        	    	long startTimeBFS = System.currentTimeMillis();
	        	    	BruteForceSearch.search(txt, pat);
	        	    	long elapsedTimeBFS = System.currentTimeMillis() - startTimeBFS; 
	        	    	System.out.println("the time taken for selection " + elapsedTimeBFS);  
	        	    }  
	        	    
	        	    sc.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
        	case 8:
        		System.out.println("KMPSearch class chosen:");
        		String txtKMP;
        		String patKMP = "ABABCABAB"; 
        	    File fileKMP = new File("kmpSearch.txt");
				Scanner scKMP;
				try {
					scKMP = new Scanner(fileKMP);
	        	    int i = 0;
	        	    
	        	    /*Each line in file is separate text to search for pattern
	        	      print each line that there is a match in and at which index*/
	        	    while(scKMP.hasNextLine())
	        	    {
	        	    	txtKMP = scKMP.nextLine();
	        	    	System.out.print("Line " + i + ": ");
	        	    	i++;
	        	    	long startTimeKMP = System.currentTimeMillis();
	        	    	new KMPSearch().KMPSearch(patKMP, txtKMP); 
	        	    	long elapsedTimeKMP = System.currentTimeMillis() - startTimeKMP; 
	        	    	System.out.println("the time taken for selection " + elapsedTimeKMP); 
	        	    }  
	        	    
	        	    scKMP.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
        	    break;
        	case 9:
        		System.out.println("Trie class chosen:");
        		// Input keys (use only 'a' through 'z' and lower case) 
        		String keys[] = { "bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver" };

        		String output[] = { "Not present in Trie", "Present in Trie" };

        		Trie.root = new Trie.TrieNode();

        		// Construct Trie 
        		int i;
        		for (i = 0; i < keys.length; i++) 
        		{
        			Trie.insert(keys[i]);
        		}

        		// Search for different keys 
                if(Trie.search("bank") == true) 
                    System.out.println("bank --- " + output[1]); 
                else System.out.println("bank --- " + output[0]); 
                  
                if(Trie.search("bring") == true) 
                    System.out.println("bring --- " + output[1]); 
                else System.out.println("bring --- " + output[0]); 
                
                if(Trie.search("film") == true) 
                    System.out.println("film --- " + output[1]); 
                else System.out.println("film --- " + output[0]); 
                
                if(Trie.search("filter") == true) 
                    System.out.println("filter --- " + output[1]); 
                else System.out.println("filter --- " + output[0]); 
                
                if(Trie.search("simple") == true) 
                    System.out.println("simple --- " + output[1]); 
                else System.out.println("simple --- " + output[0]); 
                
                if(Trie.search("silt") == true) 
                    System.out.println("silt --- " + output[1]); 
                else System.out.println("silt --- " + output[0]); 
                
                if(Trie.search("silver") == true) 
                    System.out.println("silver --- " + output[1]); 
                else System.out.println("silver --- " + output[0]); 
                
                if(Trie.search("books") == true) 
                    System.out.println("books --- " + output[1]); 
                else System.out.println("books --- " + output[0]); 
                  
                if(Trie.search("banana") == true) 
                    System.out.println("banana --- " + output[1]); 
                else System.out.println("banana --- " + output[0]); 

                if(Trie.search("iva") == true) 
                    System.out.println("iva --- " + output[1]); 
                else System.out.println("iva --- " + output[0]); 
                  
                if(Trie.search("simpbar") == true) 
                    System.out.println("simpbar --- " + output[1]); 
                else System.out.println("simpbar --- " + output[0]); 
                break;
        	case 10:
        		System.out.println("CompressString class chosen:");
        		System.out.println(CompressString.rle("aaaabbbbbb"));
        		break;
    		default:
    			System.out.println("Invalid number chosen.");
    			break;
        }
	}
}
