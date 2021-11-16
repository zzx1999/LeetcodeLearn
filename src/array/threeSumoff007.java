package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class threeSumoff007 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        int lg = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<lg;i++){
            if(nums[i]>0)
                break;
            if(i>0&&nums[i]==nums[i-1]) continue;//去重操作,尽量不要用相同target
            int l = i+1,r = lg-1;
            while (l<r){
                int sum = nums[l]+nums[r]+nums[i];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l<r && nums[l]==nums[l+1]) l++;//跳过相同
                    l++;
                }
                else if(sum<0) l++;
                else if(sum>0) r--;
            }
        }
        return ans;
    }
    //emo了A不过去
//    int[] nums;
////    boolean[] visited;
//    List<List<Integer>> ans = new LinkedList<>();
//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        this.nums = nums;
////        visited = new boolean[nums.length];
//        for(int i=0;i<nums.length-2;i++){
//            twoSum(i+1,nums.length-1,-nums[i]);
//        }
//        return ans;
//    }
//    public void twoSum(int l,int r,int target){
//        while (l<r){
//            if(nums[l]+nums[r]>target)
//                r--;
//            else if(nums[l]+nums[r]<target)
//                l++;
//            else{
////                if(!(visited[l]||visited[r])){
////                    List<Integer> res = new LinkedList<>();
////                    res.add(nums[l]);
////                    res.add(nums[r]);
////                    res.add(-target);
////                    ans.add(res);
////                    visited[l] = true;
////                    visited[r] = true;
////
////                }
//                List<Integer> res = new LinkedList<>();
//                res.add(nums[l]);
//                res.add(nums[r]);
//                res.add(-target);
//                ans.add(res);
//                if(nums[l]==nums[l+1]) l++;
////                    visited[l+1] = true;
//                if(nums[r]==nums[r-1]) r--;
////                    visited[r-1] = true;
//                l++;
//                r--;
//
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {3,0,-2,-1,1,2};
        threeSumoff007 ts = new threeSumoff007();
        ts.threeSum(nums);
    }
}
