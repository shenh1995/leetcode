package Algorithm;

import java.util.Arrays;
import java.util.List;

public class L315 {
	
	class Node{
		int val;
		int sum; //从数组的最后到当前访问节点时，在当前节点左边，且小于当前节点的个数，这个下面会解释。
		int dup; //此val的个数 [1,1,2,3] ,1的dup为2，2的dup为1, 默认为1
		Node left;
		Node right;
		public Node(int val, int sum) {
			this.val = val;
			this.sum = sum;
			this.dup = 1;
		}
	}
	
	public List<Integer> countSmaller(int[] nums) {
		Node root = null;
		Integer [] arr = new Integer[nums.length];
		for(int i = nums.length - 1; i >= 0; i --) {
			root = helper(root, nums[i], i, arr, 0);
		}
		return (List<Integer>) Arrays.asList(arr);
	}

	public Node helper(Node root, int num, int i, Integer [] arr, int preSum) {
		if(root == null) {
			root = new Node(num, 0);
			arr[i] = preSum; 
		}else if (root.val == num) {
			root.dup ++; 
			arr[i] = preSum + root.sum;
		}else if (root.val < num) {
			root.right = helper(root.right, num, i, arr, root.dup + root.sum + preSum);
		}else {
			root.sum ++;
			root.left = helper(root.left, num, i, arr, preSum);
		}
		return root;
	}
	
}
