package Tree;

public class FlattenTree {
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        //��������������Ϊ������
        root.right = left;
        TreeNode temp = root;
        //�ҵ���������ĩ��
        while (temp.right!=null){
            temp = temp.right;
        }
        //ԭ�����������ӵ��������·�
        temp.right = right;
        return;
    }
}
