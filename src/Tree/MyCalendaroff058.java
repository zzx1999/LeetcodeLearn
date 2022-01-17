package Tree;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendaroff058 {
    private TreeMap<Integer,Integer> timeMap;
    public MyCalendaroff058() {
        //初始化
        timeMap = new TreeMap<>();

    }

    public boolean book(int start, int end) {
//        预定一个时间段<start,end>的时候，先到容器中查找两段时间。
//        floorPeriod： 比当前预定时间段前的最近一段时间。
//        ceilPeriod：比当前预定时间段后的最近一段时间
//        如果 floorPeriod 的结束时间 <= start && end <= ceilPeriod 的开始时间，则可以预定，否则不能预定。
        //获取比当前预定时间段前的最近一段时间。
        Map.Entry<Integer,Integer> floorPeriod = timeMap.floorEntry(start);
        //比当前预定时间段后的最近一段时间
        Map.Entry<Integer,Integer> celiPeriod = timeMap.ceilingEntry(end);
        int lastEnd = Integer.MIN_VALUE;
        if(floorPeriod!=null){
            lastEnd = floorPeriod.getValue();
        }
        int firstStart = Integer.MAX_VALUE;
        if(celiPeriod!=null){
            firstStart = celiPeriod.getKey();
        }
        if(start>=lastEnd&&end<=firstStart){
            timeMap.put(start,end);
            return true;
        }
        return false;
    }
}
