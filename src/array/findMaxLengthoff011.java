package array;

import java.util.HashMap;
import java.util.Map;

public class findMaxLengthoff011 {
    public int findMaxLength_bad(int[] nums) {
        //转换成求和为i+1/2(i是偶数)最长连续子数组长度
        Map<Integer,Integer> findmap = new HashMap<>();
        int sum = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            findmap.put(sum,i+1);//前缀和,前缀和长度
            if((i+1) % 2==0){
                max = findmap.getOrDefault((i+1) / 2,0);
                max = Math.max(max,findmap.getOrDefault(sum-(i+1)/2,0));
            }

        }
        return max;
    }
    public int findMaxLength(int[] nums) {
        //把0看成-1,转化为求和为0的最长连续子数组
        int count = 0;//维护count nums[i]=0就--,=1就++
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                count--;
            else
                count++;
            if(map.containsKey(count)){//如果前面有了count
                int pre = map.get(count);
                max = Math.max(max,i-pre);//该段内和为0
            }
            else{
                map.put(count,i);//存前缀和,前缀和下标
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        findMaxLengthoff011 fm = new findMaxLengthoff011();
        fm.findMaxLength(nums);
    }
}
