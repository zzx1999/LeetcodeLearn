package dp;

import java.util.Arrays;

public class lengthOfLongestSubstringoff48 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0)
            return 0;
        int[] dp = new int[n];//以s[i]结尾的最长不重复子串长度
        dp[0] = 1;
        for(int i=1;i<n;i++){
            char cur = s.charAt(i);
            int j = i-1;
            for(j = i-1;j>=0;j--){//找左边界——这个过程可以使用哈希表，用哈希表存储字符最近一次出现的索引
                if(s.charAt(j)==cur){
                    break;
                }
            }
            if(j<0)
                dp[i] = dp[i-1] + 1;
            if(dp[i-1]<i-j)
                dp[i] = dp[i-1]+1;
            else
                dp[i] = i-j;
        }
        Arrays.sort(dp);
        return dp[n-1];
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        lengthOfLongestSubstringoff48 lolss = new lengthOfLongestSubstringoff48();
        System.out.println(lolss.lengthOfLongestSubstring(s));
    }
}
