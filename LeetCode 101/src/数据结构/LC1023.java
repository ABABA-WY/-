package 数据结构;

import java.util.*;

public class LC1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<Boolean>();
        for(String query:queries){
            ans.add(isMatch(query,pattern));
        }
        return ans;
    }
    public boolean isMatch(String query,String pattern){
        int idx1=0,idx2=0;
        int n1=query.length(),n2=pattern.length();
        while(idx1<n1&&idx2<n2){
            char c1=query.charAt(idx1);
            char c2=pattern.charAt(idx2);
            if(c1==c2){
                idx1++;
                idx2++;
            }
            else{
                if(c1>='A'&&c1 <= 'Z') return false;
                idx1++;
            }
        }
        if(idx2!=n2) return false;
        while(idx1<n1){
            if (query.charAt(idx1)>='A'&&query.charAt(idx1)<='Z')
                return false;
            idx1++;
        }
        return true;
    }

}
