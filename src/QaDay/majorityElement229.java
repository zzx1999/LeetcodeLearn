package QaDay;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class majorityElement229 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int major = n / 3;
        List<Integer> res = new LinkedList<>();
        Map<Integer,Integer> numsmap = new HashMap<>();
        for(int i = 0;i<n;i++){
            int count = numsmap.getOrDefault(nums[i],0);
            if(count>=major&&!res.contains(nums[i])){
                res.add(nums[i]);
                count = -1;
            }
            if(count!=-1){
                count++;
                numsmap.put(nums[i],count);
            }
        }
        return res;

    }
}
