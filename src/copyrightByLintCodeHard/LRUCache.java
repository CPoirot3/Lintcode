/**
 * 2016年2月26日
 * Poirot
 * 下午3:20:33
 * LintCode
 */
package copyrightByLintCodeHard;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Poirot
 *
 */
public class LRUCache {
	public class Solution {
		HashMap<Integer, Integer> map;
		int capacity;
		int size;
		long time = 0;
		TreeMap<Long, Integer> treeMap;
		HashMap<Integer, Long> mapKeyToTime;

		// @param capacity, an integer
		public Solution(int capacity) {
			// write your code here
			map = new HashMap<>();
			this.capacity = capacity;
			treeMap = new TreeMap<>();
			mapKeyToTime = new HashMap<>();
		}

		// @return an integer
		public int get(int key) {
			// write your code here
			if (map.containsKey(key)) {
				time++;
				Long t = mapKeyToTime.get(key);
				treeMap.remove(t);
				treeMap.put(time, key);
				mapKeyToTime.put(key, time);
				return map.get(key);
			} else {
				return -1;
			}
		}

		// @param key, an integer
		// @param value, an integer
		// @return nothing
		public void set(int key, int value) {
			// write your code here
			time++;
			if (map.containsKey(key)) {
				long t = mapKeyToTime.get(key);
				treeMap.remove(t);
				treeMap.put(time, key);
				mapKeyToTime.put(key, time);
				map.put(key, value);
			} else {
				if (size == capacity) {
					Long t = treeMap.firstKey();
					// System.out.println("time :" +t);
					int k = treeMap.get(t);
					treeMap.remove(t);
					map.remove(k);
					mapKeyToTime.remove(k);
					mapKeyToTime.put(key, time);
					treeMap.put(time, key);
					map.put(key, value);
				} else {
					treeMap.put(time, key);
					mapKeyToTime.put(key, time);
					map.put(key, value);
					size++;
				}
				// System.out.println(map);
			}
		}
	}

	public class LRUCache2 {

		class DLinkedNode {
			int key;
			int value;
			DLinkedNode pre;
			DLinkedNode post;
		}

		/**
		 * Always add the new node right after head;
		 */
		private void addNode(DLinkedNode node) {
			node.pre = head;
			node.post = head.post;

			head.post.pre = node;
			head.post = node;
		}

		/**
		 * Remove an existing node from the linked list.
		 */
		private void removeNode(DLinkedNode node) {
			DLinkedNode pre = node.pre;
			DLinkedNode post = node.post;

			pre.post = post;
			post.pre = pre;
		}

		/**
		 * Move certain node in between to the head.
		 */
		private void moveToHead(DLinkedNode node) {
			this.removeNode(node);
			this.addNode(node);
		}

		// pop the current tail.
		private DLinkedNode popTail() {
			DLinkedNode res = tail.pre;
			this.removeNode(res);
			return res;
		}

		private HashMap<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
		private int count;
		private int capacity;
		private DLinkedNode head, tail;

		public LRUCache2(int capacity) {
			this.count = 0;
			this.capacity = capacity;

			head = new DLinkedNode();
			head.pre = null;

			tail = new DLinkedNode();
			tail.post = null;

			head.post = tail;
			tail.pre = head;
		}

		public int get(int key) {

			DLinkedNode node = cache.get(key);
			if (node == null) {
				return -1; // should raise exception here.
			}

			// move the accessed node to the head;
			this.moveToHead(node);

			return node.value;
		}

		public void set(int key, int value) {
			DLinkedNode node = cache.get(key);

			if (node == null) {

				DLinkedNode newNode = new DLinkedNode();
				newNode.key = key;
				newNode.value = value;

				this.cache.put(key, newNode);
				this.addNode(newNode);

				++count;

				if (count > capacity) {
					// pop the tail
					DLinkedNode tail = this.popTail();
					this.cache.remove(tail.key);
					--count;
				}
			} else {
				// update the value.
				node.value = value;
				this.moveToHead(node);
			}

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution t = new LRUCache().new Solution(2);
		t.set(2, 1);
		t.set(1, 1);
		System.out.println(t.get(2));
		t.set(4, 1);
		System.out.println(t.get(1));
		System.out.println(t.get(2));
	}

}
