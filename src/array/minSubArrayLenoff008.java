package array;

public class minSubArrayLenoff008 {
    public int minSubArrayLen(int target, int[] nums) {
        //滑动窗口,连续子数组,连续子串附带最大最小
        //初始化左右边界
        //最大连续...尽量扩张右边界，直到不满足题意再收缩左边界.最小连续...尽量缩小左边界，直到不满足题意再扩大右边界
        //for 右边界 in 可迭代对象
        //  更新窗口内部信息
        //  while 根据题意调制:窗口内数字之和大于target
        //    比较并更新res(场景收缩)
        //    扩张或者收缩窗口大小
        //  比较并更新res(场景扩张)
        int l = 0,sum = 0;
        int res = Integer.MAX_VALUE;
        for(int r=0;r<nums.length;r++){
            sum += nums[r];
            while (sum >= target){
                res = Math.min(res,r-l+1);
                sum -= nums[l++];
            }
        }
        return res>nums.length?0:res;


    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        minSubArrayLenoff008 msa = new minSubArrayLenoff008();
        msa.minSubArrayLen(11,nums);
    }
}
