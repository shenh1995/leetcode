package Algorithm;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class L114 {
/*
 * 解题思路：
 * 对于根节点来说，它的下一个节点在左子节点存在的情况下，就是它的左子节点。所以在变换中会将它的右指针
 * 指向它的左子节点。在原来的过程中，将左子节点遍历完之后才会去遍历它的右子节点。所以在左子树中最后遍历
 * 的那个节点是它左子节点最右下角的那个节点。
 * 这样，可以概括出这样的一个过程。每次根据一个节点，找它左子节点的最右下角的元素。如果有，将这个元素的
 * right指向根节点的右子节点。然后根节点的right指向它的左子节点。再指向它的下一个位置，也就是它的right
 * 节点。
 */
 public void flatten(TreeNode root) {
          while(root != null) {
           if(root.left != null) {
            TreeNode ptr = root.left;
            while(ptr.right != null)
             ptr = ptr.right;
            ptr.right = root.right;
            root.right = root.left;
            root.left = null;
           }
           root = root.right;
          }
  }
}
