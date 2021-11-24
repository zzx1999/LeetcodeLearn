package String_off;

public class validPalindromeoff019 {
    public boolean validPalindrome(String s) {
        int n = s.length();
        if(n==0)
            return true;
        int l = 0,r = n-1;
        while (l<=r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }
            else{
                return IsPalindrome(s.substring(l,r))||IsPalindrome(s.substring(l+1,r+1));
            }
        }
        return true;
    }
    public boolean IsPalindrome(String s) {
        int n = s.length();
        if(n==0)
            return true;
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

    public static void main(String[] args) {
        String s = "ebcbbececabbacecbbcbe";
        validPalindromeoff019 vpd = new validPalindromeoff019();
        vpd.validPalindrome(s);

    }
}
