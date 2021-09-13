package QaDay;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class numberOfBoomerangs447 {
    public int numberOfBoomerangs_error(int[][] points) {
        //Map<Integer, List<Integer>> map = new HashMap<>();
        int x1,y1,x2,y2;
        int count = 0;
        for(int i = 0;i<points.length;i++){
            x1 = points[i][0];
            y1 = points[i][1];
            List<Integer> distance = new LinkedList<>();
            for(int j = 0;j<points.length;j++){
                if(i==j)
                    continue;
                x2 = points[j][0];
                y2 = points[j][1];
                int dis = (int)(Math.pow(x1 - x2,2) + Math.pow(y1-y2,2));
                if(distance.contains(dis))//不行，如果一个点他有三个和他相连且相等的边那么回旋镖是有6个的这里只算了4个
                    count+=2;
                else
                    distance.add(dis);
            }
        }
        return count;
    }
    public int numberOfBoomerangs(int[][] points) {
        int x1,y1,x2,y2;
        int res = 0;
        for(int i = 0;i<points.length;i++){
            //存以point[i]为拐点，各个边长度数量
            Map<Integer, Integer> map = new HashMap<>();
            x1 = points[i][0];
            y1 = points[i][1];
            for(int j = 0;j<points.length;j++){
                x2 = points[j][0];
                y2 = points[j][1];
                int dis = (int)(Math.pow(x1 - x2,2) + Math.pow(y1-y2,2));
                map.put(dis, map.getOrDefault(dis,0)+1);

            }
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                int num = entry.getValue();
                if(num > 0){
                    res += (num-1)*num;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{-1,0},{0,-1}};
        numberOfBoomerangs447 nb = new numberOfBoomerangs447();
        System.out.println(nb.numberOfBoomerangs(points));
    }
}
