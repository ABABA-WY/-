package Competition;

import java.util.HashMap;
import java.util.Map;

public class LC5922 {
    public int countWords(String[] words1, String[] words2) {
        Map<String,Integer> ans=new HashMap<>();
        Map<String,Integer> ans2=new HashMap <>();
        for(String w:words1){
            ans.put(w, ans.getOrDefault(w,0)+1);
        }
        int res=0;
        for(String w : words2){
            ans2.put(w, ans.getOrDefault(w,0)+1);
        }
        for (String w : words1) {
            if(ans.containsKey(w)&&ans2.containsKey(w)&&ans.get(w)==1&&ans.get(w) == 1)
                res++;
        }
        return res;
    }
}
