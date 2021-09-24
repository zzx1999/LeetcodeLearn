package DoublePointer;

public class reverseWordsoff58_1 {
    public String reverseWords(String s) {
        if(s.length()==0)
            return "";
        String[] splitstr = s.split(" ");
        int n = splitstr.length;
        if(n==0)
            return " ";
        int begin = 0,end = n-1;
        while (begin<end){
            String t = splitstr[begin];
            splitstr[begin] = splitstr[end];
            splitstr[end] = t;
            begin++;
            end--;
        }
        String newstr = "";
        for(String news:splitstr){
            if(!news.equals("")){
                newstr += news;
                newstr += " ";
            }

        }
        return newstr.substring(0,newstr.lastIndexOf(" "));

    }
    public String reverseWords_simple(String s) {
        String[] splitstr = s.split(" ");
        StringBuffer newstr = new StringBuffer();
        for(int i=splitstr.length-1;i>=0;i--){
            if(!splitstr[i].equals("")){
                newstr.append(splitstr[i]);
                newstr.append(" ");
            }
        }
        return newstr.toString().trim();//去掉首尾空格
    }

    public static void main(String[] args) {
        String s = " ";
        reverseWordsoff58_1 rw = new reverseWordsoff58_1();
        rw.reverseWords(s);
    }
}
