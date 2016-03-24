/**
 * 2016年3月14日
 * Poirot
 * 下午2:42:11
 * LintCode
 */
package copyrightByLintCodeMedium;

/**
 * @author Poirot
 *
 */
public class SwapTwoNodesinLinkedList {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode preHead = new ListNode(0);
    	preHead.next = head;
    	ListNode node = preHead;
    	ListNode preNode1 = null;
    	ListNode preNode2 = null;
    	boolean findV1 = false;
    	boolean findV2 = false;
    	while ((!findV1 || !findV2) && node.next != null) {
    		if (node.next.val == v1) {
    			preNode1 = node;
    			findV1 = true;
    		} else if (node.next.val == v2) {
    			preNode2 = node;
    			findV2 = true;
    		}
    		node = node.next;
    	}
    	if (!findV1 || !findV2) {
//    		System.out.println("test");
    		return head;
    	} else {
    		if (preNode1.next == preNode2 || preNode2.next == preNode1) {
    			ListNode a = preNode1.next == preNode2 ? preNode1 : preNode2;
    			ListNode b = preNode1.next == preNode2 ? preNode2 : preNode1;
    			a.next = b.next;
    			b.next = b.next.next;
    			a.next.next = b;
    		} else { 
				ListNode t = preNode1.next;
				preNode1.next = preNode2.next;
				preNode2.next = t;
//				System.out.println(preNode2.next == preNode2);
				t = preNode1.next.next;
				preNode1.next.next = preNode2.next.next;
				preNode2.next.next = t;
			}
    		return preHead.next;
    	}
    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		SwapTwoNodesinLinkedList t = new SwapTwoNodesinLinkedList();
		ListNode res = t.swapNodes(a, 2, 3);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
