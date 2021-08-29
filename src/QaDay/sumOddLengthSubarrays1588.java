package QaDay;

import java.util.HashMap;
import java.util.Map;

public class sumOddLengthSubarrays1588 {
    //O(n^3)
    public int sumOddLengthSubarrays_3(int[] arr) {
        int n = arr.length;
        int l = 1;
        int sum = 0;
        while (l<=n){
            for(int i = 0;i<(n-l+1);i++){
                for(int j = i;j<i+l;j++){
                    if(i+l>n)
                        break;
                    sum+=arr[j];

                }
            }
            l = l+2;

        }
        return sum;
    }
    //使用前缀和优化到O(n^2)
    //区间为【l,r】的和等于前缀和r-前缀和l
    public int sumOddLengthSubarrays_2(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int[] sum = new int[n+1];
        for(int i = 1;i<=n;i++)
            sum[i] = sum[i-1]+arr[i-1];
        for(int len = 1;len<=n;len+=2){
            for(int l = 0;l+len-1<n;l++){
                int r = l+len-1;
                ans+= sum[r+1]-sum[l];
            }
        }
        return ans;
    }
    //数学优化：问题转换为如何求得「arr[i]在原数组中左边连续一段元素个为奇数的方案数」
    // 和「arr[i]在原数组右边连续一段元素个数为偶数的方案数」,我们知道 arr[i]同出现在多少个奇数子数组中，再乘上 arr[i]
    // 即是 arr[i] 对答案的贡献。
    //对于原数组的任意位置 iii 而言，其左边共有 i 个数，右边共有 n−i−1 个数。
    //位置 i 左边奇数个数的方案数为 (i+1)/2，右边奇数个数的方案数为(n−i)/2；
    public int sumOddLengthSubarrays_1(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            int l1 = (i+1)/2,r1 = (n-i)/2;
            int l2 = i/2,r2 = (n-i-1)/2;
            l2++;r2++;
            ans += (l1 * r1 + l2 * r2) * arr[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        sumOddLengthSubarrays1588 sols = new sumOddLengthSubarrays1588();
        System.out.println(sols.sumOddLengthSubarrays_1(arr));
    }
}
