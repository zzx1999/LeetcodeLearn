package String_off;

import java.util.HashMap;
import java.util.Map;

public class minWindowoff017 {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n<m)
            return "";
        Map<Character,Integer> cntmap = new HashMap<>();
        for(int i=0;i<m;i++){//先存t里面的字符
            cntmap.put(t.charAt(i),cntmap.getOrDefault(t.charAt(i),0)+1);
        }
        int count = cntmap.size();//字符种类数量
        int l = 0,r = 0;
        int minlen = Integer.MAX_VALUE,minl = 0,minr = 0;
        while (r<n){
            if(count > 0){
                char scur = s.charAt(r);
                if(cntmap.containsKey(scur)){
                    cntmap.put(scur,cntmap.get(scur)-1);
                    if(cntmap.get(scur)==0){//t中所有x字符都有了 count才--
                        count--;
                    }
                }
                r++;
            }
            else{//所有字符匹配完成
                if(r-l<minlen){
                    minlen = r-l;
                    minl = l;
                    minr = r;
                }
                char sl = s.charAt(l);
                if(cntmap.containsKey(sl)){//窗口滑动 窗口左边的字符如果不取就不包含t中某字符了那么count++
                    cntmap.put(sl,cntmap.get(sl)+1);
                    if(cntmap.get(sl)==1){
                        count++;
                    }
                }
                l++;
            }
        }
        return minlen<Integer.MAX_VALUE?s.substring(minl,minr):"";
    }
}
