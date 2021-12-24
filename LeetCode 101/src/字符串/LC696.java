package 字符串;

import java.util.*;

public class LC696 {
    public static void main(String[] args) {
        String s="10101";
        System.out.println(new LC696().countBinarySubstrings(s));
    }
    public int countBinarySubstrings(String s) {
        List<Integer> ans = new ArrayList<>();
        int ptr=0;
        int n=s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count =0;
            while(ptr < n&&c==s.charAt(ptr)){
                count++;
                ptr++;
            }
            ans.add(count);
        }
        int ret=0;
        for (int i = 1; i < ans.size(); i++) {
            ret+=Math.min(ans.get(i), ans.get(i-1));
        }
        return ret;
    }
}
