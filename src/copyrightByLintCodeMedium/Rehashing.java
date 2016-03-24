/**
 * 
 */
package copyrightByLintCodeMedium;
 

/**
 * @author Poirot
 *
 */
public class Rehashing {
	
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
    	ListNode[] res = new ListNode[hashTable.length * 2];
    	ListNode[] resTail = new ListNode[hashTable.length * 2];
    	for (int i = 0; i < hashTable.length; i++) {
			ListNode root = hashTable[i]; 
			while (root != null) {
				ListNode node = root.next; 
				int hash = root.val % res.length;
				if (hash < 0) {
					hash += res.length;
				}
				if (res[hash] == null) {
					root.next = null;
					res[hash] = root;
					resTail[hash] = root;
				} else {
					root.next = null;
					resTail[hash].next = root;
					resTail[hash] = root;
				} 
				root = node;
			}
		}
    	return res;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rehashing t = new Rehashing();
		ListNode[] hashTable = new ListNode[5];
		ListNode a = new ListNode(42);
		ListNode b = new ListNode(32);
		ListNode c = new ListNode(-7);
//		System.out.println((-7) % 5);
		a.next = b;
		hashTable[2] = a;
		hashTable[3] = c;
		ListNode[] res = t.rehashing(hashTable);
		for (int i = 0; i < res.length; i++) {
			ListNode temp = res[i];
			while (temp != null) {
				System.out.print(temp.val + " ");
				temp = temp.next;
			}
			System.out.println();
		}
	}

}
