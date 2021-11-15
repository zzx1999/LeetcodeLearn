package IntegerProblem;

public class countBitsoff003 {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        String binary = "";
        int count = 0;
        for(int i = 0;i<=n;i++){
            binary = Integer.toBinaryString(i);
            for(int j=0;j<binary.length();j++){
                if(binary.charAt(j)=='1')
                    count++;
            }
            res[i] = count;
            count = 0;
        }
        return res;
    }
}
