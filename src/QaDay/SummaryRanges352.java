package QaDay;

import java.util.*;

public class SummaryRanges352 {
//    List<Integer> list;
    TreeMap<Integer,Integer> intervals;
    public SummaryRanges352() {
        intervals = new TreeMap<>();
    }

    public void addNum(int val) {
        // 找到 l1 最小的且满足 l1 > val 的区间 interval1 = [l1, r1]
        // 如果不存在这样的区间，interval1 为尾迭代器
        Map.Entry<Integer, Integer> interval1 = intervals.ceilingEntry(val + 1);//方法调用返回的最小键大于或等于键
        // 找到 l0 最大的且满足 l0 <= val 的区间 interval0 = [l0, r0]
        // 在有序集合中，interval0 就是 interval1 的前一个区间
        // 如果不存在这样的区间，interval0 为尾迭代器
        Map.Entry<Integer, Integer> interval0 = intervals.floorEntry(val);
        if(interval0!=null&&interval0.getKey()<=val&&interval0.getValue()>=val){
            return;
        }
        else{
            boolean rightAside = interval0!=null&&interval0.getValue()+1==val;
            boolean leftAside = interval1!=null&&interval1.getKey()-1==val;
            if(leftAside&&rightAside){//情况四
                int l = interval0.getKey(),r = interval1.getValue();
                intervals.remove(interval0.getKey());
                intervals.remove(interval1.getKey());
                intervals.put(l,r);
            }else if(leftAside){//情况三
                int l = interval1.getKey()-1,r=interval1.getValue();
                intervals.remove(interval1.getKey());
                intervals.put(l,r);
            }
            else if(rightAside){//情况二
                int l = interval0.getKey(),r = interval0.getValue()+1;
                intervals.put(l,r);
            }
            else{
                intervals.put(val,val);//情况五
            }
        }
    }
    //有序映射
    //如果插入一个值val
    //找到区间 [l0,r0]使得 l0是最大的满足 l0≤val的区间。
    // 同时，我们需要找到区间 [l1,r1]，使得 l1是最小的满足 l1>val 的区间。
    //那么就分为五种情况：
    //l0≤val≤r0,加入到这个区间，区间不会有什么变化
    //r0+1=val,加入后变成[l0,r0+1]
    //l1-1 = val,加入后变成[l1-1,r1]
    //r0+1=val且l1-1=val,加入后变[l0,r1]
    //都不满足，单独形成区间[val.val]
    //找最近区间的数据结构是有序映射，有序映射中的键和值分别表示区间的左边界 l 和右边界 r。
    // 有序映射支持查询「最大的比某个元素小的键」以及「最小的比某个元素大的键」这两个操作
    //其实也可以使用ArrayList维护区间——加入哨兵，使用二分法查找区间
    public int[][] getIntervals() {
        int size = intervals.size();
        int[][] ans = new int[size][2];
        int index = 0;
        for(Map.Entry<Integer,Integer> entry:intervals.entrySet()){
            int l = entry.getKey(),r = entry.getValue();
            ans[index][0] = l;
            ans[index][1] = r;
            index++;
        }
        return ans;

    }
//    public int[][] getIntervals_wrong() {
//        Collections.sort(list);
//        int n = list.size();
//        int l = 0,r = 0;
//        List<int[]> res = new LinkedList<>();
//        while (l<n){
//            int[] ans = new int[0];
//            int i = l;
//            for(i=l;i<n-1;i++){
//                if(list.get(i+1)-list.get(i)==1)
//                    continue;
//                else{
//                    ans = new int[2];
//                    ans[0] = list.get(l);
//                    ans[1] = list.get(i);
//                    //l = i+1;
//                    break;
//                }
//            }
//            if(ans.length!=0)
//                res.add(ans);
//            else{
//                ans = new int[2];
//                ans[0] = list.get(l);
//                ans[1] = list.get(i);
//                if(ans[1]-ans[0]!=1)
//                    ans[1] = ans[0];
//                res.add(ans);
//            }
//            l = i+1;
//
//        }
//        int[][] reslut = new int[res.size()][2];
//        for(int i = 0;i<res.size();i++){
//            reslut[i] = res.get(i);
//        }
//        return reslut;
//    }
}
