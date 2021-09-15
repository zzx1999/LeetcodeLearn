package QaDay;

public class findPeakElement162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0,r = n-1,mid = 0;
        while (l<r){
            mid = l+(r-l)/2;
            if (nums[mid]>nums[mid+1]){//说明峰值在左边
                r = mid;
            }
            else{//说明峰值在右边，也有可能是mid+1
                l = mid+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        findPeakElement162 fp = new findPeakElement162();
        System.out.println(fp.findPeakElement(nums));
    }
}
