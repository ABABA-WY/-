package lable5;

import java.util.*;

public class Lc350 {
    public static void main(String[] args) {
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] nums3 =new int[Math.min(nums1.length,nums2.length)];
        int index1=0,index2 = 0,index=0;
        while (index1<nums1.length&&index2<nums2.length){
            if(nums1[index1] <nums2[index2]){
                index1++;
            }
            else if(nums1[index1] >nums2[index2]){
                index2++;
            }
            else {
                nums3[index]=nums1[index1];
                index++;
                index2++;
                index1++;
            }
        }
        for(int i=0;i<index;i++)
            System.out.println(nums3[i]);
    }
}
