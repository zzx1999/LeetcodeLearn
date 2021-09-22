package QaDay;

public class Nimgame292 {
    public int loops = 0;
    //超时！
    public boolean canWinNim_Timeout(int n) {
        //分轮次
        if(loops % 2==0){//A 玩
            if(n<=3 && n>0){
                return true;
            }
            else if(n<0){
                return false;
            }
            loops++;
            return canWinNim(n-1)||canWinNim(n-2)||canWinNim(n-3);

        }
        else{//B玩
            if(n<=3 && n>0){
                return false;
            }
            else if(n<0){
                return true;
            }
            loops++;
            return canWinNim(n-1)&&canWinNim(n-2)&&canWinNim(n-3);
        }
        // if(n<0&&loops % 2 !=0)
        //     return false;
        // else if(n<=0&&loops % 2 ==0)
        //     return true;
        // if(n<=3&&loops % 2==0){
        //     return true;
        // }
        // else if(n<=3&&loops % 2 != 0){
        //     return false;
        // }
    }
    //假设当前的石头数目为 x，如果 x 为 4 的倍数时，则此时你必然会输掉游戏；
    // 如果 x 不为 4 的倍数时，则此时你只需要取走 xmod4个石头时,
    // 则剩余的石头数目必然为 444 的倍数，从而对手会输掉游戏。

    public boolean canWinNim(int n) {
        return n % 4 !=0;
    }

    public static void main(String[] args) {
        int n = 4;
        Nimgame292 ng = new Nimgame292();
        System.out.println(ng.canWinNim(n));
    }
}
