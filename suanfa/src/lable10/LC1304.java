package lable10;

import java.util.Scanner;

public class LC1304 {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();
        int[] res=new LC1304().sumZero(n);
        for(int x:res)
            System.out.println(x);
    }
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int left=0,right = n-1;
        int z=1;
        while (left < right){
            ans[right]=z;
            ans[left]=-z;
            z++;
            right--;
            left++;
        }
        if(n%2!=0) {
            ans[left] = 0;
        }
        return ans;
    }
}
