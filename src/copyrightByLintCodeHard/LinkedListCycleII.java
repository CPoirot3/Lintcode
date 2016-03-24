/**
 * 2015年9月10日
 */
package copyrightByLintCodeHard;

/**
 * @author Poirot
 *
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		// write your code here

		// solution one
		// if(head==null) return head;
		// ListNode cur = head;
		// ListNode fast = head.next;
		// // same as idea as LinkedList Cycle I, try to detect a loop
		// while(fast != null && fast.next != null) {
		// if(fast == cur) { // loop detected.
		// fast = fast.next;
		// int loopSize = 1;
		// while(fast!=cur) { // find the loop size
		// fast = fast.next;
		// loopSize++;
		// }
		// fast = head; // start from head again
		// cur = head;
		// for(int i = loopSize; i > 0; i--) { //this time, put fast node
		// "loopSize" ahead
		// fast = fast.next;
		// }
		// while(cur!=fast){
		// cur=cur.next;
		// fast = fast.next;
		// }
		// return cur;
		// }
		// fast = fast.next.next;
		// cur = cur.next;
		// }
		// return null;

		// solution two
		if (head == null || head.next == null) {
			return null;
		}
		ListNode cur = head;
		ListNode fast = head;
		boolean isCycle = false;

		while (fast != null && cur != null) {
//			System.out.println(cur.val + "  " + fast.val);
			cur = cur.next;
			if (fast.next == null)
				return null;
			fast = fast.next.next;
			if (cur == fast) {
				isCycle = true;
				break;
			}
		}

		
		if (!isCycle)
			return null;
		cur = head;
//		System.out.println(cur.val + "  " + fast.val);
		
		while (cur != fast) {
			cur = cur.next;
			fast = fast.next;
		}
		return cur;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(-21);
		ListNode b = new ListNode(10);
		ListNode c = new ListNode(4);
		ListNode d = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = b;
		LinkedListCycleII t = new LinkedListCycleII();
		System.out.println(t.detectCycle(a).val);
	}

}
