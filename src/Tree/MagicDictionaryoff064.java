package Tree;

public class MagicDictionaryoff064 {
    TrieNode root;
    boolean issame;//记录前面遍历的是不是一样
    /** Initialize your data structure here. */
    public MagicDictionaryoff064() {
        root = new TrieNode();
        issame = true;
    }

    public void buildDict(String[] dictionary) {
        for(String s:dictionary){//构造前缀树
            root.insert(root,s);
        }
    }

    public boolean search(String searchWord) {
        return dfs(root,searchWord,0,0);
    }
    public boolean dfs(TrieNode root,String s,int i,int isedit){
        if(root==null)
            return false;
        if(root.isEnd&&i==s.length()&&isedit==1){//刚好达到末尾前node处于更节点且只修改了一次
            return true;
        }
        if(i<s.length()&&isedit<=1){
            boolean found = false;
            for(int j=0;j<26&&!found;j++){//遍历当前节点的所有子节点，子节点存在edit不变否则+1
                int next = (j==s.charAt(i)-'a')?isedit:isedit+1;
                found = dfs(root.child[j],s,i+1,next);//沿着这个子节点往下走
            }
            return found;
        }
        return false;
    }
}
