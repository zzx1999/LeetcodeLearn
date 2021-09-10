package search;

import LinkedList.ListNode;

import java.util.*;

public class firstUniqCharoff50 {
    public char firstUniqChar(String s) {
        Map<Character,Integer> smap = new LinkedHashMap<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            smap.put(arr[i],smap.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Character,Integer> entry:smap.entrySet()){
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return ' ';
    }
}
