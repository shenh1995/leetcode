package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class L95 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	

	public List<TreeNode> generateTrees(int n) {
		
		List<TreeNode> res = new ArrayList<L95.TreeNode>();
		
		if(n < 1)
			return res;
		
		return helper(1, n);	
	}
	
	public List<TreeNode> helper(int left, int right) {        
	List<TreeNode> res = new ArrayList<TreeNode>();
    if(left > right){
        res.add(null);
        return res;
    }
    
    for(int i = left; i<=right; i++){
        List<TreeNode> leftRes = helper(left,i-1);
        List<TreeNode> rightRes = helper(i+1, right);
        //从leftRes中挨个取结果，配合从rightRes中挨个取结果后分别放在以i为root的左右子树上
        for(int m = 0; m<leftRes.size(); m++){
            for(int n = 0; n<rightRes.size(); n++){
                TreeNode root = new TreeNode(i);
                root.left = leftRes.get(m);
                root.right = rightRes.get(n);
                res.add(root);
            }
        }
    }
    return res;
	}
}
