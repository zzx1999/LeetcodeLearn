package Divide;

import java.util.LinkedList;
import java.util.List;

public class printNumbersoff17 {
    List<String> res = new LinkedList<>();
    public int[] printNumbers(int n) {
        int range = (int)Math.pow(10,n);
        List<Integer> res = new LinkedList<>();
        for(int i=1;i<=range-1;i++){
            res.add(i);
        }
        int[] ints = res.stream().mapToInt(Integer::valueOf).toArray();
        return ints;
    }
    //考虑大数问题
    public List<String> printNumbers_big(int n){
        //大数用字符串表示
        //问题转换成生成n位0-9全排列
        //全排列递归生成,固定高位向低位递归
        String num = "";
        recur(num,n);
        List<String> newans = new LinkedList<>();
        //做一下预处理,删除高位多余0
        for(String str:res){
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)!='0'){
                    str = str.substring(i,str.length());
                    newans.add(str);
                    break;
                }

            }
        }
        System.out.println(newans);
        return newans;

    }
    public void recur(String num,int n){
        if(num.length()==n){
            res.add(num);
            return;
        }
        for(int i=0;i<=9;i++){
            num += String.valueOf(i);
            recur(num,n);
            num = num.substring(0,num.length()-1);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        printNumbersoff17 pb = new printNumbersoff17();
        pb.printNumbers_big(n);
    }
}
