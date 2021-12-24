package Daly;

import java.util.Arrays;

public class LC66 {
    public static void main(String[] args) {
        int[] digits={8,9,9,9};
        int[] res=new LC66().plusOne(digits);
        for(int num:res){
            System.out.println(num);
        }
    }
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        if(digits[n-1]<9&&digits[n-1]>=0){
            digits[n-1]+=1;
            return digits;
        }
        int[] ans=new int[n+1];
        ans[n]=0;
        int pre=1;
        for(int i=n-1;i>=1;i--){
            ans[i] = (digits[i-1]+pre)%10;
            pre=(digits[i-1]+pre)/10;
        }
        ans[0]=pre;
        if(pre==0){
            return Arrays.copyOfRange(ans,1,n+1);
        }
        return ans;
    }
}
