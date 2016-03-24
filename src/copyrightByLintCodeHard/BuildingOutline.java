/**
 * 2016年3月1日
 * Poirot
 * 上午9:10:52
 * LintCode
 */
package copyrightByLintCodeHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Poirot
 *
 */
public class BuildingOutline {
	// public class Building {
	// int left;
	// int right;
	// int height;
	// public Building(int left, int right, int height) {
	// this.left = left;
	// this.right = right;
	// this.height = height;
	// }
	// }
	//
	// public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
	// // write your code here
	//// ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	// if (buildings.length <= 0) {
	// return new ArrayList<>();
	// }
	//
	// ArrayList<Building> res = new ArrayList<>();
	// LinkedList<Building> remainBuildings = new LinkedList<>();
	// for (int i = 0; i < buildings.length; i++) {
	// remainBuildings.offer(new Building(buildings[i][0], buildings[i][1],
	// buildings[i][2]));
	// }
	// Collections.sort(remainBuildings, new Comparator<Building>() {
	// @Override
	// public int compare(Building o1, Building o2) {
	// // TODO Auto-generated method stub
	// if (o1.left > o2.left) {
	// return 1;
	// }
	// return -1;
	// }
	// });
	//
	// while (!remainBuildings.isEmpty()) {
	// Building first = remainBuildings.removeFirst();
	// boolean mark = true;
	//
	//// ArrayList<Building> toAdd = new ArrayList<>();
	// for (int i = 0; i < remainBuildings.size(); i++) {
	// Building building = remainBuildings.get(i);
	// if (first.right < building.left) {
	// break;
	// } else if (first.left > building.right) {
	// continue;
	// } else {
	// if (first.height == building.height) {
	// building.left = Math.min(first.left, building.left);
	// building.right = Math.max(first.right, building.right);
	// mark = false;
	// break;
	// }
	// if (first.height > building.height) {
	// if (first.left <= building.left && first.right >= building.right) {
	// building.left = first.left;
	// building.right = first.right;
	// building.height = first.height;
	// mark = false;
	// break;
	// } else if (first.left <= building.left) {
	// building.left = first.right;
	// } else if (first.right >= building.right){
	// building.right = first.left;
	// } else {
	// int temp = building.right;
	// building.right = first.left;
	// remainBuildings.add(i + 1, new Building(first.right, temp,
	// building.height));
	// i++;
	// }
	// } else {
	// swap(first, building);
	// if (first.left <= building.left && first.right >= building.right) {
	// building.left = first.left;
	// building.right = first.right;
	// building.height = first.height;
	// mark = false;
	// break;
	// } else if (first.left <= building.left) {
	// building.left = first.right;
	// } else if (first.right >= building.right){
	// building.right = first.left;
	// } else {
	// int temp = building.right;
	// building.right = first.left;
	// remainBuildings.add(i + 1,new Building(first.right, temp,
	// building.height));
	// i++;
	// }
	// }
	// }
	// }
	// if (mark) {
	// res.add(first);
	// }
	// }
	// Collections.sort(res, new Comparator<Building>() {
	//
	// @Override
	// public int compare(Building o1, Building o2) {
	// // TODO Auto-generated method stub
	// if (o1.left > o2.left) {
	// return 1;
	// }
	// return -1;
	// }
	// });
	// ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	// for (int j = 0; j < res.size(); j++) {
	// Building building = res.get(j);
	// ArrayList<Integer> list = new ArrayList<>();
	// list.add(building.left);
	// list.add(building.right);
	// list.add(building.height);
	// result.add(list);
	// }
	//
	// return result;
	// }
	//
	// public void swap(Building a, Building b){
	// int left = a.left;
	// int right = a.right;
	// int height = a.height;
	// a.left = b.left;
	// a.right = b.right;
	// a.height = b.height;
	// b.left = left;
	// b.right = right;
	// b.height = height;
	// }
	//

	// public class Building {
	// int left;
	// int right;
	// int height;
	// public Building(int left, int right, int height) {
	// this.left = left;
	// this.right = right;
	// this.height = height;
	// }
	// }
	//
	// public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
	// // write your code here
	//// ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	// if (buildings.length <= 0) {
	// return new ArrayList<>();
	// }
	// ArrayList<Building> res = new ArrayList<>();
	// ArrayList<Building> remainBuildings = new ArrayList<>();
	// for (int i = 0; i < buildings.length; i++) {
	// remainBuildings.add(new Building(buildings[i][0], buildings[i][1],
	// buildings[i][2]));
	// }
	//
	// for (int j = 0; j < remainBuildings.size(); j++) {
	// Building first = remainBuildings.get(j);
	// boolean mark = true;
	//
	// ArrayList<Building> toAdd = new ArrayList<>();
	// for (int i = j + 1; i < remainBuildings.size(); i++) {
	// Building building = remainBuildings.get(i);
	// if (first.right < building.left || first.left > building.right) {
	// continue;
	// } else {
	// if (first.height == building.height) {
	// building.left = Math.min(first.left, building.left);
	// building.right = Math.max(first.right, building.right);
	// mark = false;
	// break;
	// }
	// if (first.height > building.height) {
	// if (first.left <= building.left && first.right >= building.right) {
	// building.left = first.left;
	// building.right = first.right;
	// building.height = first.height;
	// mark = false;
	// break;
	// } else if (first.left <= building.left) {
	// building.left = first.right;
	// } else if (first.right >= building.right){
	// building.right = first.left;
	// } else {
	// int temp = building.right;
	// building.right = first.left;
	// toAdd.add(new Building(first.right, temp, building.height));
	// }
	// } else {
	// if (building.left <= first.left && building.right >= first.right) {
	// mark = false;
	// break;
	// } else if (building.left <= first.left) {
	// first.left = building.right;
	// } else if (building.right >= first.right){
	// first.right = building.left;
	// } else {
	// int temp = first.right;
	// first.right = building.left;
	// toAdd.add(new Building(building.right, temp, first.height));
	// }
	// }
	// }
	// }
	// remainBuildings.addAll(toAdd);
	// if (mark) {
	// res.add(first);
	// }
	// }
	// Collections.sort(res, new Comparator<Building>() {
	// @Override
	// public int compare(Building o1, Building o2) {
	// // TODO Auto-generated method stub
	// if (o1.left > o2.left) {
	// return 1;
	// }
	// return -1;
	// }
	// });
	// ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	// for (int j = 0; j < res.size(); j++) {
	// Building building = res.get(j);
	// ArrayList<Integer> list = new ArrayList<>();
	// list.add(building.left);
	// list.add(building.right);
	// list.add(building.height);
	// result.add(list);
	// }
	//
	// return result;
	// }

//	class HashHeap {
//		ArrayList<Integer> heap;
//		String mode;
//		int size_t;
//		HashMap<Integer, Node> hash;
//
//		class Node {
//			public Integer id;
//			public Integer num; 
//			Node(Integer first, Integer second) { 
//				this.id = first;
//				this.num = second;
//			}
//		}
//
//		public HashHeap(String mod) {
//			// TODO Auto-generated constructor stub
//			heap = new ArrayList<Integer>();
//			mode = mod;
//			hash = new HashMap<Integer, Node>();
//			size_t = 0;
//		}
//
//		public int peek() {
//			return heap.get(0);
//		} 
//		public int size() {
//			return size_t;
//		}
//
//		public Boolean isEmpty() {
//			return (heap.size() == 0);
//		}
//
//		int parent(int id) {
//			if (id == 0) {
//				return -1;
//			}
//			return (id - 1) / 2;
//		}
//
//		int lson(int id) {
//			return id * 2 + 1;
//		}
//
//		int rson(int id) {
//			return id * 2 + 2;
//		}
//
//		boolean comparesmall(int a, int b) {
//			if (a <= b) {
//				if (mode == "min")
//					return true;
//				else
//					return false;
//			} else {
//				if (mode == "min")
//					return false;
//				else
//					return true;
//			}
//
//		}
//
//		void swap(int idA, int idB) {
//			int valA = heap.get(idA);
//			int valB = heap.get(idB);
//
//			int numA = hash.get(valA).num;
//			int numB = hash.get(valB).num;
//
//			hash.put(valB, new Node(idA, numB));
//			hash.put(valA, new Node(idB, numA));
//			heap.set(idA, valB);
//			heap.set(idB, valA);
//		}
//
//		public Integer poll() {
//			size_t--;
//			Integer now = heap.get(0);
//			Node hashnow = hash.get(now);
//			if (hashnow.num == 1) {
//				swap(0, heap.size() - 1);
//				hash.remove(now);
//				heap.remove(heap.size() - 1);
//				if (heap.size() > 0) {
//					siftdown(0);
//				}
//			} else {
//				hash.put(now, new Node(0, hashnow.num - 1));
//			}
//			return now;
//		}
//
//		public void add(int now) {
//			size_t++;
//			if (hash.containsKey(now)) {
//				Node hashnow = hash.get(now);
//				hash.put(now, new Node(hashnow.id, hashnow.num + 1));
//			} else {
//				heap.add(now);
//				hash.put(now, new Node(heap.size() - 1, 1));
//			}
//
//			siftup(heap.size() - 1);
//		}
//
//		public void delete(int now) {
//			size_t--;
//			Node hashnow = hash.get(now);
//			int id = hashnow.id;
//			int num = hashnow.num;
//			if (hashnow.num == 1) {
//
//				swap(id, heap.size() - 1);
//				hash.remove(now);
//				heap.remove(heap.size() - 1);
//				if (heap.size() > id) {
//					siftup(id);
//					siftdown(id);
//				}
//			} else {
//				hash.put(now, new Node(id, num - 1));
//			}
//		}
//
//		private void siftup(int id) {
//			// TODO Auto-generated method stub
//			re
//		}
//
//		void siftdown(int id) {
//			while (lson(id) < heap.size()) {
//				int leftId = lson(id);
//				int rightId = rson(id);
//				int son;
//				if (rightId >= heap.size() || (comparesmall(heap.get(leftId), heap.get(rightId)) == true)) {
//					son = leftId;
//				} else {
//					son = rightId;
//				}
//				if (comparesmall(heap.get(id), heap.get(son)) == true) {
//					break;
//				} else {
//					swap(id, son);
//				}
//				id = son;
//			}
//		}
//	}
//
//	class Edge {
//		int pos;
//		int height;
//		boolean isStart;
//
//		public Edge(int pos, int height, boolean isStart) {
//			this.pos = pos;
//			this.height = height;
//			this.isStart = isStart;
//		}
//
//	}
//
//	class EdgeComparator implements Comparator<Edge> {
//		@Override
//		public int compare(Edge arg1, Edge arg2) {
//			Edge l1 = (Edge) arg1;
//			Edge l2 = (Edge) arg2;
//			if (l1.pos != l2.pos)
//				return compareInteger(l1.pos, l2.pos);
//			if (l1.isStart && l2.isStart) {
//				return compareInteger(l2.height, l1.height);
//			}
//			if (!l1.isStart && !l2.isStart) {
//				return compareInteger(l1.height, l2.height);
//			}
//			return l1.isStart ? -1 : 1;
//		}
//
//		int compareInteger(int a, int b) {
//			return a <= b ? -1 : 1;
//		}
//
//	}
//
//	ArrayList<ArrayList<Integer>> output(ArrayList<ArrayList<Integer>> res) {
//		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
//		if (res.size() > 0) {
//			int pre = res.get(0).get(0);
//			int height = res.get(0).get(1);
//			for (int i = 1; i < res.size(); i++) {
//				ArrayList<Integer> now = new ArrayList<Integer>();
//				int id = res.get(i).get(0);
//				if (height > 0) {
//					now.add(pre);
//					now.add(id);
//					now.add(height);
//					ans.add(now);
//				}
//				pre = id;
//				height = res.get(i).get(1);
//			}
//		}
//		return ans;
//	}
//
//	public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
//		// write your code here
//		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//
//		if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
//			return res;
//		}
//		ArrayList<Edge> edges = new ArrayList<Edge>();
//		for (int[] building : buildings) {
//			Edge startEdge = new Edge(building[0], building[2], true);
//			edges.add(startEdge);
//			Edge endEdge = new Edge(building[1], building[2], false);
//			edges.add(endEdge);
//		}
//		Collections.sort(edges, new EdgeComparator());
//
//		HashHeap heap = new HashHeap("max");
//
//		ArrayList<Integer> now = null;
//		for (Edge edge : edges) {
//			if (edge.isStart) {
//				if (heap.isEmpty() || edge.height > heap.peek()) {
//					now = new ArrayList<Integer>(Arrays.asList(edge.pos, edge.height));
//					res.add(now);
//				}
//				heap.add(edge.height);
//			} else {
//				heap.delete(edge.height);
//				if (heap.isEmpty() || edge.height > heap.peek()) {
//					if (heap.isEmpty()) {
//						now = new ArrayList<Integer>(Arrays.asList(edge.pos, 0));
//					} else {
//						now = new ArrayList<Integer>(Arrays.asList(edge.pos, heap.peek()));
//					}
//					res.add(now);
//				}
//			}
//		}
//		return output(res);
//	}

	public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
		List<int[]> candidates = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				// TODO Auto-generated method stub
				if(a[0] != b[0]) 
                    return a[0] - b[0];
                return a[1] - b[1];
			}
		});
        
//        Collections.sort(height, (a, b) -> {
//                if(a[0] != b[0]) 
//                    return a[0] - b[0];
//                return a[1] - b[1];
//        });
//        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); // 最堆
         
//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer a, Integer b) {
//				// TODO Auto-generated method stub
//				return b - a;
//			}
//		}); // 最堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(1, new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return b - a;
			}
		});
        
        pq.offer(0);
        int prev = 0;
        for(int[] h:height) {
        	 
            if(h[1] < 0) {
                pq.offer(-h[1]); 
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
//            System.out.println(cur);
            if(prev != cur) { 
            	if (!candidates.isEmpty() && candidates.get(candidates.size() - 1)[2] != 0) {
            		candidates.get(candidates.size() - 1)[1] = h[0];
            	}  
//            	result.get(result.size() - 1)[1] = h[0];
                candidates.add(new int[]{h[0], 0, cur});
                prev = cur;
            }
        }
//        return result;
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < candidates.size(); i++) {
        	if (candidates.get(i)[2] == 0) {
        		continue;
        	}
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = 0; j < candidates.get(i).length; j++) {
				temp.add(candidates.get(i)[j]);
			}
			resultList.add(temp);
		}
        return resultList;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuildingOutline t = new BuildingOutline();
		int[][] buildings = { { 1, 3, 3 }, { 2, 4, 4 }, { 5, 6, 1 } };
		// int[][] buildings = {{1,10,3}, {2,5,8},{7,9,8}};
		System.out.println(t.buildingOutline(buildings));
	}

}
