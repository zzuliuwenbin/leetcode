package pkg;

/**
 * 二叉树的最大深度
 * */
public class LC104_MaxDepth {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public int max = 0;
	public void depth(TreeNode root,int dp) {
		if(root==null) {
			return;
		}else {
			if(dp+1>max) {
				max = dp+1;
			}
			depth(root.left,dp+1);
			depth(root.right,dp+1);
		}
	}
	
	public int maxDepth(TreeNode root) {
        depth(root,0);
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
