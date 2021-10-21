package QaDay;

public class plusOne66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        boolean flag = false;
        for(int i = n-1;i>=0;i--){
            if(i==n-1){
                if(digits[i]==9){
                    digits[i] = 0;
                    flag = true;
                }
                else{
                    digits[i] += 1;
                    break;
                }
            }
            else{
                if(flag){
                    flag = false;
                    if(digits[i]==9){
                        digits[i] = 0;
                        flag = true;
                    }
                    else{
                        digits[i] += 1;
                        break;
                    }
                }
            }
        }
        if(flag){
            int[] res = new int[n+1];
            res[0] = 1;
            for(int i=1;i<=n;i++){
                res[i] = digits[i-1];
            }
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] dig = {9};
        plusOne66 po = new plusOne66();
        System.out.println(po.plusOne(dig));
    }
}
