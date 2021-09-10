package QaDay;

import java.util.Arrays;

public class chalkReplacer1894 {
    //超时
    public int chalkReplacer_Timeout(int[] chalk, int k) {
        int index = 0;
        int n = chalk.length;
        while(k>=0){
            if(index == n)
                index = 0;
            k -= chalk[index];
            if(k<0)
                return index;
            index++;
        }
        return index;
    }
    //每一轮消耗的粉笔总数total不变，可以k对total取模得到k'
    //只需要遍历一遍数组
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int nums:chalk){
            sum += nums;
        }
        long knew = k % sum;
        int i = 0;
        for(i=0;i<chalk.length;i++){
            if(knew<chalk[i])
                return i;
            knew -= chalk[i];
        }
        return i;
    }


    public static void main(String[] args) {
        int[] chalk = {3,4,1,2};
        int k = 25;
        chalkReplacer1894 cr = new chalkReplacer1894();
        System.out.println(cr.chalkReplacer(chalk,k));
    }
}
