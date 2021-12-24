package lable10;

public class LC1835 {
    public static void main(String[] args) {
        int[] arr1={1,2,3};
        int[] arr2={6,5};
        System.out.println(new LC1835().getXORSum(arr1,arr2));
    }
    public int getXORSum(int[] arr1, int[] arr2) {
        int ret=0;
        int sum=0;
        for(int x:arr2){
            sum^=x;
        }
        for (int y : arr1) {
            ret^=(y&sum);
        }
        return ret;
    }
}
