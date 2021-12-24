package lable11;

import java.util.*;

public class LC771 {
    public static void main(String[] args) {
        String J="aA";
        String S="AAAaaa";
        Map<Integer,Integer> ans=new HashMap<>();
        for(char c :S.toCharArray()){
            int key=c-'a';
            ans.put(key,ans.getOrDefault(key,0)+1);
        }
        int count=0;
        for(char c:J.toCharArray()){
            if(ans.getOrDefault(c-'a', 0) !=0){
                count+= ans.get(c-'a');
            }
        }
        System.out.println(count);
    }
}
