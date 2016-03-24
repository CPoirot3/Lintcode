/**
 * 2015��7��17��
 * Poirot
 */
package copyrightByLintCodeMedium;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author Poirot
 *
 */
public class MinStack {
//	private PriorityQueue<Integer> priorityQueue;
//	private Stack<Integer> stack;
//
//	public MinStack() {
//		// do initialize if necessary
//		priorityQueue = new PriorityQueue<>();
//		stack = new Stack<>();
//	}
//
//	public void push(int number) {
//		// write your code here
//		priorityQueue.add(number);
//		stack.add(number);
//	}
//
//	public int pop() {
//		// write your code here
//		int p = stack.pop();
//		priorityQueue.remove(p);
//		return p;
//	}
//
//	public int min() {
//		// write your code here
//		return priorityQueue.peek();
//	}
	
	private Stack<Integer> stack;
	private Stack<Integer> mins; // 随时记住当前的最小值
	public MinStack() {
		// do initialize if necessary 
		stack = new Stack<>();
		mins = new Stack<>();
	}

	public void push(int number) {
		// write your code here 
		stack.add(number);
		if (mins.isEmpty()) {
			mins.push(number);
		} else {
			if (mins.peek() >= number) {
				mins.push(number);
			}
		}
	}

	public int pop() {
		// write your code here
		int p = stack.pop();
		if (p == mins.peek()) {
			mins.pop();
		}
		return p;
	}

	public int min() {
		// write your code here
		return mins.peek();
	}
	
	
	
	/**
	 * @param args
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		// PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		// priorityQueue.add(3);
		// priorityQueue.add(2);
		// priorityQueue.add(9);
		// System.out.println(priorityQueue.poll());
		// priorityQueue.add(8);
		// System.out.println(priorityQueue.poll());
		// System.out.println(priorityQueue.poll());

		System.out.println(InetAddress.getLocalHost().toString());
	}

}
