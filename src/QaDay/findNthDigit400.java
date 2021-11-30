package QaDay;

import java.util.Map;

public class findNthDigit400 {
    public int findNthDigit_Timeout(int n) {
        int i=1;
        String numstr = "";
        while (numstr.length()<n){
            numstr += i;
            i++;
        }
        return numstr.charAt(n-1) - '0';
    }
    //数位模拟
    public int findNthDigit(int n) {
        //计算出第n位数所在的数是几位数,所有1位数位数和是1×9=9,两位数[10,99]:2*90=180,三位数[100,999]:3*900=2700
        //x位数[10^(x-1),10^x]:9*10^(x-1)*x
        //由于n的最大值为 2^{31} - 1，约为 2*10^9，当 x=9时，x*9*10^{x - 1} = 8.1*10^9 > 2^{31} - 1，因此第n位数字所在整数最多是9位数，令d的上界为9即可。
        //然后就算所有不超过d-1位的整数的位数之和,得到第n位数在d位数的序列下标index = n-preSum+1
        //n是在第Index/d个d位数的第index mod d位(编号是从0开始的)
        //最小的d位数是从10^(d-1)开始的,所以n为数字所在整数是10^(d-1),该该整数的右边第 d−(index mod d)-1位数就是第n位数
        int l = 1,h = 9,m = 0;
        while (l<h){
           m = l + (h-l)/2;
           if(countDigt(m)<n){
               l = m+1;
           }else {
               h = m;
           }
        }
        //确定l是n位数所在的数的位数
        int d = l;
        int preSum = countDigt(d-1);
        int index = n-preSum-1;
        int dnum = (int) (Math.pow(10,d-1)+index/d);//算出n位数所在的整数
        int digit = (dnum/(int)(Math.pow(10,d-(index % d)-1)))%10;
        return digit;
    }
    //算到第d位数所有数位之和
    public int countDigt(int d){
        int sum = 0;
        int curdigt = 1;
        while (curdigt<=d){
            sum += curdigt * 9 * Math.pow(10,curdigt-1);
            curdigt++;
        }
        return sum;
    }
}
