package Competition;

import java.util.*;

public class LC5898 {
    public static void main(String[] args) {
        String[] s={"d","b","c","b","c","a"};
        System.out.println(new LC5898().kthDistinct(s,2));
    }
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> ans=new LinkedHashMap<>();
        for(String s : arr){
            ans.put(s, ans.getOrDefault(s,0)+1);
        }
        int count = 0;
        String res="";
        for(String key: ans.keySet()){
            int t=ans.get(key);
            if(t==1){
                count++;
                res=key;
                if(count==k){
                    return res;
                }
            }
        }
        return "";
    }

}
