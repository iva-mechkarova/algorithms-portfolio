package practical9;

public class CompressString 
{

	/**
	 * Practical 9: Step 1
	 * Method which implements Run Length Encoding
	 * @param ucompressed string
	 * @return compressed string
	 * */
	public static String rle(String s)
	{
		String compressedString = ""; //Initialize uncompressed string
		char currentChar; 
		int counter=0;
		
		/*Loop through all chars of the uncompressed string*/
		for(int i=0; i<s.length(); i++)
		{
			currentChar=s.charAt(i);
			
			//This if statement ensures the char is only added to the string once
			if(counter==0)
			{
				compressedString+=currentChar;
			}		
			
			/*If the next char is the same then increment the counter, 
			otherwise increment the counter as it must be the list char of the same type then add
			the counter to the compressed string and reset it*/
			if(i!=s.length()-1 && currentChar==s.charAt(i+1))
			{
				counter+=1;
			}
			else
			{
				counter+=1;
				compressedString+=counter;
				counter=0;
			}	
		}
			
		return compressedString;
	}
	
	public static void main(String[] args)
	{
		System.out.println(rle("aaaabbbbbb"));
	}
}
