package pkg;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * */
public class ConvertBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int recursion(TreeNode cur,int fa){
        return cur==null?fa:recursion(cur.left,cur.val = cur.val + recursion(cur.right,fa));
	}
	
	public TreeNode convertBST(TreeNode root) {
		recursion(root,0);
        return root;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertBST test = new ConvertBST();
		TreeNode t1 = test.new TreeNode(5);
		TreeNode t2 = test.new TreeNode(2);
		TreeNode t3 = test.new TreeNode(13);
		t1.left = t2;t1.right = t3;
		test.convertBST(t1);
		System.out.println(t1.val);
		System.out.println(t2.val);
		System.out.println(t3.val);
	}

}
