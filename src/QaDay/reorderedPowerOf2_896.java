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
        //还有一种思路是:对于两个不同的整数 a 和 b，如果其十进制表示的字符数组，从小到大排序后的结果是相同的，那么若 a 能够重排得到 2 的幂，b 也可以；
        //只要 a 和 b 的十进制表示的字符数组中，从 0到 9每个字符的出现次数，在 a 和 b 中都是一样的，那么 a 和 b 能否重排得到 222 的幂的结果是一样的。
        //由于 2^{29} < 10^9 < 2^{30}，因此在 [1,10^9]范围内有 2^0,2^1,...,2^{29}一共 30 个 2 的幂。
        //预处理其十进制表示的字符数组中从 0 到 9 每个字符的出现次数，记在一个长度为 10 的数组中，并用一哈希表记录这些数组。
    }
}
