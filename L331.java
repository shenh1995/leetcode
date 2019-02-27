package Algorithm;
/*
 * 一个可以恢复二叉树的字符串=根结点+左子树的字串+右子树的字串
 */
public class L331 {

	class pointer {
		int val = 0;
	}
	
	public boolean helper(String [] pre, pointer p) {
		if(p.val > pre.length - 1) return false;
		//遇到空节点就返回，代表子树结束
		if(pre[p.val].equals("#")) {
			p.val ++;
			return true;
		}else {
			p.val ++;
			//&&的顺序是先第一个helper，然后才是后面那个helper，第一个helper是左子树递归，第二个是右子树递归。
			return helper(pre, p) && helper(pre, p);
		}
	}
	
	public boolean isValidSerialization(String preorder) {
		if(preorder == null) return false;
		String [] pre = preorder.split(",");
		pointer p = new pointer();
		//看最后的p.val是不是为pre.length
		return helper(pre, p) && p.val == pre.length;
	}
}
