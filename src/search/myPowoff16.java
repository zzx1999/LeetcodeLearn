package search;

public class myPowoff16 {
    //快速幂
    //对于任何十进制正整数 nnn ，设其二进制为 "bm...b3b2b1 为二进制某位值，i∈[1,m] ，则有：
    //
    //    二进制转十进制： n=1b1+2b2+4b3+...+2m−1bm（即二进制转十进制公式） bm ∈ {0,1}；
    //    幂的二进制展开： x^n = x^{1b_1 + 2b_2 + 4b_3 + ... + 2^{m-1}b_m} = x^{1b_1}x^{2b_2}x^{4b_3}...x^{2^{m-1}b_m}；
    //
    public double myPow(double x, int n) {
        if(x==0)
            return 0;
        if(n<0){
            x = 1.0/x;
            n = -n;
        }
        double res = 1.0;
        while (n>0){
            if((n&1)==1) res *= x;
            x *= x;
            n >>= 1;
        }
        return res;
    }
    //O(n)
    public double myPow_Timeout(double x, int n) {
        if(n==0)
            return 1;
        if(n<0){
            x = 1.0/x;
            n = -1 * n;
        }
        double res = 1;
        for(int i=1;i<=n;i++){
            res *= x;
        }
        return res;
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;
        myPowoff16 mp = new myPowoff16();
        System.out.println(mp.myPow(x,n));
    }
}
