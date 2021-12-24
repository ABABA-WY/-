package 字符串;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LC409 {
    public static void main(String[] args) {
        String s=new Scanner(System.in).next();
        System.out.println(new LC409().longestPalindrome(s));
    }
    public int longestPalindrome(String s) {
        Map<Character,Integer> ans=new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            ans.put(s.charAt(i), ans.getOrDefault(s.charAt(i),0)+1);
        }
        int count=0;
        for(char c: ans.keySet()){
            int t= ans.get(c);
            count+=t/2*2;
            if(t%2==1&&count%2==0){
                count++;
            }
        }
        return count;
    }
}
