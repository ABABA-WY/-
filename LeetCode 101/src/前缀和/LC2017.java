package 前缀和;

public class LC2017 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.contains("a"));
        int[][] grid = {{20, 3, 20, 17, 2, 12, 15, 17, 4, 15}, {20, 10, 13, 14, 15, 5, 2, 3, 14, 3}};
        //[[20,3,20,17,2,12,15,17,4,15],[20,10,13,14,15,5,2,3,14,3]]
      //  System.out.println(new LC2017().gridGame(grid));
    }

    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        dp1[0] = 0;
        //[[20,3,20,17,2,12,15,17,4,15],[20,10,13,14,15,5,2,3,14,3]]
        for (int i = 1; i < n; i++) {
            dp1[i] = dp1[i - 1] + grid[0][i];
        }
        dp2[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp2[i] = dp2[i + 1] + grid[1][i];
        }
        int k = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(dp1[i] + dp2[i]);
            System.out.println(dp1[k] + dp2[k] + "\n");
/*            if(dp1[i]+dp2[i]>dp1[k]+dp2[k])
                k=i;*/
            if (Math.max(dp1[n - 1] - dp1[k], dp2[0] - dp2[k]) > Math.max(dp1[n - 1] - dp1[i], dp2[0] - dp2[i]))
                k = i;
        }
        max = Math.max(dp1[n - 1] - dp1[k], dp2[0] - dp2[k]);
        return max;
    }
}
