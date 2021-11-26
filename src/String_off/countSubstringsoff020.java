package String_off;

public class countSubstringsoff020 {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        int index = 0;
        int l = 0,r = 0;
        //一种思路是穷举所有字符串子串再判断是不是回文
        //另外一种思路是枚举每一个可能的回文中心,然后两指针分别向左右两边拓展
        //分别考虑回文串是奇数和是偶数的情况,如果是奇数,回文串左右 起始位置就是中心字符编号
        //如果是偶数那么左右起始位置就是相邻两个字符
        while (index<n){
             l = index;
             r = index;
            //奇数的情况
            while (l>=0&&r<n&&s.charAt(l)==s.charAt(r)){
                res++;
                l--;
                r++;
            }
            l = index;
            r = index+1;
            //偶数的情况
            while (l>=0&&r<n&&s.charAt(l)==s.charAt(r)){
                res++;
                l--;
                r++;
            }
            index++;
        }
        return res;
    }
    public boolean isPalindrome(String s){
        int n = s.length();
        if(n==0)
            return false;
        int l = 0,r = n-1;
        while (l<=r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
