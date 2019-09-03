package pkg;

/**
 * ����һ��������������ÿ����㶼�����һ������ֵ��
 * �ҳ�·���͵��ڸ�����ֵ��·��������
 * ·������Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��
 * ������������1000���ڵ㣬�ҽڵ���ֵ��Χ�� [-1000000,1000000] ��������
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
	
	//�����node�ڵ㿪ʼ�����ۼӵĺ�
	public void sum(TreeNode node, int fa) {
		if(node==null) {//
			return;
		}else {
			//�ۼӱ��ڵ��ֵ�������
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
			sum(node,0);//�ӱ��ڵ㿪ʼ�����ۼ�
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
