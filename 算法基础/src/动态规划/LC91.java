package 动态规划;

import java.util.Arrays;

public class LC91 {
    public int numDecodings(String s) {
        int n=s.length();
        if(n==0) return 0;
        int pre = s.charAt(0)-'0';
        if(pre==0) return 0;
        if(n==1) return 1;
        s=" " + s;
        //第i个数可以构成的解码数量
        int[] dp=new int [n+1];
        char [] cs=s.toCharArray();
        dp[0]=1;
        for(int i=1;i<=n; i++){
            // a : 代表「当前位置」单独形成 item
            // b : 代表「当前位置」与「前一位置」共同形成 item
            int a = cs[i] - '0';
            int b = (cs[i-1] - '0')*10+cs[i]-'0';
            // 如果 a 属于有效值，那么 f[i] 可以由 f[i - 1] 转移过来
            if(1<=a&&a<=9)
                dp[i]=dp[i-1];
            // 如果 b 属于有效值，那么 f[i] 可以由 f[i - 2] 或者 f[i - 1] & f[i - 2] 转移过来
            if(10<=b&&b<=26)
                dp[i] += dp[i-2];
        }
        return dp[n];
    }
}
