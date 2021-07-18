package Trackback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class permuteString {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<Integer>();
        backtrack(nums,track);
        return res;

    }
    public void backtrack(int[] nums,LinkedList<Integer> track){
        //结束条件,如果路径长度等于数组长度说明排列完成
        if(track.size()==nums.length){
            res.add(new LinkedList<Integer>(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //做选择，从选择区间选一个加到路径，选择区间是通过track和nums排除出来的
            if (!track.contains(nums[i])){
                track.add(nums[i]);
            }
            else
                continue;
            //进入下一层决策树
            backtrack(nums,track);
            //取消选择
            track.removeLast();


        }

    }
}
