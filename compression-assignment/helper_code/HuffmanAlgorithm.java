package helper_code;

import helper_code.BinaryStdIn;
import helper_code.BinaryStdOut;
import helper_code.MinPQ;

/******************************************************************************
 *  Compilation:  javac Huffman.java
 *
 *  Compress or expand a binary input stream using the Huffman algorithm.
 *
 * Add instructions and documentation related to your Huffman algorithm here...
 *
 ******************************************************************************/


/**
 *  Add in your information about each method etc. here
 *
 *
 *  @author Your name
 */
public class HuffmanAlgorithm {

    // alphabet size of extended ASCII
    private static final int R = 256;

    // Do not instantiate.
    private HuffmanAlgorithm() { }

    // Huffman trie node
    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        // is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    /**
     * Reads a sequence of 8-bit bytes from standard input; compresses them
     * using Huffman codes with an 8-bit alphabet; and writes the results
     * to standard output.
     */
    public static void compress() {
        // read the input
    	String input = BinaryStdIn.readString();
    	char[] chars = input.toCharArray(); //Separate input string into it's chars

        // tabulate frequency counts
    	int[] freq = new int[R]; //Max of R different chars as there are R ASCII chars
    	
    	for(int i = 0; i<chars.length; i++)
    	{
    		freq[chars[i]]++; //Increment freq at correct position
    	}

        // build Huffman trie
    	Node root = buildTrie(freq);

        // build code table
    	String[] st = new String[R];
    	buildCode(st, root, "");

        // print trie for decoder
    	writeTrie(root);

        // print number of bytes in original uncompressed message
    	BinaryStdOut.write(chars.length);

        // use Huffman code to encode input
    	for(int i=0; i<chars.length; i++)
    	{
    		 //Add code of each char to compute compressed bitstring
    		String code = st[chars[i]];
    		
    		for(int j=0; j<code.length(); j++)
    		{
    			if(code.charAt(j) == '0')
    				BinaryStdOut.write(false);		
    			else if(code.charAt(j) == '1')
    				BinaryStdOut.write(true);
    			else
    				throw new IllegalStateException("Illegal State");
    		}
    	}
    	BinaryStdOut.close(); //Close output stream    
    }


    /**
     * Reads a sequence of bits that represents a Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void decompress() {
        // read in Huffman trie from input stream
    	Node root = readTrie();

        // number of bytes to write
    	int noOfBytes = BinaryStdIn.readInt();
    	
        // decode using the Huffman trie
    	for (int i=0; i<noOfBytes; i++)
    	{
    		Node x = root; //Start at the root
    		/*Iterate down through the tree, checking if 0 or 1 each time*/
    		while(!x.isLeaf())
    		{
    			/*Check if value from code is 1, if it isn't then it's 0 so go to the left*/
    			boolean one = BinaryStdIn.readBoolean();
    			if (one)
    				x = x.right;
    			else
    				x = x.left;
    		}
    		
    		BinaryStdOut.write(x.ch, 8); //Write out the char (it has 8 relevant bits)
    	}
    	BinaryStdOut.close(); //Close output stream
    }

    // build the Huffman trie given frequencies
    private static Node buildTrie(int[] freq) {

        // initialze priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<Node>();
        for (char i = 0; i < R; i++)
            if (freq[i] > 0)
                pq.insert(new Node(i, freq[i], null, null));

        // special case in case there is only one character with a nonzero frequency
        if (pq.size() == 1) {
            if (freq['\0'] == 0) pq.insert(new Node('\0', 0, null, null));
            else                 pq.insert(new Node('\1', 0, null, null));
        }

        // merge two smallest trees
        while (pq.size() > 1) {
            Node left  = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }


    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch, 8);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    // make a lookup table from symbols and their encodings
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[x.ch] = s;
        }
    }



    private static Node readTrie() {
        boolean isLeaf = BinaryStdIn.readBoolean();
        if (isLeaf) {
            return new Node(BinaryStdIn.readChar(), -1, null, null);
        }
        else {
            return new Node('\0', -1, readTrie(), readTrie());
        }
    }

    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "compress" an {@code decompress()} if it is "decompress".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
    	if (args[0].equals("-")) 
    	{
    		final long startTime = System.nanoTime();
    		compress();
    		final long elapsedTime = System.nanoTime() - startTime;
    		/*System.err ensures that the time taken is always printed at the end - doesn't matter what's in the BinaryStdOut buffer*/
    		System.err.println("Time taken for compression: " + elapsedTime + "ns");
    	}
    	else if (args[0].equals("+"))
    	{
    		final long startTime = System.nanoTime();
    		decompress();
    		final long elapsedTime = System.nanoTime() - startTime;
    		/*System.err ensures that the time taken is always printed at the end - doesn't matter what's in the BinaryStdOut buffer*/
    		System.err.println("Time taken for decompression: " + elapsedTime + "ns");
    	}
    	else throw new IllegalArgumentException("Invalid command line argument."
    			+ " Please enter \"-\" to compress or \"+\" to decompress.");
    }

}

