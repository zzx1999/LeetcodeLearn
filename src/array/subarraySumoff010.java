package array;

import java.util.HashMap;
import java.util.Map;

public class subarraySumoff010 {
    public int subarraySum(int[] nums, int k) {
        //滑动窗口不适用 因为不是正整数
        //前缀和
        int[] proSum = new int[nums.length];
        int sum = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            proSum[i] = sum;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(proSum[i]-nums[j]==k)
                    count++;
            }
        }
        return count;
    }
    public int subarraySum_opt(int[] nums, int k) {
        //滑动窗口不适用 因为不是正整数
        //前缀和+哈希表优化
        Map<Integer,Integer> proSum = new HashMap<>();
        proSum.put(0,1);//前缀和,前缀和个数
        int sum = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            proSum.put(sum, proSum.getOrDefault(sum,0)+1);
            //查找前缀和为sum-k的个数
            count += proSum.getOrDefault(sum-k,0);
        }
        return count;
    }
}
