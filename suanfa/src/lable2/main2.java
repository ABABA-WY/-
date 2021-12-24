package lable2;
import java.util.*;
public class main2 {
    public static void main(String[] args) {
        main2 t=new main2();
        int[] nums = {1,2,3,4,5,6,7};
        int k=3;
        k %= nums.length;
        t.revese(nums,0, nums.length-1);
        t.revese(nums,0,k-1);
        t.revese(nums, k,nums.length - 1);
//        int b= nums.length-1;
//        for (int i=0; i<k; i++){
//            int a=nums[b];
//            for(int j=b;j>=1;j--){
//                nums[j] = nums[j-1];
//            }
//            nums[0]=a;
//        }
        for (int i=0;i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }
    public void revese(int[] nums,int start,int end){
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
