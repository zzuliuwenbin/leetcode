package pkg;

public class InvertTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	//�������������Ҳ���ԣ���ֱ�ӷ�ת���ӽڵ�
	public TreeNode invertTree(TreeNode root) {
		if(root!=null) {
			//�������Һ���
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
