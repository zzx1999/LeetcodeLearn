package HashMap_;

import java.util.*;

public class findMinDifferenceoff035 {
    public int findMinDifference_fool(List<String> timePoints) {
        List<int[]> timelist = new ArrayList<>();
        int minres = Integer.MAX_VALUE;
        for(String s:timePoints){
            String[] strs = s.split(":");
            int hour = Integer.valueOf(strs[0]);
            int sec = Integer.valueOf(strs[1]);
            timelist.add(new int[]{hour,sec});
        }
        Collections.sort(timelist, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[0]<=t1[0])
                    return -1;
                else
                    return 1;
            }
        });
        timelist.add(new int[]{(timelist.get(0)[0]+24),timelist.get(0)[1]});
        int h1,s1,h2,s2;
        for(int i=0;i<timelist.size()-1;i++){
            h1 = timelist.get(i)[0];
            s1 = timelist.get(i)[1];
            h2 = timelist.get(i+1)[0];
            s2 = timelist.get(i+1)[1];
            //直接换算成分钟
            int res = ((h2*60+s2)-(h1*60+s1))%(24*60);
            minres = Math.min(minres,res);
        }
        return minres;
//        Map<Integer,Integer> timemap = new TreeMap<>();
//        //时分存map
//        for(String str:timePoints){
//            String[] strs = str.split(":");
//            int hour = Integer.valueOf(strs[0]);
//            int sec = Integer.valueOf(strs[1]);
//            if(!timemap.containsKey(hour)){
//                timemap.put(hour,sec);
//            }
//            else {
//                minres = Math.min(minres,Math.abs(timemap.get(hour)-sec));
//            }
//        }
//        for(Map.Entry entry:timemap.entrySet()){
//            int h = (int) entry.getKey();
//            int s = (int) entry.getValue();
//
//        }


    }
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) {
            return 0;
        }
        List<Integer> mins = new ArrayList<>();
        for (String t : timePoints) {
            String[] time = t.split(":");
            mins.add(Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
        }
        Collections.sort(mins);
        mins.add(mins.get(0) + 24 * 60);
        int res = 24 * 60;
        for (int i = 1; i < mins.size(); ++i) {
            res = Math.min(res, mins.get(i) - mins.get(i - 1));
        }
        return res;

    }

    public static void main(String[] args) {
        List<String> timelist = new ArrayList<>();
//        timelist.add("00:00");
        timelist.add("23:59");
        timelist.add("00:00");
        findMinDifferenceoff035 fd = new findMinDifferenceoff035();
        fd.findMinDifference(timelist);

    }
}
