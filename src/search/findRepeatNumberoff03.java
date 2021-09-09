package search;

public class findRepeatNumberoff03 {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        for(int i=0;i<n;i++){
            if(count[nums[i]]!=0)
                return nums[i];
            else
                count[nums[i]]++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        findRepeatNumberoff03 frn = new findRepeatNumberoff03();
        System.out.println(frn.findRepeatNumber(nums));
    }
}
