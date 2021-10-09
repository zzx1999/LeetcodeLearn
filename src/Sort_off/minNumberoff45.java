package Sort_off;

public class minNumberoff45 {
    //定义一个新的排序规则
    //若拼接字符串 x+y>y+x ，则 x “大于” y ；y在x前面
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] str = new String[n];
        for(int i=0;i<n;i++){
            str[i]=String.valueOf(nums[i]);
        }
        quickSort(str,0,n-1);
        StringBuilder res = new StringBuilder();
        for (String s:str){
            res.append(s);
        }
        return res.toString();
    }
    //快排
    //通过一趟排序将要排序的数据分割成独立的两部分。
    //其中一部分的所有数据都比另外一部分的所有数据都要小。
    //然后再按此方法对这两部分数据分别进行快速排序，整个排序可以递归进行，一次整个数据变成有序序列
    public void quickSort(String[] str,int l,int r){
        if(l>=r){
            return;
        }
        int i=l,j = r;
        String tmp = str[i];
        while (i<j){
            while ((str[j]+str[l]).compareTo((str[l]+str[j])) >=0 && i<j) j--;//从右向左寻找比str[l](key)小的
            while ((str[i]+str[l]).compareTo((str[l]+str[i])) <=0 && i<j) i++; //从左向右寻找比str[l](key)大的
            tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;//交换位置，小的放前面
        }
        //i和j相遇后交换这个数和key的位置(key此时所处的位置，前面都是比key小的，后面都是比key大的。)
        str[i] = str[l];
        str[l] = tmp;
        quickSort(str,l,i-1);//对前半段排序
        quickSort(str,i+1,r);//对后半段排序
    }
}
