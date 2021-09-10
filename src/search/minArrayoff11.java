package search;

public class minArrayoff11 {
    public int minArray(int[] numbers) {
        int n = numbers.length-1;
        int l = 0,h = n,mid = 0;
        while (l<h){
            mid = l + (h-l)/2;
            if(numbers[mid]>numbers[h])
                l = mid+1;
            else if(numbers[mid]<numbers[h]){
                h = mid;
            }
            else{
                if(mid==h){
                    return numbers[mid];
                }
                else
                    h--;
            }
        }
        return numbers[l];
    }
}
