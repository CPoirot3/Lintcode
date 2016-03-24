/**
 * 2016年3月2日
 * Poirot
 * 下午10:19:45
 * LintCode
 */
package copyrightByLintCodeHard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet; 
 

/**
 * @author Poirot
 *
 */
public class CountofSmallerNumberbeforeitself {
	public class RedBlackTreeNode {
		boolean color;
		int key;
		int size;
		RedBlackTreeNode left;
		RedBlackTreeNode right;
		RedBlackTreeNode parent;
		
		public RedBlackTreeNode(int key, int size) {
			// TODO Auto-generated constructor stub
			this.key = key;
			this.color = RedBlackTree.BLACK;
			this.size = size;
		}
	}
	public RedBlackTreeNode NIL = new RedBlackTreeNode(0,0);
	
	
	public class RedBlackTree {
		RedBlackTreeNode root;
		public static final boolean BLACK = true;
		public static final boolean RED = false;
		
		public RedBlackTree() {
			root = NIL;
		}

		public void leftRotate(RedBlackTreeNode x) { // 左旋
			RedBlackTreeNode y = x.right;
			x.right = y.left;
			if (y.left != NIL) {
				y.left.parent = x;
			}
			y.parent = x.parent;

			if (x.parent == NIL) {
				root = y;
			} else if (x == x.parent.left) {
				x.parent.left = y;
			} else {
				x.parent.right = y;
			}
			y.left = x;			
			x.parent = y;
			y.size = x.size;
			x.size = x.left.size + x.right.size + 1;
		}

		public void rightRotate(RedBlackTreeNode y) {// 右旋
			RedBlackTreeNode x = y.left;
			y.left = x.right;
			if (x.right != NIL) {
				x.right.parent = y;
			}
			x.parent = y.parent;
			if (y.parent == NIL) {
				root = x;
			} else if (y == y.parent.left) {
				y.parent.left = x;
			} else {
				y.parent.right = x;
			}
			y.parent = x;
			x.right = y;
			x.size = y.size;
			y.size = x.left.size + x.right.size + 1;
		}

		public void insert(RedBlackTreeNode z) { // 插入，插入后使用redBlackInsertFixup(z)来修改受影响的结点
			RedBlackTreeNode y = NIL;
			RedBlackTreeNode x = root;
			while (x != NIL) {
				x.size ++;  //维护子树规模
				y = x;
				if (z.key < x.key) {
					x = x.left;
				} else {
					x = x.right;
				}
			}
			z.parent = y;
			if (y == NIL) {
				root = z;
			} else if (z.key < y.key) {
				y.left = z;
			} else {
				y.right = z;
			}
			z.left = NIL;
			z.right = NIL;
			redBlackInsertFixup(z);
		}

		public void redBlackInsertFixup(RedBlackTreeNode z) { // 修改受影响的结点
			while (z.parent.color == RED) {
				if (z.parent == z.parent.parent.left) {
					RedBlackTreeNode y = z.parent.parent.right;
					if (y.color == RED) {
						z.parent.color = BLACK;
						y.color = BLACK;
						z.parent.parent.color = RED;
						z = z.parent.parent;
					} else if (z == z.parent.right) {
						z = z.parent;
						leftRotate(z);
					} else {
						z.parent.color = BLACK;
						z.parent.parent.color = RED;
						rightRotate(z.parent.parent);
					}
				} else {
					RedBlackTreeNode y = z.parent.parent.left;
					if (y.color == RED) {
						z.parent.color = BLACK;
						y.color = BLACK;
						z.parent.parent.color = RED;
						z = z.parent.parent;
					} else if (z == z.parent.left) {
						z = z.parent;
						rightRotate(z);
					} else {
						z.parent.color = BLACK;
						z.parent.parent.color = RED;
						leftRotate(z.parent.parent);
					}
				}
			}
			root.color = BLACK;
		}

		public RedBlackTreeNode find(int key) {
			if (root == NIL) {
				return null;
			}
			RedBlackTreeNode temp = root;
			while (temp != NIL) {
				if (key < temp.key) {
					temp = temp.left;
				} else if (key > temp.key) {
					temp = temp.right;
				} else {
					return temp;
				}
			}
			return null;
		}

		public void redBlackTransplant(RedBlackTreeNode u, RedBlackTreeNode v) {
			if (u.parent == NIL) {
				root = v;
			} else if (u == u.parent.left) {
				u.parent.left = v;
			} else {
				u.parent.right = v;
			}
			v.parent = u.parent;
		}

		public void redBlackDelete(RedBlackTreeNode z) {
			RedBlackTreeNode y = z;
			RedBlackTreeNode x;
			boolean yOriginalColor = y.color;
			if (z.left == NIL) {
				x = z.right;
				redBlackTransplant(z, z.right);
			} else if (z.right == NIL) {
				x = z.left;
				redBlackTransplant(z, z.left);
			} else {
				y = treeMinimum(z.right);
				yOriginalColor = y.color;
				x = y.right;
				if (y.parent == z) {
					x.parent = y;
				} else {
					redBlackTransplant(y, y.right);
					y.right = z.right;
					y.right.parent = y;
				}
				redBlackTransplant(z, y);
				y.left = z.left;
				y.left.parent = y;
				y.color = z.color;
			}

			if (yOriginalColor == BLACK) {
				redBlackDeleteFixup(x);
			}
		}

		public RedBlackTreeNode treeMinimum(RedBlackTreeNode node) {
			RedBlackTreeNode temp = node;
			while (temp.left != NIL) {
				temp = temp.left;
			}
			return temp;
		}

		public void redBlackDeleteFixup(RedBlackTreeNode x) {
			while (x != root && x.color == BLACK) {
				if (x == x.parent.left) {
					RedBlackTreeNode w = x.parent.right;
					if (w.color == RED) {
						w.color = BLACK;
						x.parent.color = RED;
						leftRotate(x.parent);
						w = x.parent.right;
					}
					if (w.left.color == BLACK && w.right.color == BLACK) {
						w.color = RED;
						x = x.parent;
					} else if (w.right.color == BLACK) {
						w.left.color = BLACK;
						w.color = RED;
						rightRotate(w);
						w = x.parent.right;
					} else {
						w.color = x.parent.color;
						x.parent.color = BLACK;
						leftRotate(x.parent);
						x = root;
					}
				} else {
					RedBlackTreeNode w = x.parent.left;
					if (w.color == RED) {
						w.color = BLACK;
						x.parent.color = RED;
						rightRotate(x.parent);
						w = x.parent.left;
					}
					if (w.right.color == BLACK && w.left.color == BLACK) {
						w.color = RED;
						x = x.parent;
					} else if (w.left.color == BLACK) {
						w.right.color = BLACK;
						w.color = RED;
						leftRotate(w);
						w = x.parent.left;
					} else {
						w.color = x.parent.color;
						x.parent.color = BLACK;
						rightRotate(x.parent);
						x = root;
					}
				}
			}
		}

		public RedBlackTreeNode osSelect(RedBlackTreeNode node, int i) {
			if (node.size < i) {
				return null;
			}
			int r = node.left.size + 1;
			if (i == r) {
				return node;
			} else if (i < r) {
				return osSelect(node.left, i);
			} else {
				return osSelect(node.right, i - r);
			}
		}
		
		public int osRank(RedBlackTreeNode node , RedBlackTreeNode x) { //查找x的秩，即x在中序遍历中的位置
			int r = 1;
			if (x.left != NIL) {
				r = x.left.size + 1;
			}
			
			RedBlackTreeNode y = x;
			while (y != root) {
				if (y == y.parent.right) {
					r = r + y.parent.left.size + 1;
				}
				y = y.parent;
			}
			return r;
		}
		
		// 遍历
		public ArrayList<Integer> inorderTravel(RedBlackTreeNode root) {
			if (root == NIL) {
				return new ArrayList<>();
			}
			ArrayList<Integer> left = inorderTravel(root.left);
			left.add(root.key); 
			left.addAll(inorderTravel(root.right));
			return left;
		}
	} 
	
//    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
//        // write your code here
//    	if (A.length == 0) {
//			return new ArrayList<>();
//		}
//    	ArrayList<Integer> res = new ArrayList<>();
//		RedBlackTree redBlackTree = new RedBlackTree();
//		for (int i = 0; i < A.length; i++) {
//			redBlackTree.insert(new RedBlackTreeNode(A[i], 1));
// 
//			int num = redBlackTree.osRank(redBlackTree.root, redBlackTree.find(A[i]));
//			res.add(num - 1);
//		}
//		return res;
//    }
    
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
    	if (A.length == 0) {
			return new ArrayList<>();
		}
    	ArrayList<Integer> res = new ArrayList<>();
    	 
		return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
