package Sort_off;

import java.util.Arrays;

public class isStraightoff61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        int min = nums[0];
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=0){
                min = nums[i];
                break;
            }
        }
        //查重
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0)
                continue;
            if((nums[i]==nums[i+1])){
                return false;
            }
        }
        return max - min < 5;
    }
}
