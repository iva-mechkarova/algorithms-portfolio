import java.util.Random;
import java.lang.*;
import java.util.ArrayList;

public class Sorting 
{
	public static void selectionSort(int[] a)
	{
		int temp;
		int min_index;
		
		for(int i=0; i<a.length-1; i++)
		{
			min_index = i;
			for(int j=i+1; j<a.length; j++)
			{
				if(a[min_index]>a[j])
				{
					min_index = j;
				}
				
				temp = a[i];
				a[i] = a[min_index];
				a[min_index] = temp;
			}
		}
	}
	
	public static void selection_sort(int[] array)
    {
        int temp;
        int m_index;

        for(int i = 0; i<array.length-1; i++)
        {
            m_index = i;

            for(int j =i+1; j<array.length; j++)
            {
                if(array[m_index] > array[j])
                {
                    m_index = j;
                }
            }
            temp = array[i];
            array[i] = array[m_index];
            array[m_index] = temp;
        }
    }
	
	public static void insertionSort(int[] a)
	{
		int key;
		int j;
		
		for(int i=1; i<a.length; i++)
		{
			key = a[i];
			j = i;
			
			while(j>0 && a[j-1] > key)
			{
				a[j] = a[j-1];
				j--;
			}
			
			a[j] = key;
		}
		
	}
	
	public static void bogoSort(int[] a)
	{
        while (isSorted(a) == false) 
        {
            shuffle(a); 
        }
	}
	
    public static void shuffle(int[] a) 
    { 
         for (int i=1; i < a.length; i++) 
         {
        	 swap(a, i, (int)(Math.random()*i));  
         }          
    } 
	
    public static void swap(int[] a, int i, int j) 
    { 
        int temp = a[i]; 
        a[i] = a[j]; 
        a[j] = temp; 
    } 
    
    public static boolean isSorted(int[] a) 
    { 
        for (int i=1; i<a.length; i++) 
        {
            if (a[i] < a[i-1]) 
            {
            	return false; 
            }
        }
                
        return true; 
    } 
    
    public static void printArray(int[] arr) 
    { 
        for (int i=0; i<arr.length; i++) 
        {
        	System.out.print(arr[i] + " "); 
        }  
        System.out.println(); 
    } 
    
    //Practical 5 Merge Sort
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr)
    {
    	int N = arr.size();
    	int midpoint = N/2;
    	ArrayList<Integer> left = new ArrayList<Integer>();
    	
    	for(int i=0; i<midpoint; i++)
    	{
    		left.add(arr.get(i));
    	}
    	
    	ArrayList<Integer> right = new ArrayList<Integer>();
    	
    	for(int i=midpoint; i<N; i++)
    	{
    		right.add(arr.get(i));
    	}
    	
    	ArrayList<Integer> mergedArray = new ArrayList<Integer>();
    	
    	if(N==1)
    	{
    		return arr;
    	}
    	
    	left = mergeSort(left);
    	right = mergeSort(right);
    	
    	mergedArray = merge(left, right);
    	
    	return mergedArray;
    }
    
    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b)
    {
    	ArrayList<Integer> s = new ArrayList<Integer>();
    	
    	while(!(a.isEmpty()) && !(b.isEmpty()))
    	{
    		if(a.get(0) <= b.get(0))
    		{
    			s.add(a.remove(0));
    		}
    		else if (b.get(0) <= a.get(0))
    		{
    			s.add(b.remove(0));
    		}
    	}
    	
    	if(!a.isEmpty())
    	{
    		for(int x: a)
    		{
    			s.add(x);
    		}
    	}
    	else if (!b.isEmpty())
    	{
    		for(int x: b)
    		{
    			s.add(x);
    		}
    	}
    	
    	return s;
    }
    
    public static void main(String[] args)
    {
    	int[] a = new int[20];
    	int[] b = new int[20];
    	int[] c = new int[20];
    	ArrayList<Integer> d = new ArrayList<Integer>();
    	
    	Random random = new Random();
    	
    	for(int i=0; i<a.length; i++)
    	{
    		a[i] = random.nextInt(20);
    		b[i] = random.nextInt(20);
    		c[i] = random.nextInt(20);
    		d.add(random.nextInt(20));
    	}
    	

    	
    	printArray(a);
    	
    	long startTime = System.currentTimeMillis();
    	selection_sort(a);
    	long elapsedTime = System.currentTimeMillis() - startTime; 
    	System.out.println("the time taken for selection " + elapsedTime);  
    	printArray(a);
    	
    	printArray(b);
    	long startTime1 = System.currentTimeMillis();
    	insertionSort(b);
    	long elapsedTime1 = System.currentTimeMillis() - startTime1; 
    	System.out.println("the time taken for insertion " + elapsedTime1);
    	printArray(b);
    	
    	/*printArray(c);
    	long startTime2 = System.currentTimeMillis();
    	bogoSort(c);
    	long elapsedTime2 = System.currentTimeMillis() - startTime2; 
    	System.out.println("the time taken for insertion " + elapsedTime2);
    	printArray(c);*/

    	System.out.println("Merge Sort unsorted: " + d);
    	long startTime3 = System.currentTimeMillis();
    	System.out.println("Merged Sort sorted: " + mergeSort(d));
    	long elapsedTime3 = System.currentTimeMillis() - startTime3; 
    	System.out.println("the time taken for merge sort " + elapsedTime3);
    }

}
