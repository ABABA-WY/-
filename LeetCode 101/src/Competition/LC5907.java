package Competition;

import java.util.HashMap;
import java.util.Map;

public class LC5907 {

    public int nextBeautifulNumber(int n) {

        for(int i=n+1;;i++){
            int j=i;
            int d=0;
            Map<Integer,Integer> ans=new HashMap<Integer, Integer>();
            while(j!=0){
                d=j%10;
                ans.put(d,ans.getOrDefault(d,0)+1);
                j/=10;
            }
            boolean flag=true;
            for(int key:ans.keySet()){
                int v=ans.get(key);
                if(v!=key){
                    flag=false;
                }
            }
            if(flag) return i;
        }
    }
}
