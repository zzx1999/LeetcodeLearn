package Tree;

public class minimumLengthEncodingoff065 {
    int len = 0;
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        for(String word:words){
            root.insert(root,new StringBuffer(word).reverse().toString());
        }
        dfs(root,0);
        return len;
    }

    public void dfs(TrieNode node,int pathlen){
        if(node==null)
            return ;
        if(node.isEnd){//到达叶子节点才把这个路径和加到总和上面
            boolean haschild = false;
            for(int i=0;i<26;i++){
                if(node.child[i]!=null){
                    haschild = true;
                }
            }
            if(!haschild){
                pathlen++;
                len += pathlen;
            }

        }
        for(int i=0;i<26;i++){//回溯
            if(node.child[i]!=null){
                pathlen++;
                dfs(node.child[i],pathlen);
                pathlen--;
            }

        }
    }
}
