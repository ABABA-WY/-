package Daly;

import java.util.*;

public class LC1436 {
    public static void main(String[] args) {
        List<List<String>> paths=new ArrayList<>();
        List<String> r=new ArrayList<>(2);
        r.add("A");
        r.add("B");
        paths.add(r);
        r=new ArrayList<>(2);
        r.add("B");
        r.add("C");
        paths.add(r);
        System.out.println(new LC1436().destCity(paths));
    }
    public String destCity(List<List<String>> paths) {
        Map<String, String> ans = new HashMap<>();
        for(int i=0;i<paths.size(); i++){
            ans.put(paths.get(i).get(0),paths.get(i).get(1));
        }
        for(String s: ans.keySet()){
            String b=ans.get(s);
            if(!ans.containsKey(b))
                return b;
        }
        return null;
    }
}
