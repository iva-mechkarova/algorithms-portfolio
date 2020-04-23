
public class Trie 
{

// Alphabet size (# of symbols) we pick 26 for English alphabet
	static final int ALPHABET_SIZE = 26;

// class for Trie node 
	static class TrieNode 
	{
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
// isEndOfWord is true if the node represents end of a word i.e. leaf node
		boolean isEndOfWord;

		TrieNode() 
		{
			isEndOfWord = false;

			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	}

	static TrieNode root;

// If not key present, inserts into trie 
// If the key is prefix of Trie node,  
//  marks leaf node
	static void insert(String key) 
	{
		int idx; //Variable to store index
		
		TrieNode currentLetter = root; //Initialize variable to root and use it to iterate down the trie
		
		for(int level=0; level<key.length(); level++)
		{
			idx = key.charAt(level) - 'a';
			
			/*If the input key is new or an extension of the existing key, 
			 we need to construct non-existing nodes of the key, and mark end of the word for the last node.*/
			if(currentLetter.children[idx]==null)
			{
				currentLetter.children[idx] = new TrieNode();
			}
			
			/*If the current node has already an existing reference to the current letter, 
			 then set current node to that referenced node.*/
			currentLetter = currentLetter.children[idx]; 
			
			/*If the input key is a prefix of the existing key in Trie, we mark the last node of the key as the end of a word.*/
			 // mark last node as leaf 
			currentLetter.isEndOfWord = true;
		}

	}

// Returns true if key presents in trie, else false 
	static boolean search(String key) 
	{
		int idx; //Variable to store index
		
		TrieNode currentLetter = root; //Initialize variable to root and use it to iterate down the trie
		
       for (int level = 0; level < key.length(); level++) 
        { 
            idx = key.charAt(level) - 'a'; 
       
            /*Check whether that character is already a part of a sub-trie. If it isn't present
            anywhere in the trie, then stop the search and return false*/
            if (currentLetter.children[idx] == null) 
                return false; 
       
            currentLetter = currentLetter.children[idx]; //Iterate through characters
        } 
       
       /*If the trie isn't empty and the isEndofWord field of the last node is true, then the key exists in the trie*/
        return (currentLetter != null && currentLetter.isEndOfWord); 

	}

// Driver 
	public static void main(String args[]) 
	{

// Input keys (use only 'a' through 'z' and lower case) 
		String keys[] = { "bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver" };

		String output[] = { "Not present in trie", "Present in trie" };

		root = new TrieNode();

// Construct trie 
		int i;
		for (i = 0; i < keys.length; i++) 
		{
			insert(keys[i]);
		}

// Search for different keys 
        if(search("bank") == true) 
            System.out.println("bank --- " + output[1]); 
        else System.out.println("bank --- " + output[0]); 
          
        if(search("bring") == true) 
            System.out.println("bring --- " + output[1]); 
        else System.out.println("bring --- " + output[0]); 
        
        if(search("film") == true) 
            System.out.println("film --- " + output[1]); 
        else System.out.println("film --- " + output[0]); 
        
        if(search("filter") == true) 
            System.out.println("filter --- " + output[1]); 
        else System.out.println("filter --- " + output[0]); 
        
        if(search("simple") == true) 
            System.out.println("simple --- " + output[1]); 
        else System.out.println("simple --- " + output[0]); 
        
        if(search("silt") == true) 
            System.out.println("silt --- " + output[1]); 
        else System.out.println("silt --- " + output[0]); 
        
        if(search("silver") == true) 
            System.out.println("silver --- " + output[1]); 
        else System.out.println("silver --- " + output[0]); 
        
        if(search("books") == true) 
            System.out.println("books --- " + output[1]); 
        else System.out.println("books --- " + output[0]); 
          
        if(search("banana") == true) 
            System.out.println("banana --- " + output[1]); 
        else System.out.println("banana --- " + output[0]); 

        if(search("iva") == true) 
            System.out.println("iva --- " + output[1]); 
        else System.out.println("iva --- " + output[0]); 
          
        if(search("simpbar") == true) 
            System.out.println("simpbar --- " + output[1]); 
        else System.out.println("simpbar --- " + output[0]); 

	}

//end of class
}