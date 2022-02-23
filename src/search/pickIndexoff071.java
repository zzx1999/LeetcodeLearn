package search;

import java.util.Arrays;
import java.util.Random;

public class pickIndexoff071 {
    float[] arr;
    public pickIndexoff071(int[] w) {
        int sum = Arrays.stream(w).sum();
        arr = new float[w.length];//存储概率
        for(int i = 0;i<w.length;i++){
            arr[i] = (float) (w[i]/(sum *1.0)) * 100;
        }
        for(int i=1;i<arr.length;i++){
            arr[i] += arr[i-1];
        }

    }

    public int pickIndex() {
        Random r = new Random();
        int index = r.nextInt(100);
        int l = 0,h = arr.length-1;
        while (l<h){
            int mid = l + (h-l)/2;
            if(index<arr[mid]){
                h = mid;
            }
            else {
                l = mid+1;
            }
        }
        return h;
        //O(n)
//        float minthre = Float.MAX_VALUE;
//        int res = 0;
//        for(int i=0;i<arr.length;i++){
//            if(index<arr[i]&&minthre>arr[i]){
//                minthre = arr[i];
//                res = i;
//            }
//        }
//        return res;
    }

    public static void main(String[] args) {
        pickIndexoff071 pi = new pickIndexoff071(new int[]{1,3});
        System.out.println(pi.pickIndex());
        System.out.println(pi.pickIndex());
        System.out.println(pi.pickIndex());
        System.out.println(pi.pickIndex());



    }
}
