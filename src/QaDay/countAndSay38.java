package QaDay;

import java.util.HashMap;
import java.util.Map;

public class countAndSay38 {
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1;i<n;i++){
            res = getnextstr(res);
        }
        return res;
    }
    public String getnextstr(String n){
        char[] strarr = n.toCharArray();
        String res = "";
        int len = strarr.length;
        if(len==1){
            res += "1"+strarr[0];
            return res;
        }
        int count = 1;
        for(int i = 0;i<len-1;i++){
            if(strarr[i]==strarr[i+1]){
                count++;
                if(i==len-2){
                    res+=Integer.toString(count)+strarr[i+1];
                }
            }
            else{
                res +=Integer.toString(count)+strarr[i];
                count = 1;
                if(i==len-2){
                    res+="1"+strarr[i+1];
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int n = 5;
        countAndSay38 ca = new countAndSay38();
        System.out.println(ca.countAndSay(n));
    }
}
