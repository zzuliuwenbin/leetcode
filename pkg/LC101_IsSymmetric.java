package pkg;

/**
 * ����һ����������������Ƿ��Ǿ���ԳƵġ�
 * ˼·���������ߵݹ飬��root��ʼ���������������father��left��right���;�������������father��right��left��
 * ���������������ͬ���Ǿ�������������
 * */
public class LC101_IsSymmetric {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	//�������ɾ������������������ȵģ������������������������Һ������������������Һ�����������������������
	//�߽�����������һ��Ϊ��������ֱ�ӵó�����
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
