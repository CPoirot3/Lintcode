/**
 * 2015Äê7ÔÂ12ÈÕ
 * CH
 */
package copyrightByLintCodeMedium;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author CH
 *
 */
public class TopologySort {
	class DirectedGraphNode {
		int label;
		ArrayList<DirectedGraphNode> neighbors;

		DirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<DirectedGraphNode>();
		}
	};

	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		// write your code here
		LinkedList<DirectedGraphNode> res = new LinkedList<>();
		while (graph.size() > 0) {
			for (int i = 0; i < graph.size(); i++) {
				DirectedGraphNode node = graph.get(i);
				if (node.neighbors.size() == 0) {
					res.addFirst(node);
					for (int j = 0; j < graph.size(); j++) {
						if (j != i) {
							graph.get(j).neighbors.remove(node);
						}
					}
					graph.remove(node);
					break;
				}
			}
		}
		return new ArrayList<DirectedGraphNode>(res);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
