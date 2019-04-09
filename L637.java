package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L637 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			this.val = x;
		}
	}
	
	//相当于也是一个层次遍历
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<Double>();
		
		if(root == null)
			return result;
		
		if(root.left == null && root.right == null) {
			result.add(new Double(root.val));
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		
		double sum = 0;
		int count = 0;
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			
			if(temp == null) {
				if(queue.isEmpty()) {
					result.add(sum / count);
					break;
				}else {
					result.add(sum / count);
					count = 0;
					sum = 0;
					queue.add(null);
				}
			}else {
				sum += temp.val;
				count ++;
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
			}
		}
		return result;
	}
}
