package HashMap_;

import java.util.HashSet;
import java.util.Set;

public class findMaximumXORoff067 {
    //x=ai⊕aj等价于 aj=x⊕ai
    //将每一个数表示为一个长度为 313131 位的二进制数
    //这 31 个二进制位从低位到高位依次编号为 0,1,⋯,30.我们从最高位第 30个二进制位开始，依次确定 x 的每一位是 0 还是 1
    //由于我们需要找出最大的 x，因此在枚举每一位时，我们先判断 x 的这一位是否能取到 1。如果能，我们取这一位为 1，否则我们取这一位为 0。

    //基于哈希表
    //用 prek(x) 表示 x 从最高位第 30 个二进制位开始，到第 k 个二进制位为止的数
    //prek(aj)=prek(x)⊕prek(ai)
    //将所有的 prek(aj)放入哈希表中，随后枚举 i 并计算 prek(x)⊕prek(ai)。如果其出现在哈希表中，那么说明第 k 个二进制位能够取到 1，否则第 k 个二进制位只能为 0。
    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int k=30;k>=0;k--){
            Set<Integer> seen = new HashSet<>();
            for(int num:nums){
                seen.add(num >> k);//保留从最高位到第k个二进制位为止的部分
            }
            int newx = x*2 + 1;//把x第k个二进制为置为1
            boolean found = false;
            for(int num:nums){
                if(seen.contains(newx ^ (num >> k))) {
                    found = true;
                    break;
                }
            }
            if (found)
                x = newx;
            else
                x = x*2;
        }
        return x;
    }
}

