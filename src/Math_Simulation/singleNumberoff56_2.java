package Math_Simulation;

import java.util.HashMap;
import java.util.Map;

public class singleNumberoff56_2 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        int count=0;
        for (int n:nums){
            count = m.getOrDefault(n,0);
            count++;
            m.put(n,count);
        }
        for(Map.Entry<Integer,Integer> entry:m.entrySet()){
            if(entry.getValue()<3)
                return entry.getKey();
        }
        return -1;
    }
}
