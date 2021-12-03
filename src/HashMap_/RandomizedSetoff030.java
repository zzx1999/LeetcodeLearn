package HashMap_;

import java.util.*;

public class RandomizedSetoff030 {
    //哈希表类题目一般和列表联系在一起
    //要求随机删除联想那么就要有标号,要求时间插入删除O(1)联想哈希表
    Map<Integer,Integer> rmap;
    List<Integer> arr;
    /** Initialize your data structure here. */
    public RandomizedSetoff030() {
        rmap = new HashMap<>();
        arr = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(rmap.containsKey(val))
           return false;
        else{
            arr.add(val);
            rmap.put(val,arr.size()-1);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(rmap.containsKey(val)){
            Integer index = rmap.get(val);
            Integer last = arr.get(arr.size()-1);
            arr.set(index,last);//在待删除的位置上将其设置为最后一个位置上的元素相当于删了
            rmap.put(last,index);
            arr.remove(arr.size()-1);
            rmap.remove(val);
            return true;
        }
        else
            return false;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        int n = r.nextInt(arr.size());
        return arr.get(n);
    }
}
