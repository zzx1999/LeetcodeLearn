package Stringoperation;

public class reverseLeftWordsoff58 {
    public String reverseLeftWords(String s, int n) {
        StringBuffer res = new StringBuffer();
        char[] arr = s.toCharArray();
        if(n>=s.length())
            return s;
        for(int i=n;i<s.length();i++){
            res.append(arr[i]);
        }
        for(int i=0;i<n;i++){
            res.append(arr[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int n = 2;
        String s = "abcdefg";
        reverseLeftWordsoff58 rl = new reverseLeftWordsoff58();
        rl.reverseLeftWords(s,n);

    }
}
