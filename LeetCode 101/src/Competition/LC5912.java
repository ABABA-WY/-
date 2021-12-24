package Competition;

import java.util.Arrays;
import java.util.Comparator;


public class LC5912 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items,new Comparator<int[]>() {
            public int compare(int[]a,int[]b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else
                    return a[0] - b[0];
            }
        });
        int value=0;
        for(int i = 0; i < items.length; i++){
            if(items[i][1]<=value){
                items[i][1]=value;
            }
            else {
                value = items[i][1];
            }
        }
        int n=queries.length;
        int m=items.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int l=0,r=m-1;
            while(l<r){
                int mid=l+(r-l)/2+1;
                if(items[mid][0]>queries[i])
                    r=mid-1;
                else
                    l = mid;
            }
            ans[i]=items[r][0]<=queries[i] ? items[r][1] : 0;
        }

        return ans;
    }
}
