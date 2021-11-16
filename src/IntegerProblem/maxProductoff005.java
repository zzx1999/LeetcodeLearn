package IntegerProblem;

public class maxProductoff005 {
    public int maxProduct(String[] words) {
        //比较两个字符串是否出现相同字符 可以考虑转换成二进制编码
        int n = words.length;
        int[] strCode = new int[n];//存储每个字符串的二进制编码
        for (int i=0;i<n;i++){
            strCode[i] = 0;
            for(int j=0;j<words[i].length();j++){
                strCode[i] |= (1<<(words[i].charAt(j) - 'a'));
            }
        }
        int maxpro = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if((strCode[i] & strCode[j])==0)
                    maxpro = Math.max(maxpro,words[i].length()*words[j].length());
            }
        }
        return maxpro;

    }
    //编码错了!
//    public boolean hasSameChar(String a,String b){
//        char[] aarr = a.toCharArray();
//        char[] barr = b.toCharArray();
//        int aint = 0,bint = 0;
//        for(char c: aarr){
//            aint += c - 'a';
//            aint <<= 1;
//        }
//        for(char c: barr){
//            bint += c - 'a';
//            bint <<= 1;
//        }
//        int tmp = aint & bint;
//        boolean f = (aint & bint) == 0;
//        return f;
//
//    }

    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        maxProductoff005 mp = new maxProductoff005();
        mp.maxProduct(words);
    }
}
