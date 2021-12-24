package lable3;

public class Lc53 {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int count=0;
        int result=nums[0];
        for (int i = 0; i < nums.length; i++) {
            count+=nums[i];
            if(count>result)
                result=count;
            if(count<0)
                count=0;
        }
        System.out.println(result);
    }
}
