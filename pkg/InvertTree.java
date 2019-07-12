package pkg;

public class InvertTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	//先序遍历（其它也可以），直接翻转孩子节点
	public TreeNode invertTree(TreeNode root) {
		if(root!=null) {
			//交换左右孩子
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			invertTree(root.left);
			invertTree(root.right);
		}
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
