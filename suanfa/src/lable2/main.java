package lable2;
import java.util.*;
public class main {
    public static void main(String[] args) {
        int[] nums={-4,-1,0,3,10};
        int[] a=new int[nums.length];
        int k= nums.length-1;

        for (int i = 0,j=nums.length - 1; i <= j; ) {
            if((nums[i]*nums[i])<(nums[j] * nums[j])){
                a[k--] = nums[j]*nums[j];
                j--;
            }
            else {
                a[k--] = nums[i]*nums[i];
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(a[i]);
        }
    }
}
