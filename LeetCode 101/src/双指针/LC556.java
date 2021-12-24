package 双指针;

import java.util.Arrays;

public class LC556 {
    public static void main(String[] args) {
        int n=2147483486;
        System.out.println(new LC556().nextGreaterElement(n));
    }
    public int nextGreaterElement(int n) {
        String s=Integer.toString(n);
        char[] c=s.toCharArray();
        int len=s.length();
        int i = len-2;
        for(;i>=0;i--){
            if(s.charAt(i) < s.charAt(i+1))
                break;
        }
        if(i<0){
            return -1;
        }
        int j = len-1;
        for(;j>i;j--){
            if(s.charAt(i)<s.charAt(j)){
                char q=c[i];
                c[i]=c[j];
                c[j] = q;
                break;
            }
        }
        Arrays.sort(c,i+1,len);
        int ans=0;
        for(int k=0;k<c.length; k++){
            ans=ans*10+c[k]-'0';

        }
        if (ans < 0) {
            return -1;
        }
        return ans>Integer.MAX_VALUE ? -1 : ans;
    }
}
