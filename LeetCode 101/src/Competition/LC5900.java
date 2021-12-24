package Competition;

import java.util.*;

public class LC5900 {
    public static void main(String[] args) {
        String s="**|**|***|";
        int[][] queries={{2,5},{5,9}};
        System.out.println(s.substring(2,6));
        System.out.println(s.substring(5,10));
        int []res=new LC5900().platesBetweenCandles(s,queries);
        System.out.println();
    }
    public int[] platesBetweenCandles(String s, int[][] queries) {
        List<Integer> ans=new ArrayList<Integer>();
        int[] dp=new int[s.length()];
        int i=0;
        while(i<s.length()&&s.charAt(i)!='|'){
            i++;
        }
        dp[i]=0;
        int count =0;
        for(int j=i+1;j<s.length(); j++){
            if(s.charAt(j) =='*'){
                count++;
            }
            else {
                dp[j]=count;
                count=0;
                i=j;
            }
        }
        for(int k=0;k< queries.length;k++){
            int sum=0;
            int l=queries[k][0],r = queries[k][1];
            for (int j = l; j < r; j++) {
                sum+=dp[j];
            }
            ans.add(sum);
        }
        int[] res=new int[ans.size()];
        for(int j=0;j<ans.size(); j++){
            res[j] = ans.get(j);
        }
        return res;
    }
}
