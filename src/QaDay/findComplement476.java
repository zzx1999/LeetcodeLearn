package QaDay;

public class findComplement476 {
    public int findComplement(int num) {
        int highbit = 0;
        for(int i=1;i<=30;i++){
            if(num>=1<<i){//寻找最高位1
                highbit = i;
            }
            else{
                break;
            }
        }
        int mask = highbit == 30?0x7fffffff:(1<<(highbit+1))-1;//构造掩码mask = 2^{i+1} - 1，它是一个 i+1 位的二进制数，并且每一位都是 1。
        return num^mask;//然后将mask和num做异或


    }
}
