package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class L109 {
	
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

	/*
	 * 递归循环，最好排除middle点处理，这样思路清晰。
		因为是排好序的链表，从中间取根节点能保证平衡二叉搜索树。
	 */
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) {
			return null;
		}
		
		List<TreeNode> treeNodeList = new ArrayList<L109.TreeNode>();
		
		while(head != null) {
			treeNodeList.add(new TreeNode(head.val));
			head = head.next;
		}
		
		return sortListToBSTHelper(treeNodeList, 0, treeNodeList.size() - 1);
	}
	
	public TreeNode sortListToBSTHelper(List<TreeNode> list, int from, int end) {
		if(end == from) 
			return list.get(end);
		else if (end < from) {
			return null;
		}
		int middle = from + (end - from) / 2;
		
		TreeNode leftTree = sortListToBSTHelper(list, from, middle - 1);
		TreeNode rightTree = sortListToBSTHelper(list, middle + 1, end);
		
		list.get(middle).left = leftTree;
		list.get(middle).right = rightTree;
		
		return list.get(middle);
	}
}
