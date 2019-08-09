package pkg;
/**
 * ����һ�������������������ֱ�������������ڵ���Զ��·�����ȣ�
 * 
 * */

public class LC543_DiameterOfBinaryTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int max=0;
	public int dg(TreeNode root) {
		if(root==null) {
			return 0;
		}else {
			int l = this.dg(root.left);
			int r = this.dg(root.right);
			if(r+l>this.max) {
				this.max = r+l;
			}
	        return l>r?l+1:r+1;
		}
	}
	
	public int diameterOfBinaryTree(TreeNode root) {
		this.dg(root);
		return this.max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}