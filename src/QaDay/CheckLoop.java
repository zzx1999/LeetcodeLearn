package QaDay;
//457. 环形数组是否存在循环
public class CheckLoop {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0)
                continue;
            int slow =  i,fast = next(nums,i);
            //快慢指针循环遍历寻找环
            //slow走一步，fast走两步，要保证fast的第一步和第二步都和slow方向一致
            while (nums[slow] * nums[fast]>0&&nums[slow] * nums[next(nums,fast)]>0){
                if(slow == fast){//fast第一步就和slow重合,说明从slow到fast可能存在环
                    if(slow!=next(nums,slow)) //避免是自循环的情况
                        return true;
                    else
                        break;
                }
                slow = next(nums,slow);
                fast = next(nums,next(nums,fast));//fast走两步

            }
            //slow走过的地方标记为0
            int add = i;
            while(nums[add] * nums[next(nums,add)]>0){
                nums[add] = 0;
                add = next(nums,add);
            }

        }
        return false;


    }
    public int next(int[] nums,int i){
        int n = nums.length;
        //如果i+nums[i]是负数需要+n映射到正数上。
        return ((i+nums[i]) % n + n) % n;
    }
}
