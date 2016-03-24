/**
 * 2016年2月26日
 * Poirot
 * 下午12:57:08
 * LintCode
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class ImplementTrie {
	class TrieNode {
	    // Initialize your data structure here.
		TrieNode[] children;
		boolean end = false;
	    public TrieNode() {
	    	children = new TrieNode[26];
	    }
	}

	public class Solution {
	    private TrieNode root;

	    public Solution() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	    	TrieNode travel = root;
	        for (int i = 0; i < word.length(); i++) {
	        	char c = word.charAt(i);
	        	if (travel.children[c - 'a'] == null) {
	        		travel.children[c - 'a'] = new TrieNode();
	        	}
	        	travel = travel.children[c - 'a'];
	        }
	        travel.end = true;
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	    	TrieNode travel = root;
	    	for (int i = 0; i < word.length(); i++) {
	    		char c = word.charAt(i);
	    		if (travel.children[c - 'a'] == null) {
	    			return false;
	    		}
	    		travel = travel.children[c - 'a'];
	    	}
	    	return travel.end;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	    	TrieNode travel = root;
	    	for (int i = 0; i < prefix.length(); i++) {
	    		char c = prefix.charAt(i);
	    		if (travel.children[c - 'a'] == null) {
	    			return false;
	    		}
	    		travel = travel.children[c - 'a'];
	    	} 
	    	return true;
	    }
	    
	    
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
