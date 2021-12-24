package lable4;

public class Lc167 {
    public static void main(String[] args) {
        int[] numbers={2,3,4};
        Lc167 test=new Lc167();
        int[] a=test.twoSum(numbers,6);
        System.out.println(a[0]);
        System.out.println(a[1]);
    }
    public int[] twoSum(int[] numbers, int target) {
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
        return a;
    }
}
