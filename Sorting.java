import java.util.Random;
import java.lang.*;
import java.util.ArrayList;

public class Sorting 
{
	public static final int CUTOFF=10;
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
    
    //Practical 6 QuickSort
    /*Low is starting index and high is end index i.e. usually 0 and n-1*/
    public static void quickSort(int[] arr, int low, int high)
    {  	
    	int pi; //Partitioning index
    	if(low<high)
    	{
    		pi = partition(arr, low, high);  //arr[pi] is now at right place
    		quickSort(arr, low, pi-1); //Sort elements before pi
    		quickSort(arr, pi+1, high); //Sort elements after pi
    	}
    }
    
    //Practical 6 QuickSort
    /*Low is starting index and high is end index i.e. usually 0 and n-1*/
    public static void enhancedQuickSort(int[] arr, int low, int high)
    {
    	/*If less than or equal to the cutoff number of elements then insertion sort is faster*/
    	if(high <= low + CUTOFF -1)
    	{
    		insertionSort(arr);
    		return;
    	}
    	
    	shuffle(arr); //Shuffling array before beginning makes algorithm more efficient and protects against worst case
    	
    	medianof3(arr, low, low+(high-low)/2, high); //Sorting low, mid and high to make it more efficient
    	
    	
    	int pi; //Partitioning index
    	if(low<high)
    	{
    		pi = partition(arr, low, high);  //arr[pi] is now at right place
    		enhancedQuickSort(arr, low, pi-1); //Sort elements before pi
    		enhancedQuickSort(arr, pi+1, high); //Sort elements after pi
    	}
    }
    
    //Practical 6 QuickSort
    public static int partition(int[] arr, int low, int high)
    {
    	int pivot = arr[high];
    	int i = low-1; //Index of smaller element
    	
    	//Iterate through all elements except the high as this will naturally be in right place
    	for(int j=low; j<=high-1; j++)
    	{
    		//If current element is smaller than pivot
    		if(arr[j]<pivot)
    		{
    			i++; //Increment index of smaller element
    			/*Swap smaller element with current element*/
    			swap(arr, i, j);
    		}
    	}
    	
    	swap(arr, i+1, high);
    	
    	return i+1; //Return partitioning index
    }
    
    /*Helper function for enhanced quick sort*/
    public static void medianof3(int[] arr, int low, int mid, int high)
    {
        if( arr[mid] < arr[low])
        {
            swap(arr, low, mid);
        }
        if( arr[high]<arr[low])
        {
        	swap(arr, high, low);
        }
        if( arr[high]<arr[mid])
        {
        	swap(arr, high, mid);
        }
        
        swap(arr, mid, high-1);
    }
    
	/*Method which ensures that an array is sorted*/
	public static boolean isSorted(Integer[] array, int length) 
	{
	    if (array == null || length < 2) 
	        return true; 
	    if (array[length - 2].compareTo(array[length - 1]) > 0)
	        return false;
	    return isSorted(array, length - 1);
	}
    
    public static void main(String[] args)
    {
    	int n = 10;
    	
    	while(n<=100000)
    	{
        	int[] a = new int[n];
        	//ArrayList<Integer> d = new ArrayList<Integer>();
        	
        	Random random = new Random();
        	
        	for(int i=0; i<a.length; i++)
        	{
        		a[i] = random.nextInt(n);
        	}
        	
        	long startTime = System.nanoTime();
        	//bogoSort(a);
        	//selection_sort(a);
        	//insertionSort(a);
        	//mergeSort(d);
        	//quickSort(a, 0, n-1);
        	enhancedQuickSort(a, 0, n-1);
        	long elapsedTime = System.nanoTime() - startTime; 
        	System.out.println(n + " " + elapsedTime + " " + isSorted(a));
        	//System.out.println(n +  " " + elapsedTime + " " + isSorted(mergeSort(d).toArray(new Integer[mergeSort(d).size()]), mergeSort(d).toArray(new Integer[mergeSort(d).size()]).length));
        	
        	n*=1.2;
    	}
    	/*int[] a = new int[20];
    	int[] b = new int[20];
    	int[] c = new int[20];
    	ArrayList<Integer> d = new ArrayList<Integer>();
    	int[] e = new int[20];
    	int[] f = new int[20];
    	
    	Random random = new Random();
    	
    	for(int i=0; i<a.length; i++)
    	{
    		a[i] = random.nextInt(20);
    		b[i] = random.nextInt(20);
    		c[i] = random.nextInt(20);
    		d.add(random.nextInt(20));
    		e[i] = random.nextInt(20);
    		f[i] = random.nextInt(20);
    	}
    	

    	
    	printArray(a);
    	long startTime = System.nanoTime();
    	selection_sort(a);
    	long elapsedTime = System.nanoTime() - startTime; 
    	System.out.println("the time taken for selection " + elapsedTime + " " + isSorted(a));  
    	printArray(a);
    	
    	printArray(b);
    	long startTime1 = System.nanoTime();
    	insertionSort(b);
    	long elapsedTime1 = System.nanoTime() - startTime1; 
    	System.out.println("the time taken for insertion " + elapsedTime1 + " " + isSorted(b));
    	printArray(b);
    	
    	printArray(c);
    	long startTime2 = System.currentTimeMillis();
    	bogoSort(c);
    	long elapsedTime2 = System.currentTimeMillis() - startTime2; 
    	System.out.println("the time taken for insertion " + elapsedTime2);
    	printArray(c);

    	System.out.println("Merge Sort unsorted: " + d);
    	long startTime3 = System.nanoTime();
    	mergeSort(d);
    	long elapsedTime3 = System.nanoTime() - startTime3; 
    	System.out.println("the time taken for merge sort " + elapsedTime3 + " " + isSorted(mergeSort(d).toArray(new Integer[mergeSort(d).size()]), mergeSort(d).toArray(new Integer[mergeSort(d).size()]).length));
    	
    	System.out.println("Quick Sort unsorted: ");
    	printArray(e);
    	long startTime4 = System.nanoTime();
    	quickSort(e, 0, 19);
    	long elapsedTime4 = System.nanoTime() - startTime4; 
    	System.out.println("the time taken for quick sort " + elapsedTime4 + " " + isSorted(e));
    	
    	System.out.println("Enhanced Quick Sort unsorted: ");
    	printArray(f);
    	long startTime5 = System.nanoTime();
    	quickSort(f, 0, 19);
    	long elapsedTime5 = System.nanoTime() - startTime5; 
    	System.out.println("the time taken for quick sort " + elapsedTime5 + " " + isSorted(f));*/
    }

}
