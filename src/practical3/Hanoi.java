package practical3;
public class Hanoi 
{
	public static void towersOfHanoi( int disk, String source, String
	 destination, String auxiliary) 
	{
		if (disk ==1) 
		{
			System.out.println("Move disk 1 from rod " +  source + " to rod " + destination); 
			return;
		}
		towersOfHanoi( disk-1, source, auxiliary, destination);
		System.out.println("Move disk " + disk + " from rod " +  source + " to rod " + destination); 
		towersOfHanoi(disk-1, auxiliary, destination, source);
	}
	
    public static void main(String args[]) 
    { 
        int n = 3; // Number of disks 

    	long startTime = System.nanoTime();
    	towersOfHanoi(n, "A", "C", "B");  // A, B and C are names of rods 
    	long elapsedTime = System.nanoTime() - startTime;
    	System.out.println(n + " " + elapsedTime);
    }

} 