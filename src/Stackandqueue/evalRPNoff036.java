package Stackandqueue;

import java.util.Stack;

public class evalRPNoff036 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for(String str:tokens){
            if(isDigt(str)){
                st.add(Integer.valueOf(str));
            }
            else{
                int a = st.pop();
                int b = st.pop();
                if(str.equals("+")){
                    res = (a+b);
                }
                else if(str.equals("-")){
                    res = (b-a);
                }
                else if(str.equals("*")){
                    res = (a*b);
                }
                else if(str.equals("/")){
                    res = (b/a);
                }
                st.add(res);

            }
        }
        return res;

    }
    private boolean isDigt(String str){
        for(int i=0;i<str.length();i++){
            if(i==0&&(str.charAt(i)=='-')&&str.length()!=1)
                continue;
            if(!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] tokens = {"4","3","-"};
        evalRPNoff036 er = new evalRPNoff036();
        er.evalRPN(tokens);
    }
}
