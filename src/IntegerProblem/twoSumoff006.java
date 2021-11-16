package IntegerProblem;

public class twoSumoff006 {
    //双指针
    public int[] twoSum(int[] numbers, int target) {
        int l = 0,r = numbers.length;
        while (l<r){
            if(numbers[l]+numbers[r]>target)
                r--;
            else if(numbers[l]+numbers[r]<target)
                l++;
            else
                break;
        }
        return new int[]{l,r};
    }
}
