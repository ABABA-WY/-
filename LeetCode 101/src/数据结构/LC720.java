package 数据结构;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC720 {
    public static void main(String[] args) {
        String[] words={"w","wo","wor","worl", "world"};
        System.out.println();
    }
    public String longestWord(String[] words) {
        String ans="";
        Set<String> set=new HashSet<>();
        set.addAll(Arrays.asList(words));
        for (String w:words) {
            boolean flag=false;
            if(w.length()>ans.length()||(w.length() == ans.length()&&w.compareTo(ans)<0)){
                flag=true;
            }
            for(int i=1;i<w.length(); i++){
                if(!set.contains(w.substring(0,i))) {
                    flag = false;
                    break;
                }
            }
            if(flag) ans=w;
        }
        return ans;
    }
}
