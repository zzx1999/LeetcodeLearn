package QaDay;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class reorderedPowerOf2_896 {
    List<Boolean> resbool = new ArrayList<>();
    boolean[] visited;
    public boolean reorderedPowerOf2(int n) {
        //回溯?
        String strn = String.valueOf(n);
        System.out.println(strn);
        String[] nums = strn.split("");
        visited = new boolean[nums.length];
        LinkedList<String> route = new LinkedList<String>();
        return backtrack(nums, route);


    }
    public boolean backtrack(String[] nums, LinkedList<String> route){
        if(route.size()==nums.length){
            String finalstr = "";
            for(String s:route){
                finalstr += s;
            }
            boolean zerofirst = (!route.getFirst().equals("0"));
            int res = Integer.parseInt(finalstr);
            return isPowerOfTwo(res) && zerofirst;
        }
        for (int i=0;i<nums.length;i++){
            if(!visited[i]){
                route.add(nums[i]);
                visited[i] = true;
            }
            else
                continue;
            if(backtrack(nums,route)){
                return true;
            }
            route.removeLast();
            visited[i] = false;
        }
        return false;

    }
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 10;
        reorderedPowerOf2_896 rp = new reorderedPowerOf2_896();
        System.out.println(rp.reorderedPowerOf2(n));
    }
}
