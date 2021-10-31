package Math;

public class cuttingRopeoff15_2 {
    public int cuttingRope(int n) {
        //也可以用数学证明每份接近3的时候乘积最大所以可以先将n除以3再针对余数拆分,如果余数是0,最好,如果余数是1要将一个1+3拆成2+2
        //如果余数是2就直接最后一份是2
        //但是和第一题不一样的是这里要考虑大数取余问题
        //因为假设n/3=a,乘积就是3^a可能会溢出
        if(n<=3) return n-1;
        int a = n/3 ;
        int b = n % 3;
        long res = 1L;
        int mod = 1000000007;
        for(int i=1;i<a;i++){
            res = (res * 3) % mod;
        }
        if(b==1){
            res = (res  * 4) % mod;
        }
        else if(b==2)
            res = (res * 6) % mod;
        else if(b==0)
            res = (res * 3) % mod;
        return (int)res;
    }

    public static void main(String[] args) {
        int n = 127;
        cuttingRopeoff15_2 cr2 = new cuttingRopeoff15_2();
        cr2.cuttingRope(n);
    }
}
