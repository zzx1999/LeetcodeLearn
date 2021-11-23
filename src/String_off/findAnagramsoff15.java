package String_off;

import java.util.LinkedList;
import java.util.List;

public class findAnagramsoff15 {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[] cnt = new int[26];//计算s里滑动窗口内字符数目
        int diff = 0,l = 0, r = m-1;
        List<Integer> res = new LinkedList<>();
        for(int i=l;i<=r;i++){
            cnt[s.charAt(i)-'a']++;
            cnt[p.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            diff += cnt[i];
        }
        while (r<n){
            if(diff==0){
                res.add(l);
            }
            int x = s.charAt(l) - 'a';//删掉的
            l++;
            r++;
            if(r>n-1) break;
            int y = s.charAt(r) - 'a';//新增的
            if(cnt[x]==0) diff++;
            if(cnt[y]==0) diff++;//改之前
            cnt[x]--;
            cnt[y]++;
            if(cnt[x]==0) diff--;
            if(cnt[y]==0) diff--;
        }
        return res;

    }
}
