package String_off;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstringoff016 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0)
            return 0;
//        char[] sarr = s.toCharArray();
        Map<Character,Integer> cnt = new HashMap<>();
        int l = 0,r = 0,len = 0,max = Integer.MIN_VALUE;
        while (r<n){
            if(cnt.getOrDefault(s.charAt(r),0)==0){
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
                len++;
            }
            else{//有重复的
                cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l),0)-1);
                l++;
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
                max = Math.max(max,len);
                len = r-l+1;
            }
            r++;
        }

        return max>len?max:len;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        lengthOfLongestSubstringoff016 los = new lengthOfLongestSubstringoff016();
        System.out.println(los.lengthOfLongestSubstring(s));
    }
}
