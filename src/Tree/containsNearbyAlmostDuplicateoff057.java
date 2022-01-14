package Tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class containsNearbyAlmostDuplicateoff057 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //滑动窗口
//        对于序列中每一个元素 x 左侧的至多 k 个元素，如果这 k 个元素中存在一个元素落在区间 [x−t,x+t] 中，我们就找到了一对符合条件的元素。
        //数组滑动窗口数据结构：有序集合TreeSet,桶排序（哈希表）
        //支持添加和删除指定元素的操作，否则我们无法维护滑动窗口；
//        内部元素有序(队列无序)，支持二分查找的操作,只需要判断滑动窗口中所有大于等于 x−t的元素中的最小元素是否小于等于x+t即可。
        //
        //有序集合
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<n;i++){
            Long celing = set.ceiling(Math.abs((long) nums[i] - (long) t));//返回大于指定元素的最小值
            if(celing!=null&&celing<=(long)nums[i]+(long) t)
                return true;
            set.add((long)nums[i]);
            if(i>=k)
                set.remove((long) nums[i-k]);

        }
        return false;
    }
}
