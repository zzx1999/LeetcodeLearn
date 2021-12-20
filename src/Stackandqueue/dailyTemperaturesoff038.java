package Stackandqueue;

import java.util.Stack;

public class dailyTemperaturesoff038 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] waittime = new int[n];
        Stack<Integer> tempindex = new Stack<>();//保存元素下标实现天数计算
        int p = 1;
        tempindex.add(0);
        while (p<n){
            if(temperatures[p]>temperatures[tempindex.peek()]){//到了下一个更大温度
                int updateindex = tempindex.peek();
                while (temperatures[p]>temperatures[updateindex]){
                    waittime[updateindex] = p-updateindex;
                    if(tempindex.isEmpty())
                        break;
                    updateindex = tempindex.pop();
                }
                if(temperatures[p]<=temperatures[updateindex])
                    tempindex.add(updateindex);
            }
            tempindex.add(p);
            p++;
        }
        return waittime;

    }

    public static void main(String[] args) {
        int[] temperature = {73,74,75,71,69,72,76,73};
        dailyTemperaturesoff038 dTt = new dailyTemperaturesoff038();
        dTt.dailyTemperatures(temperature);
    }
}
