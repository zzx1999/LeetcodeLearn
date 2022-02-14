package Tree;

public class TrieNode {
    TrieNode[] child;
    boolean isEnd;
    public TrieNode(){
        child = new TrieNode[26];
        isEnd = false;

    }
    public void insert(TrieNode root,String word){
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(int i=0;i<chars.length;i++){
            int index = chars[i]-'a';
            if(node.child[index]==null){
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }
    //查询是否存在传入字符的前缀-dfs
    public boolean search(TrieNode root,String s){
        TrieNode node = root;
        for(char c:s.toCharArray()){
            if(node.isEnd==true) break;
            if(node.child[c-'a']==null){
                return false;
            }
            node = node.child[c-'a'];

        }
        return true;
    }
}
