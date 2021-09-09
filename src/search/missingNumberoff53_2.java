package search;

import java.util.Arrays;

public class missingNumberoff53_2 {
    //O(n)
    public int missingNumber_searchloop(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return nums.length;

    }
    //排序数组中的搜索问题，首先想到 二分法 解决。
    //缺失的数字等于 “右子数组的首位元素” 对应的索引；
    // 因此考虑使用二分法查找 “右子数组的首位元素” 。
    public int missingNumber(int[] nums){
        int l = 0,r = nums.length-1;
        int m = 0;
        while (l<=r){
            m = l + (r-l)/2;
            if(nums[m]==m){//右子数组首元素在右边
                l = m+1;
            }
            else//左子数组nums[i] = i,左子数组末尾元素一定在m左边
                r = m-1;
        }
        return l;
    }
}
