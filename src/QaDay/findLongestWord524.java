package QaDay;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findLongestWord524 {
    public String findLongestWord(String s, List<String> dictionary) {
        int maxlen = 0;
        String res = "";
        for(String ss:dictionary){
            if(charge(s,ss)&&maxlen<=ss.length()){
                if(maxlen==ss.length()&&ss.compareTo(res)>0){
                    continue;

                }
                res = ss;
                maxlen = Math.max(maxlen,ss.length());

            }
        }
        return res;

    }
    //暴力穷举
    public boolean charge(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        if(n<m)
            return false;
        else if(m<=0){
            return true;
        }
        int index = 0;
        for(int i=0;i<n;i++){
            if(s1.charAt(i)==s2.charAt(index))
                index++;
            if(index==m)
                return true;
        }
        return index==s2.length();

    }
    //动态规划_超时 O(n^2)
    public boolean longestsub(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        //dp[i][j]是s1长度为i中有s2长度为j的子序列
        boolean[][] dp = new boolean[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dic = new ArrayList<>();
        String[] strarr = {"ale","apple","monkey","plea"};

        findLongestWord524 slw = new findLongestWord524();
        System.out.println(slw.findLongestWord(s,Arrays.asList(strarr)));
    }
}
