package Daly;

import java.util.List;
import java.util.*;

public class LC187 {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> v=new LC187().findRepeatedDnaSequences(s);
        for (String b : v) {
            System.out.println(b);
        }
    }
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> ans = new HashMap<String, Integer>();
        List<String> ret=new ArrayList<String>();
        for(int i = 0; i <=s.length()-10; i++){
           String b = s.substring(i,i+10);
           ans.put(b, ans.getOrDefault(b,0)+1);

        }
        for(String b : ans.keySet()){
            int time=ans.get(b);
            if(time>1)
                ret.add(b);
        }
        return ret;

    }
}
