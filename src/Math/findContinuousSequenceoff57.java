package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class findContinuousSequenceoff57 {
    public int[][] findContinuousSequence(int target) {
        int len = 1;
        int i = 1,j = 1;
        List<int[]> res = new LinkedList<>();
        while (true){
            len++;
            j = i + len -1;
            if((i+j)*len/2==target){
                int[] ans = new int[len];
                for(int k=0;k<len;k++){
                    ans[k] = k+i;
                }
                res.add(ans);
                if(len==2)
                    break;
                else{
                    i++;
                    len = 1;

                }
            }
            else if((i+j)*len/2>target){
                i++;
                len = 1;
            }
            if(i==target)
                break;
        }
        return res.toArray(new int[res.size()][]);

    }
    public int[][] findContinuousSequence_opt(int target) {
        List<int[]> res = new ArrayList<>();
        int l = 1,r=2;
        while (l<r){
            int sum = (l+r)*(r-l+1)/2;
            if(sum==target){
                int[] ans = new int[r-l+1];
                for(int i=0;i<r-l+1;i++){
                    ans[i] = i+l;
                }
                res.add(ans);
                l++;
            }
            else if(sum<target){
                r++;
            }
            else{
                l++;

            }

        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int target = 10;
        findContinuousSequenceoff57 fcs = new findContinuousSequenceoff57();
        fcs.findContinuousSequence_opt(target);
    }
}
