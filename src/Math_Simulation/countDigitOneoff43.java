package Math_Simulation;

import java.util.Map;

public class countDigitOneoff43 {
    public int countDigitOne(int n) {
        int res = 0;
        long k = 1;//记录这是个位,十位还是百位
        while (n>=k){
            res += (n/(k*10))*k + Math.min(Math.max((n%(k*10)-k+1),0),k);
            k*=10;


        }
        return res;
    }
}
