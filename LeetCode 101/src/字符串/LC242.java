package 字符串;

import java.util.Arrays;

public class LC242 {
    public static void main(String[] args) {
        String s="anagram";
        String t= "nagaram";
        System.out.println(new LC242().isAnagram(s,t));
    }
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())
            return false;
        char[ ]c =s.toCharArray();
        char[] b=t.toCharArray();
        Arrays.sort(c);
        Arrays.sort(b);
        for (int i = 0; i < c.length; i++) {
            if (c[i]!=b[i])
                return false;
        }
        return true;
    }
}
