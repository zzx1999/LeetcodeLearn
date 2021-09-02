package QaDay;

import java.util.*;

public class corpFlightBookings1109 {
    //超出内存限制
    public int[] corpFlightBookings_outmemory(int[][] bookings, int n) {
        int[][] bookmap = new int[bookings.length][n+1];
        for(int i = 0;i< bookings.length;i++){
            int[] book = bookings[i];
            for(int j = book[0];j<=book[1];j++){
                bookmap[i][j] = book[2];
            }
        }
        int[] res = new int[n];
        int sum = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 0;j< bookings.length;j++){
                sum += bookmap[j][i];
            }
            res[i-1] = sum;
            sum = 0;
        }
        return res;
    }
    //公交车问题，某公交车共有 n 站，第 i 条记录 bookings[i] = [i, j, k]
    // 表示在 i 站上车 k 人，乘坐到 j 站，在 j+1 站下车，需要按照车站顺序返回每一站车上的人数
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] count = new int[n];//表示第i+1站车上人数变化
        for(int[] book:bookings){
            count[book[0]-1] += book[2];
            if(book[1]<n){
                count[book[1]] -= book[2];
            }
        }
        for(int i=1;i<n;i++){
            count[i] += count[i-1];
        }
        return count;


    }

    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        corpFlightBookings1109 cfb = new corpFlightBookings1109();
        cfb.corpFlightBookings(bookings,5);

    }
}
