package 贪心;

import java.util.*;

public class LC763 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> ans= new ArrayList<Integer>();
        int [] a=new int[26];
        for (int i = 0; i < s.length(); i++){
            a[s.charAt(i)-'a']=i;
        }
        int start=0,end = 0;
        for (int i = 0; i < s.length(); i++){
            end=Math.max(end,a[s.charAt(i)-'a']);
            if(i==end){
                ans.add(i-start+1);
                start=end+1;
            }
        }

    }
}
