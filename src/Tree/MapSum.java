package Tree;

import java.util.HashMap;
import java.util.Map;

//off066
public class MapSum {
    class Trienode{
        int val = 0;
        boolean isEnd = false;
        Trienode[] child = new Trienode[26];
    }
    Map<String,Integer> treemap;
    Trienode root;
    public int ans = 0;
    /** Initialize your data structure here. */
    public MapSum() {
        treemap = new HashMap<>();
        root = new Trienode();
    }

    public void insert(String key, int val) {
        Trienode node = root;
        for (char c:key.toCharArray()){
            int index = c - 'a';
            if(node.child[index]==null){
                node.child[index] = new Trienode();
            }
            node = node.child[index];
        }
        node.val = val;//把值存在结尾
        node.isEnd = true;
        treemap.put(key,val);
//        root.insert(root,key);
    }

    public int sum(String prefix) {
        Trienode node = searchPre(root,prefix);
        ans = 0;
        if(node!=null){
            dfs(node);
        }
        return ans;

    }
    public Trienode searchPre(Trienode root,String s){
        char[] words = s.toCharArray();
        Trienode node = root;
        for (char c : words){
            if(node.child[c-'a']==null){
                return null;
            }
            node = node.child[c-'a'];
        }
        return node;//返回的是前缀数中搜到的字符串的尾节点
    }
    public void dfs(Trienode root){
        Trienode node = root;
        if(node.isEnd){
            ans += node.val;
        }
        for(int i=0;i<26;i++){
            if(node.child[i]!=null){
                dfs(node.child[i]);
            }
        }

    }

}
