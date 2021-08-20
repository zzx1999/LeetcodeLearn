package QaDay;

public class reverseStr541 {
    //递归
    public String reverseStr_digui(String s, int k) {
        String res = "";
        int n = s.length();
        if(n<k)
            return new StringBuffer(s).reverse().toString();;
        if(n<2*k && n>=k){
            res += new StringBuffer(s.substring(0,k)).reverse().toString();
            res += s.substring(k);
            return res;
        }
        res += new StringBuffer(s.substring(0,k)).reverse().toString();
        res += s.substring(k,2*k);
        res += reverseStr(s.substring(2*k),k);
        return res;
    }
    //直接模拟
    public String reverseStr(String s,int k){
        char[] charr = s.toCharArray();
        int n = charr.length;
        for(int l = 0;l<n;l = l+ 2 * k){
            int r = l+k-1;
            reverse(charr,l,Math.min(r,n-1));
        }
        return String.valueOf(charr);
    }
    public void reverse(char[] charr,int l,int r){
        while(l<r){
            char c = charr[l];
            charr[l] = charr[r];
            charr[r] = c;
            l++;
            r--;
        }
    }
    public static void main(String[] args) {
        String s = "a";
        int k = 8;
        reverseStr541 rs = new reverseStr541();
        System.out.println(rs.reverseStr(s,k));
    }
}
