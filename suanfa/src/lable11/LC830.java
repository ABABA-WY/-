package lable11;

import java.util.*;

public class LC830 {
    public static void main(String[] args) {
        String s="abbxxxxzzy";
        List<List<Integer>> res=new LC830().largeGroupPositions(s);
        for(List<Integer> a:res){
            for(int i:a){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        if (s.length()<3) return ans;
        int i=0;
        while (i<s.length()){
            int count=0;
            char c = s.charAt(i);
            while(i+count<s.length()&&s.charAt(i+count)==c){
                count++;
            }
            if(count>=3){
                List<Integer> temp=new ArrayList<Integer>();
                temp.add(i);
                temp.add(i+count-1);
                ans.add(temp);
            }
            i=i+count;
        }
        return ans;
    }
}
