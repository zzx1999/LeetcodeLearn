package search;

import java.util.Arrays;

public class missingNumberoff53_2 {
    public int missingNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return nums.length;

    }
}
