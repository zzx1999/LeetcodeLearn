package IntegerProblem;

public class addBinaryoff002 {
    public String addBinary(String a, String b) {
        StringBuffer res = new StringBuffer();
        int n = a.length()>b.length()?a.length():b.length();
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        if (a.length()<b.length()){
            a = makeup(a,n);
        }
        else
            b = makeup(b,n);
        int carry = 0,cura = 0,curb = 0,cur = 0;
        for(int i=0;i<n;i++){
            cura = a.charAt(i) - '0';
            curb = b.charAt(i) - '0';
            cur = (cura + curb + carry) % 2;//这一位数值
            carry = (cura+curb+carry)/2;//下一位进位
            res.append(String.valueOf(cur));
        }
        if(carry>0) res.append("1");
        return res.reverse().toString();
    }
    //末尾补0
    public String makeup(String s,int n){
        while (s.length()!=n){
            s += "0";
        }
        return s;
    }

    public static void main(String[] args) {
        String a = "1",b = "111";
        addBinaryoff002 ab = new addBinaryoff002();
        System.out.println(ab.addBinary(a,b));
    }
}
