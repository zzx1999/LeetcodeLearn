package search;

public class mySqrtoff072 {
    public int mySqrt(int x) {
        int l = 0,r = x;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(mid  > x/mid){//防止溢出
                r = mid-1;
            }
            else if(mid<x/mid){
                l = mid+1;
            }
            else{
                return mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int x = 2147395599;
        mySqrtoff072 ms = new mySqrtoff072();
        System.out.println(ms.mySqrt(x));
    }
}
