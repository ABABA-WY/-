package lable4;

import java.util.Arrays;

public class Lc1 {
    public static void main(String[] args) {
        int[] numbers={-1,-2,-3,-4,-5};
        Lc167 test=new Lc167();
        int[] a=test.twoSum(numbers,-8);
        System.out.println(a[0]);
        System.out.println(a[1]);
    }
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i< numbers.length; i++) {
            if(numbers[i] > target) break;
            for (int j = i+1; j<numbers.length; j++) {
                if(numbers[i]+numbers[j]==target){
                   return new int[] {j, j};
                }
            }
        }
        return new int[0];
    }
}
