package QaDay;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class nextGreaterElement496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> nums2map = new HashMap<>();
        //高效计算下一个更大值_单调栈,倒序遍历nums2
        //从栈底到栈顶的元素是单调递减的。
        //每次我们移动到数组中一个新的位置 i，就将当前单调栈中所有小于 nums2[i]的元素弹出单调栈，
        // 当前位置右边的第一个更大的元素即为栈顶元素，如果栈为空则说明当前位置右边没有更大的元素。随后我们将位置 i 的元素入栈。保证该元素是右边最大
        //栈顶就是在元素右边且第一个比该元素大的
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = nums2.length-1;i>=0;i--){
            int num = nums2[i];
            while (!stack.isEmpty()&&num>=stack.peek()) stack.pop();
            nums2map.put(num,stack.isEmpty()?-1:stack.peek());
            stack.push(num);
        }
//        for(int i=0;i<nums2.length;i++){
//            nums2map.put(nums2[i],nums2map.getOrDefault(nums2[i],-1));
//            for(int j=i+1;j<nums2.length;j++){
//                if(nums2[j]>nums2[i]){
//                    nums2map.put(nums2[i],nums2[j]);
//                    break;
//                }
//            }
//        }
        for(int i=0;i<nums1.length;i++){
            nums1[i] = nums2map.get(nums1[i]);
        }
        return nums1;

    }

    public static void main(String[] args) {
        int[] nums2 = {1,3,4,2};
        int[] nums1 = {4,1,2};
        nextGreaterElement496 nge = new nextGreaterElement496();
        nge.nextGreaterElement(nums1,nums2);
    }
}
