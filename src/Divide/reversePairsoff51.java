package Divide;

public class reversePairsoff51 {
    int[] tmp;
    public int reversePairs(int[] nums) {
        //归并-逆序对
        //考虑两个有序数组L,R,在归并过程中如果L[l]<R[r]就把L[l]放到merge数组,l指针右移,检查放进去的元素对逆序对的贡献
        //
        //分解： 待排序的区间为 [l,r]，令 m=⌊(l+r)/2⌋，我们把 [l,r] 分成 [l,m] 和 [m+1,r]
        //解决： 使用归并排序递归地排序两个子序列
        //合并： 把两个已经排好序的子序列 [l,m] 和 [m+1,r] 合并起来
        tmp = new int[nums.length];
        return mergeSort(nums,0,nums.length-1);

    }
    public int mergeSort(int[] nums,int l,int r){
        if(l>=r){
            return 0;
        }
        //递归划分
        int m = (l+r)/2;
        int res = mergeSort(nums,l,m)+mergeSort(nums,m+1,r);
        //合并阶段
        int i = l,j = m+1;
        for(int k = l;k<=r;k++){
            tmp[k] = nums[k];
        }
        for(int k=l;k<=r;k++){
            if(i==m+1)//如果左指针到头了直接将右边的归并上去
                nums[k] = tmp[j++];
            else if(j==r+1||tmp[i]<=tmp[j])//如果左边小于右边把左边的加进去
                nums[k] = tmp[i++];
            else{//右边小于左边,把右边的并进去,且和左边数组所有元素都构成逆序对
                nums[k] = tmp[j++];
                res+=m-i+1;

            }

        }
        return res;

    }

    public static void main(String[] args) {

    }
}
