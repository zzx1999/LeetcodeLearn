package dp;

public class isMatchoff19 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];//s中前i个字符与p中前j个字符匹配
        dp[0][0] = true;
        for(int i=0;i<=n;i++){
            for(int j=1;j<=m;j++){
                //*要将前面的字符看成一个组合
                if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2];
                    //两种情况一种是s[i]通过p[j-1]0次复制过来这样一来p[j]p[j-1]就废了:dp[i][j] = dp[i][j-2]
                    //另外一种情况s[i]是p[j-1]复制多次后的最后一个则:dp[i][j] = dp[i-1][j],这样就看s[i-1]是不是复制来的
                    if(i>0&&(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.'))//复制了一次或者0次
                        dp[i][j] = dp[i-1][j]||dp[i][j];
                }
                else if(i>0&&(p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='.')){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        isMatchoff19 im = new isMatchoff19();
        im.isMatch(s,p);
    }
}
