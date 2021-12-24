package lable3;

import java.util.*;

public class Lc217 {
    public static void main(String[] args) {
        int[] nums={3,3,3};
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1]){
                System.out.println("true");
            }
        }
        System.out.println("false");
    }
}
