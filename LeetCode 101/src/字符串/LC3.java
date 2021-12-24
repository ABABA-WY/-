package 字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1)
            return 1;
        int low=0;
        int fast=0;
        int sub=fast-low;
        for(low=0;low < s.length(); low++){
            fast=low;
            if(s.length()-low<sub)
                break;
            Set<Character> ans=new HashSet<Character>();
            ans.add(s.charAt(fast));
            fast++;
            while(fast<s.length()&&!ans.contains(s.charAt(fast))){
                ans.add(s.charAt(fast));
                fast++;
            }
            sub=Math.max(sub,fast-low);
        }
        return sub;
    }
}
