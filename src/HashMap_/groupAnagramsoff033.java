package HashMap_;

import java.util.*;

public class groupAnagramsoff033 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //变位词判断-排序完是一样的
        Map<String,List<String>> anagmap = new HashMap<>();
        List<List<String>> res = new LinkedList<>();
        for(String s : strs){
            char[] srr = s.toCharArray();
            Arrays.sort(srr);
            String tmp = String.valueOf(srr);
            if(tmp.length()==0){
                res.add(new ArrayList<>());
                continue;
            }
            if(anagmap.containsKey(tmp)){
                if(!anagmap.get(tmp).contains(s))
                    anagmap.get(tmp).add(s);
            }
            else{
                List<String> list = new LinkedList<>();
                list.add(s);
                anagmap.put(tmp,list);
            }

        }
        for(Map.Entry entry:anagmap.entrySet()){
            res.add((List<String>) entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str = {"",""};
        groupAnagramsoff033 gA = new groupAnagramsoff033();
        gA.groupAnagrams(str);
    }
}
