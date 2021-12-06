package HashMap_;

import java.util.HashMap;
import java.util.Map;

public class isAlienSortedoff034 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> dict = new HashMap<>();
        for(int i=0;i<order.length();i++){
            dict.put(order.charAt(i),i);
        }
        for(int i=0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int len1 = s1.length(),len2 = s2.length();
            int index1 = 0,index2 = 0;
            for(int j = 0;j<Math.min(len1,len2);j++){
                index1 = dict.get(s1.charAt(j));
                index2 = dict.get(s2.charAt(j));
                if(index1>index2)
                    return false;
                else if(index1<index2)
                    break;
            }
            if(len1>len2&&index1==index2)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        isAlienSortedoff034 ia = new isAlienSortedoff034();
        System.out.println(ia.isAlienSorted(words,order));
    }
}
