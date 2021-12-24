package lable10;

import java.util.HashMap;
import java.util.Map;

public class LC0104 {
    public static void main(String[] args) {
        String s="tactcoa";
        int m=0;
        Map<Integer, Integer> ans=new HashMap<>();
        for(char c : s.toCharArray()){
            ans.put(c-'a', ans.getOrDefault(c-'a',0)+1);
        }
        for(int key: ans.keySet()){
            int count = ans.get(key);
            if(count%2!=0)
                m++;
        }
        if(m>1) System.out.println("false");
        else System.out.println("true");
    }
}
