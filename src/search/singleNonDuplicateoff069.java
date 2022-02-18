package search;

public class singleNonDuplicateoff069 {
    //二分，查找目标值、有序、时间复杂度O(logn)等信息，
    //目标值只有一个，也就是说它跟前后两个都不相同
    //二分查找过程中中间值nums[mid]的特征:它跟它后面一个数字相同\它跟它前面一个数字相同\它就是答案
    //数组长度为奇数,每一对数字的下标要么是(奇数，偶数)，要么是(偶数，奇数)
    //那就是如果mid所对应的一对数字下标是(奇数，偶数)，那么目标一定在mid之前，如果下标是(偶数，奇数)，目标一定在mid之后
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length-1;
        int l = 0,r = n;
        while (l<=r){
            int mid = l+(r-l)/2;
            if((mid>0&&nums[mid]==nums[mid-1]))//跟前面的一样
            {
                if(mid % 2==0){//如果是（奇数，偶数）目标在mid前面
                    r = mid-2;
                }
                else//如果是（偶数,奇数）目标在mid后面
                    l = mid+1;
            }
            else if((mid<n-1&&nums[mid]==nums[mid+1])){//
                if(mid % 2==0){//如果是（偶数,奇数）目标在mid后面
                    l = mid+2;
                }
                else//如果是（奇数，偶数）目标在mid前面
                    r = mid-1;
            }
            else
                return nums[mid];
        }
        return -1;

    }
}
