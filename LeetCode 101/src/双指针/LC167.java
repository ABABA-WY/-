package 双指针;

public class LC167 {
    public static void main(String[] args) {
        int [] numbers={0};
        int target=0;
        int[] a=new int[2];
        for (int i = 0; i< numbers.length; i++) {
            if(numbers[i] > target) break;
            for (int j = i+1; j<numbers.length; j++) {
                if(numbers[i]+numbers[j]==target){
                    a[0]=i+1;
                    a[1]=j+1;
                    break;
                }
            }
        }
        return ;
    }
}
