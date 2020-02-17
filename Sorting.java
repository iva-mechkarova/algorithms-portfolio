import java.util.Random;
import java.lang.*;

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
    
    public static void main(String[] args)
    {
    	int[] a = new int[20];
    	int[] b = new int[20];
    	int[] c = new int[20];
    	Random random = new Random();
    	
    	for(int i=0; i<a.length; i++)
    	{
    		a[i] = random.nextInt(20);
    		b[i] = random.nextInt(20);
    		c[i] = random.nextInt(20);
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
    	
    	printArray(c);
    	long startTime2 = System.currentTimeMillis();
    	bogoSort(c);
    	long elapsedTime2 = System.currentTimeMillis() - startTime2; 
    	System.out.println("the time taken for insertion " + elapsedTime2);
    	printArray(c);
    }

}
