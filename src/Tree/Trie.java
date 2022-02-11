package Tree;

public class Trie {
    Trie[] children;//指向子节点的指针数组 children。对于本题而言，数组长度为 262626，即小写英文字母的数量。此时 children[0]对应小写字母 a，children[1]对应小写字母 b，…，children[25]对应小写字母 z。
    boolean isEnd;//布尔字段 isEnd，表示该节点是否为字符串的结尾。
    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isEnd = false;

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for(int i=0;i<word.length();i++){
            char tmp = word.charAt(i);
            if(node.children[tmp-'a']==null){//子节点不存在。创建一个新的子节点，记录在 children 数组的对应位置上，然后沿着指针移动到子节点，继续搜索下一个字符。
                node.children[tmp-'a'] = new Trie();
            }
            node = node.children[tmp-'a'];//子节点存在。沿着指针移动到子节点，继续处理下一个字符。
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie t = seachPre(word);
        return t != null && t.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return seachPre(prefix)!=null;
    }
    public Trie seachPre(String prefix){
        Trie t = this;
        for(int i=0;i<prefix.length();i++){
            char tmp = prefix.charAt(i);
            if(t.children[tmp-'a']==null){
                return null;
            }
            t = t.children[tmp-'a'];
        }
        return t;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        obj.search("apple");
    }
}
