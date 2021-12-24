package 数据结构;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for(String word : wordDict){
                int len=word.length();
                if(i>=len&&s.substring(i-len,i).equals(word)){
                    dp[i]=dp[i-len]||dp[i];
                }
            }
        }
        return dp[n];
    }
}
