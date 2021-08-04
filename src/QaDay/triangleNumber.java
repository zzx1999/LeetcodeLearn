package QaDay;

import java.util.Arrays;

public class triangleNumber {
    public int triangleNum(int[] nums) {
        Arrays.sort(nums);
        int[] sqnums = nums.clone();
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n-2;i++){
            for(int j = i+1;j<n-1;j++){
                for(int k =j+1;k<n;k++){
                    if(nums[i]+nums[j]>nums[k]){
                        count ++;

                    }
                }

            }
        }
        return count;

    }
}
