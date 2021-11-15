package IntegerProblem;

public class divideoff001 {
    //手撕代码,减法代替除法,会超时
    public int divide_sub(int a, int b) {
        int res = 0;
        int flag = ((a ^ b) > 0)||(a==b)?1:-1;
        a = a>0?-a:a;
        b = b>0?-b:b;
        //注意a、b的取值范围，如果a为2 ^ 31−1，b为1那么仅一次就需要计算2 ^ 31−1次，所以这个思路是不可行的
        while (a<=b){
            a -= b;
            if(res>=Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(a>b)
                break;
            res++;
        }
        return flag==1?res:-res;
    }
    //解决超时问题+优化
    int MIN = Integer.MIN_VALUE,MAX = Integer.MAX_VALUE;
    int LIMIT = MIN / 2;
    public int divide(int a, int b) {
        if(b==0) return 0;
        if(b==1) return a;
        if(b==-1){
            if(a==MIN) return MAX;
            return -a;
        }
        int res = 0;
        boolean flag = (a>0&&b>0)||(a<0&&b<0)?true:false;
        a = -Math.abs(a);
        b = -Math.abs(b);//映射到负数空间,因为负数空间更大
        while (a<=b){
            int c = b,d = -1;
            while (c>=LIMIT&&d>=LIMIT&&c>=a-c){//c翻倍超过了a且c翻倍不越界
                c += c;//除数翻倍
                d += d;//商翻倍
            }
            //如果c翻倍超过a了
            a -= c;
            res += d;
        }
        return flag?-res:res;
    }
    public static void main(String[] args) {
        int a = -2147483648,b = -1;
        divideoff001 di = new divideoff001();
        System.out.println(di.divide_sub(a,b));
    }
}
