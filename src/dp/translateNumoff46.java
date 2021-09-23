package dp;

public class translateNumoff46 {
    public int translateNum(int num) {
        String numstr = Integer.toString(num);
        int n = numstr.length();
        if(n==0)
            return 0;
        //前n个可以有几种组合
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1;i<n;i++){
            char p = numstr.charAt(i-1);
            char c = numstr.charAt(i);
            if(p>'2'||p=='0'||(p=='2'&&c>'5')){//不能和前面的组,只能组单个
                dp[i] = dp[i-1];
            }
//            else if(c <= '5'&&(numstr.charAt(i-1)>'2'||numstr.charAt(i-1)=='0')){//
//                dp[i] = dp[i-1];
//            }
            else{
                if(i==1)
                    dp[i] = dp[i-1]+1;
                else
                    dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int num = 26;
        translateNumoff46 tn = new translateNumoff46();
        System.out.println(tn.translateNum(num));
    }
}
