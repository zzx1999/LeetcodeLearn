package String_off;

public class isNumberoff20 {
    //捏妈这题有限自动机
    public boolean isNumber(String s) {
        s = s.trim();//去除首尾空格
        char[] arr = s.toCharArray();
        boolean haspoint = false,hasNum = false,hase = false,hasSign = false;
        int n = arr.length;
        if(n==0)
            return false;
        int index = 0;
        while (index<n){
            if(arr[index]>='0'&&arr[index]<='9'){
                hasNum = true;
                while (arr[index]>='0'&&arr[index]<='9'){
                    index++;
                    if(index>=n)
                        break;
                }
                continue;
            }
            else if(arr[index]=='e'||arr[index]=='E'){
                //如果当前是e,如果e之前没有数字返回false
                if(!hasNum||hase)
                    return false;
                hase = true;
                hasNum = false;
                hasSign = false;
                haspoint = false;
            }
            else if(arr[index]=='+'||arr[index]=='-'){
                if(hasNum||hasSign||haspoint)//如果前面已经出现过数字或者已经出现过符号或者已经出现过'.'
                    return false;
                hasSign = true;
            }
            else if(arr[index]=='.'){
                if(haspoint||hase)
                    return false;
                haspoint = true;
            }
            else {
                return false;
            }
            index++;

        }
        if(hasNum&&index==n)
            return true;
        else
            return false;

//        if(n==1){
//            if(arr[0]>='0'&&arr[0]<='9')
//                return true;
//            else
//                return false;
//        }
//
//        for(int i=0;i<n-1;i++){
//            char cur = arr[i];
//            char next = arr[i+1];
//            if((cur>='0'&&cur<='9')||((cur=='+'||cur=='-'||cur=='e'||cur=='E')&&((next>='0'&&next<='9')||(next=='+'||next=='-')))||(cur=='.'&&(!haspoint))){
//                if(cur=='.')
//                    haspoint = true;
//                continue;
//            }
//            else
//                return false;
//        }
//        if(arr[0]=='e')
//            return false;
//        if((arr[arr.length-1]>='0'&&arr[arr.length-1]<='9')||(arr[arr.length-1]=='.'&&(!haspoint)))
//            return true;
//        else
//            return false;
    }

    public static void main(String[] args) {
        String s = "-1E-16";
        isNumberoff20 in = new isNumberoff20();
        System.out.println(in.isNumber(s));
    }
}
