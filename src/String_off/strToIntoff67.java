package String_off;

public class strToIntoff67 {
    public int strToInt(String str) {
        str = str.trim();
        char[] arr = str.toCharArray();
        int n = arr.length;
        if(arr.length==0)
            return 0;
        int i = 0;
        boolean hasNum = false;
        int flag = 0;
        int res = 0;
        if(arr[0]>='0'&&arr[0]<='9')
            flag = 1;
        while (i<n){
            char c = arr[i];
            if((c=='+'||c=='-')&&!hasNum){
                if(c=='-')
                    flag = -1;
                else if(c=='+')
                    flag = 1;
            }
            if(c>='0'&&c<='9'){
                while (arr[i]>='0'&&arr[i]<='9'){
                    if(res<Integer.MAX_VALUE/10)
                        res =(res * 10 + (arr[i] - '0'));
                    else if(res>Integer.MAX_VALUE/10||res==Integer.MAX_VALUE/10&&arr[i] >'7'){
                        if(flag==1)
                            return Integer.MAX_VALUE;
                        else if(flag==-1)
                            return Integer.MIN_VALUE;
                    }
                    i++;
                    if(i>=n)
                        break;
                }
                continue;
            }
            i++;
        }
        return res * flag;
    }

    public static void main(String[] args) {
        String s = "2147483646";
        strToIntoff67 sti = new strToIntoff67();
        System.out.println(sti.strToInt(s));
    }
}
