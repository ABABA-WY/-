package 数学;

public class LC238 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int[] res=new LC238().productExceptSelf(nums);
        for(int x:res)
            System.out.println(x);
    }
    public int[] productExceptSelf(int[] nums) {
        int[] output=new int[nums.length];
        int[] l=new int[nums.length];
        int[] r=new int[nums.length];
        l[0]=1;
        for(int i=1;i<nums.length; i++){
            l[i]=nums[i-1]*l[i-1];
        }
        r[nums.length - 1]=1;
        for(int i=nums.length - 2; i >= 0; i--){
            r[i]=nums[i+1]*r[i+1];
        }
        for(int i=0;i< nums.length;i++){
            output[i]=l[i]*r[i];
        }
        return output;
    }
}
