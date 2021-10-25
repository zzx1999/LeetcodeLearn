package BitOperations;

public class addoff65 {
    public int add(int a, int b) {
        int n = 0,c = 1;
        while (b !=0){
            c = (a & b) << 1;//算进位
            a = a ^ b;
            b = c;
        }
        return a;

    }
}
