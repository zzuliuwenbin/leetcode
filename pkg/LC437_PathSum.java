package pkg;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * */
public class LC437_PathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public int num = 0;
	public int sum = 0;
	
	//计算从node节点开始往下累加的和
	public void sum(TreeNode node, int fa) {
		if(node==null) {//
			return;
		}else {
			//累加本节点的值，并检测
			if(fa+node.val==sum) {
				num++;
			}
			sum(node.left,fa+node.val);
			sum(node.right,fa+node.val);
		}
	}
	
	public void dg(TreeNode node) {
		if(node==null) {
			return;
		}else {
			sum(node,0);//从本节点开始往下累加
			dg(node.left);
			dg(node.right);
		}
		return;
	}
	public int pathSum(TreeNode root, int sum) {
		this.sum = sum;
		this.dg(root);
		return this.num;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
