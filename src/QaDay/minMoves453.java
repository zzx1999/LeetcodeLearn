package QaDay;

import java.util.Arrays;

public class minMoves453 {
    public int minMoves(int[] nums) {
        //考虑相对运算:n-1个元素加1相当于对一个元素减一,这样就只需要计算所有元素减到最小元素需要的操作步骤
        int min = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res += (nums[i]-min);
        }
        return res;

    }
}
