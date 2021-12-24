package 字符串;

import java.util.*;

public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans=new HashMap<>();
        for(String str:strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            List<String> list=ans.getOrDefault(new String(c), new ArrayList<String>());
            list.add(str);
            ans.put(new String(c),list);
        }
        return new ArrayList<List<String>>(ans.values());
    }
}
