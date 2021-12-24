package 数学;

import java.util.Arrays;

public class LC9 {
    public static void main(String[] args) {
        int x= 1234567899;
        System.out.println(new LC9().isPalindrome(x));
    }
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        StringBuilder ans=new StringBuilder();
        int n=x;
        if(x==0)
            ans.append(0);
        while(n!=0){
            ans.append(n%10);
            n/=10;
        }
        if(ans.toString().equals(ans.reverse().toString()))
            return true;
        return false;
    }
}
