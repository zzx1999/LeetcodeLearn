package Tree;

import java.util.LinkedList;
import java.util.List;

public class replaceWordsoff063 {
    //使用前缀树
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        TrieNode root = new TrieNode();
        //构造前缀树
        for(String str:dictionary){
            root.insert(root,str);
        }
        for(int i=0;i<words.length;i++){
            if(root.search(root,words[i])){
                words[i] = replace(words[i],root);
            }
        }
        String res = "";
        for (String s : words){
            res += s;
            res += " ";
        }
        return res.substring(0,res.length()-1);

    }
    //把s替换为前缀树中的前缀
    public String replace(String s,TrieNode root){
        TrieNode node = root;
        String newword = "";
        for (char c:s.toCharArray()){
            if(node.isEnd||node.child[c-'a']==null) break;
            node = node.child[c-'a'];
            newword += c;
        }
        return newword;
    }
//    public String replaceWords_noTrie(List<String> dictionary, String sentence) {
//        String[] sentences = sentence.split(" ");
//        int n = sentences.length;
//        for(int i=0;i<n;i++){
//            String replace = sentences[i];
//            for(String ss:dictionary){
//                if(isPrefix(ss,sentences[i])&&replace.length()>ss.length()){
//                    replace = ss;
//                }
//            }
//            sentences[i] = replace;
//        }
//        String res = "";
//        for(String s : sentences){
//            res += s;
//            res += " ";
//        }
//        return res.substring(0,res.length()-1);
//    }
//    public boolean isPrefix(String s1,String s2){
//        if(s1.length()<s2.length()){
//            return false;
//        }
//        if(!s1.equals(s2.substring(0,s1.length()))){
//            return false;
//        }
////        int l1=0,l2=0;
////        while (l1<s1.length()){
////            if(s1.charAt(l1)==s2.charAt(l2)){
////                l1++;
////                l2++;
////            }
////            else
////                return false;
////        }
//        return true;
//    }

    public static void main(String[] args) {
        String sentences = "the cattle was rattled by the battery";
        List<String> dic = new LinkedList<>();
        dic.add("cat");
        dic.add("bat");
        dic.add("rat");
        replaceWordsoff063 rw = new replaceWordsoff063();
        System.out.println(rw.replaceWords(dic,sentences));
    }
}
