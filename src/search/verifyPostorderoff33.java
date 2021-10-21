package search;

public class verifyPostorderoff33 {
    public boolean verifyPostorder(int[] postorder) {
        return Myverify(postorder,0,postorder.length-1);

    }
    //二叉搜索树后序遍历:[ 左子树 | 右子树 | 根节点 ] ,最后一个一定是某子树根节点
    //那么只有从左往右找到第一个大于根节点的值,作为左右子树分界线
    //检查左子树是否都小于根节点的值
    //检查右子树是否都大于根节点的值
    //再递归检查左右子树
    public boolean Myverify(int[] postorder,int l,int r){
        if(r<=l)
            return true;
        int rootval = postorder[r];
        int i = l;
        for (i=l;i<=r;i++){
            if(postorder[i]>=rootval)
                break;
        }
        int m = i;
        boolean check = true;
        for(i = m;i<r;i++){
            if (postorder[i]<rootval)
                check = false;
        }
//        int i = l;
//        while (postorder[i]<rootval) i++;
//        int m = i;
//        while (postorder[i]>rootval) i++;
        return check&&Myverify(postorder,l,m-1)&&Myverify(postorder,m,r-1);
    }

    public static void main(String[] args) {
        int[] postorder = {4,6,7,5};
        verifyPostorderoff33 vp = new verifyPostorderoff33();
        System.out.println(vp.verifyPostorder(postorder));
    }
}
