import java.util.Arrays;
import java.util.Scanner;
/*拆地雷*/
public class P2670 {
    public static char[][] ans;
    public static char[][] d;
    public static int n;
    public static int m;
    public static int[] changes = {-1, 0, 1, 0, -1, -1, 1, 1, -1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        d = new char[n][m];
        ans = new char[n][m];
        for (int i = 0; i < n; i++) {
            d[i] = input.next().toCharArray();
            Arrays.fill(ans[i], '0');
        }
        calculate();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
/*
用d来存棋盘，将结果保存在ans数组中（开始时要将ans中所有的数值全初始化为‘0’），如果，d为*，
ans对应的位置也为*，且将八面的位置进行更新，如果符合条件，则将对应的值加一，
一直遍历完整个棋盘，最后将ans进行输出

* */
    public static void calculate() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == '*') {
                    ans[i][j] = '*';
                    for (int k = 0; k < changes.length - 1; k++) {
                        int nx = i + changes[k];
                        int ny = j + changes[k + 1];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m && d[nx][ny] != '*')
                            ans[nx][ny]++;
                    }
                }
            }
        }
    }
}


