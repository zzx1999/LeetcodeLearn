package String_off;

import java.util.HashMap;
import java.util.Map;

public class checkInclusioff014 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int l = 0,r = n-1;
        int[] s2nums = new int[26];//s2滑动窗口内各个字符出现的次数
        int[] s1nums = new int[26];//s1各个字符出现的次数
        int diff = 0;//不同字符个数
        for(int i=l;i<=r;i++){
            s1nums[s1.charAt(i)-'a']++;
            s2nums[s2.charAt(i)-'a']++;
        }
        //统计该次滑动不同字符个数
        for(int i=0;i<26;i++){
            if(s1nums[i]!=s2nums[i])
                diff += (Math.abs(s2nums[i]-s1nums[i]));
        }
        while (r<m-1){
            if(diff==0)
                return true;
            char x = s2.charAt(l);//删除的字符
            l++;
            r++;
            char y = s2.charAt(r);//新加的字符
            if(s1nums[x-'a']==s2nums[x-'a']) diff++;//修改之前如果发生变动的字母原来就相等那么其中一个被删了之后不同的增加了
            if(s1nums[y-'a']==s2nums[y-'a']) diff++;
            s2nums[s2.charAt(r)-'a']++;
            s2nums[s2.charAt(l-1)-'a']--;
            if(s1nums[x-'a']==s2nums[x-'a']) diff--;
            if(s1nums[y-'a']==s2nums[y-'a']) diff--;
        }
        return diff==0;
    }

    public static void main(String[] args) {
        String s1 = "ab",s2 = "eidbaooo";
        checkInclusioff014 ci = new checkInclusioff014();
        System.out.println(ci.checkInclusion(s1,s2));

    }
}
