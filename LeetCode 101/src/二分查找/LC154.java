package 二分查找;

import java.util.Arrays;

public class LC154 {
    public static void main(String[] args) {
        int[] nums={2,2,2,0,1};
        int x= Arrays.stream(nums).min().getAsInt();
        System.out.println(x);
    }
}
