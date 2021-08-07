package QaDay;
//457. ���������Ƿ����ѭ��
public class CheckLoop {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0)
                continue;
            int slow =  i,fast = next(nums,i);
            //����ָ��ѭ������Ѱ�һ�
            //slow��һ����fast��������Ҫ��֤fast�ĵ�һ���͵ڶ�������slow����һ��
            while (nums[slow] * nums[fast]>0&&nums[slow] * nums[next(nums,fast)]>0){
                if(slow == fast){//fast��һ���ͺ�slow�غ�,˵����slow��fast���ܴ��ڻ�
                    if(slow!=next(nums,slow)) //��������ѭ�������
                        return true;
                    else
                        break;
                }
                slow = next(nums,slow);
                fast = next(nums,next(nums,fast));//fast������

            }
            //slow�߹��ĵط����Ϊ0
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
        //���i+nums[i]�Ǹ�����Ҫ+nӳ�䵽�����ϡ�
        return ((i+nums[i]) % n + n) % n;
    }
}
