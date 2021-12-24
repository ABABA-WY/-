package lable4;

public class Lc283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        for(int j=0;j < nums.length; j++) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
