package 字符串;

import java.util.*;

public class LC205 {
    public static void main(String[] args) {
        String s= "egg", t = "add";
        System.out.println(new LC205().isIsomorphic(s,t));
    }
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);

    }
    public boolean isIsomorphicHelper(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Character> ans = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            char d=t.charAt(i);
            if(ans.containsKey(c)){
                if(ans.get(c)!=d)
                    return false;
            }
            else {
                ans.put(c, d);
            }
        }
        return true;

    }
}
