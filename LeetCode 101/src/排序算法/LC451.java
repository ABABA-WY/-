package 排序算法;

import java.util.*;

public class LC451 {
    public static void main(String[] args) {
        String s="tree";
        System.out.println(new LC451().frequencySort(s));
    }
    public String frequencySort(String s) {
        Map<Character,Integer> Hashes=new HashMap<>();
        int maxFreq=0;
        for(char c : s.toCharArray()){
            int freq=Hashes.getOrDefault(c,0)+1;
            Hashes.put(c,freq);
            maxFreq=Math.max(maxFreq, freq);
        }
        StringBuffer[] b=new StringBuffer[maxFreq+1];
        for (int i = 0; i <= maxFreq;i++){
            b[i]=new StringBuffer();
        }
        for(Map.Entry<Character,Integer>entry:Hashes.entrySet()){
            char c = entry.getKey();
            int d=entry.getValue();
            b[d].append(c);
        }
        StringBuffer res = new StringBuffer();
        for(int i=maxFreq;i>0;i--){
            StringBuffer sb=b[i];
            for (int j = 0; j < sb.length(); j++){
                for (int k = 0; k < i; k++) {
                    res.append(sb.charAt(j));
                }
            }
        }
        return res.toString();
    }
}
