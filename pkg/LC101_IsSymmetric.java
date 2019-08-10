package pkg;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 思路：迭代或者递归，从root开始，进行先序遍历（father，left，right）和镜像的先序遍历（father，right，left）
 * 遍历的序列如果相同则是镜像树，否则不是
 * */
public class LC101_IsSymmetric {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	//两颗树成镜像的条件，树根是相等的，且左树的左孩子树和右树的右孩子树镜像，且左树的右孩子树和右树的左孩子树镜像；
	//边界条件，至少一个为空树，可直接得出结论
	public boolean dg(TreeNode left,TreeNode right) {
		if(left==null&&right==null) {return true;}
		if(left==null||right==null) {return false;}
		return (left.val==right.val)&&dg(left.left,right.right)&&dg(left.right,right.left);
    }
	public boolean isSymmetric(TreeNode root) {
		return dg(root,root);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
