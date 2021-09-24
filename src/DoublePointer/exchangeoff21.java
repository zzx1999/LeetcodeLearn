package DoublePointer;

public class exchangeoff21 {
    //指针 i 从左向右寻找偶数；
    //指针 j 从右向左寻找奇数；
    //将 偶数 nums[i] 和 奇数 nums[j] 交换。
    public int[] exchange(int[] nums) {
        int n = nums.length;
        if(n==0)
            return new int[0];
        int even = n-1,odd = 0;
        while (odd<=even){
            if(nums[odd] % 2 == 0&&nums[even] % 2 != 0){
                int t = nums[odd];
                nums[odd] = nums[even];
                nums[even] = t;
                odd++;
                even--;
            }
            else if(nums[odd]%2!=0){
                odd++;
            }
            else if(nums[even] % 2 == 0){
                even--;
            }
        }
        return nums;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        exchangeoff21 ec = new exchangeoff21();
        ec.exchange(nums);
    }
}
