package practicals4_5_6;
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
        int n = a.length;
        for (int i = 0; i < n; i++) 
        {
            // choose index uniformly in [0, i]
            int r = (int) (Math.random() * (i + 1));
            int swap = a[r];
            a[r] = a[i];
            a[i] = swap;
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
    public static void mergeSort(int arr[], int left, int right)
    {
        if (left < right) 
        { 
            // Find the middle point 
            int mid = (left+right)/2; 
  
            // Sort first and second halves 
            mergeSort(arr, left, mid); 
            mergeSort(arr , mid+1, right); 
  
            // Merge the sorted halves 
            merge(arr, left, mid, right); 
        } 
    }
    
	public static void merge(int arr[], int left, int mid, int right)
    {
        // Find sizes of two subarrays to be merged 
        int n1 = mid - left + 1; 
        int n2 = right - mid; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[left + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[mid + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = left; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        }
	}
	
    public static void enhancedMergeSort(int arr[], int left, int right)
    {
    	/*Stop if already sorted*/
    	if (right <= left) 
    		return;
    	/*If less than or equal to the cutoff number of elements then insertion sort is faster*/
    	if(right <= left + CUTOFF -1)
    	{
    		insertionSort(arr);
    		return;
    	}
    	
        if (left < right) 
        { 
            // Find the middle point 
            int mid = (left+right)/2; 
  
            // Sort first and second halves 
            enhancedMergeSort(arr, left, mid); 
            enhancedMergeSort(arr , mid+1, right); 
  
            // Merge the sorted halves 
            merge(arr, left, mid, right); 
        } 
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
    	
    	//use an integer variable to decide which sorting algorithm to use below
    	int typeSort = 5;
    	while(n<=100000)
    	{
        	int[] a = new int[n];
        	
        	Random random = new Random();
        	
        	for(int i=0; i<a.length; i++)
        	{
        		a[i] = random.nextInt(n);
        	}
        	
        	long startTime = System.nanoTime();
        	
        	switch (typeSort)
        	{
	        	case 0:
	        		selection_sort(a);
	        		break;
	        	case 1:
	        		insertionSort(a);
	        		break;
	        	case 2:
	        		bogoSort(a);
	        		break;
	        	case 3:
	        		mergeSort(a, 0, n-1);
	        		break;
	        	case 4:
	        		enhancedMergeSort(a, 0, n-1);
	        		break;
	        	case 5:
	        		quickSort(a, 0, n-1);
	        		break;
	        	case 6:
	        		enhancedQuickSort(a, 0, n-1);
	        		break;
				default:
					System.err.printf("\nBad sort ID '%d'", typeSort);
					System.exit(-2);
        	}
  
        	long elapsedTime = System.nanoTime() - startTime; 
        	System.out.println(n + " " + elapsedTime + " " + isSorted(a));

        	n*=1.5;
    	}
    }

}
