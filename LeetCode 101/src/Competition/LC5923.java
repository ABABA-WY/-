package Competition;

import java.util.TreeSet;

public class LC5923 {
    public int minimumBuckets(String street) {
        if(street.length()==1){
            return street.charAt(0)=='H'?-1:0;
        }
        int res=0;
        int pre=-100;
        int n=street.length();

        for(int i=0;i<street.length(); i++){
            int j=i;
            while(j<n&&street.charAt(j) == 'H') j++;
            if(j-i>2) return -1;
            if(j-i==2){
                res+=2;
                pre=j-1;
            }
            if(j-i==1){
                res++;
                if(pre==i-2)
                    res--;
                pre=i;
            }

        }
        return res;
    }
}
