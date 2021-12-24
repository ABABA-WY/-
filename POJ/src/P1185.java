import java.util.Scanner;

public class P1185 {
    public static final int R = 110, C = 12;//行数和列数
    public static int[] base = new int[R];//每一行的状态
    public static int[] soldiers = new int[70];
    public static int[] states = new int[70];
    public static int[][][] dp = new int[R][70][70];//第i行为j状态，i-1行为k状态，最大炮兵个数dp[i][j][k]

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int c = input.nextInt();
        for (int i = 0; i < r; i++) {
            String str = input.next();
            for (int j = 0; j < c; j++) {
                //为H就将状态置为1
                if (str.charAt(j) == 'H')
                    base[i] += 1 << j;
            }
        }
        int nums = 0;
        for (int i = 0; i < 1 << c; i++) {
            if (legal(i, i << 1) || legal(i, i << 2)) continue;
            int k = i;
            while (k != 0) {
                soldiers[nums] += k & 1;
                k >>= 1;
            }
            states[nums++] = i;
        }
        for (int i = 0; i < nums; i++)  //初始化
        {
            if (legal(states[i], base[0])) continue; //去除炮兵在山上的
            dp[0][i][0] = soldiers[i];
        }
        for (int row = 1; row < r; row++) {//每一行
            for (int i = 0; i < nums; i++) {//第i行状态
                if (legal(states[i], base[row])) continue;
                for (int j = 0; j < nums; j++) {//第i-1行状态
                    if (legal(states[j], base[row - 1])) continue; //去除炮兵在山上的
                    if (legal(states[i], states[j])) continue; //去除炮兵相互攻击
                    for (int k = 0; k < nums; k++) {
                        if (row - 2 >= 0 && legal(states[k], base[row - 2])) continue; //去除炮兵在山上的
                        if (legal(states[k], states[i])) continue;
                        if (legal(states[k], states[j])) continue;
                        dp[row][i][j]=Math.max(dp[row][i][j],dp[row-1][j][k]+soldiers[i]);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < nums; i++)
            for (int j = 0; j < nums; j++)
                ans = Math.max(ans, dp[r - 1][i][j]);

        System.out.println(ans);
    }

    public static boolean legal(int a, int b) {
        return (a & b) != 0;
    }
}
