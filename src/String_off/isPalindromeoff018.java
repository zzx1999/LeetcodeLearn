package String_off;

import java.util.Locale;

public class isPalindromeoff018 {
    public boolean isPalindrome(String s) {
        s = s.replaceAll(" ","");
        int n = s.length();
        if(n==0)
            return true;
        String news = "";
        for(int i=0;i<n;i++){
            if(Character.isDigit(s.charAt(i))||Character.isAlphabetic(s.charAt(i)))
                news += s.charAt(i);
        }
        news = news.toLowerCase();
        char[] sarr = news.toCharArray();
        int l = 0,r = sarr.length-1;
        while (l<=r){
            if(sarr[l]==sarr[r]){
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
