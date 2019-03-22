package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class L513 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	/*
	 * 此道题目利用层次遍历算法来解决，用result记录每层的第一个节点。
	 */
	public int findBottomLeftValue(TreeNode root) {
		if(root.right == null && root.left == null) 
			return root.val;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		int result = root.val;
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp == null) {
				if(queue.isEmpty()) 
					return result;
				else {
					result = queue.peek().val;
					queue.add(null);
				}
			}else {
				if(temp.left != null) 
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
			}
		}
		return result;
	} 
}
