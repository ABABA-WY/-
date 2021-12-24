package 动态规划;

import java.util.Scanner;

public class 最长上升子序列 {
    public static int N = 1010;
    public static int[] f = new int[N];//状态
    public static int[] a = new int[N];//整个序列
    public static int[] g = new int[N];//转移数组
//n^2时间复杂度
    /*public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = input.nextInt();
            f[i] = 1;//只有第i个数
            g[i] = 0;
            //从前往后遍历，如果有符合条件的子序列，则将当前数加入子序列
            for (int j = 1; j < i; j++) {
                if (a[j] < a[i]) {
                    if (f[j] + 1 > f[i]) {
                        f[i] = f[j] + 1;
                        g[i] = j;//记录转移坐标
                    }
                }
            }
        }
        int k = 1;
        for (int i = 1; i <= n; i++) {
            if (f[i] > f[k])
                k = i;
        }
        System.out.println(f[k]);
        //子序列逆序输出
        while (g[k] != 0) {
            System.out.println(a[k]);
            k = g[k];
        }
    }*/

    //nlogn时间复杂度
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = input.nextInt();
        }
        int cnt = 0;
        f[cnt++] = a[1];
        for (int i = 2; i <= n; i++) {
            //如果当前数大于子序列最后一个数，则加到末尾
            if (a[i] > f[cnt - 1]) f[cnt++] = a[i];
                //否则用二分查找的方式找到子序列中第一个比a[i]大的数，并将a[i]替换到这个位置
            else {
                int l = 0, r = cnt - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (f[mid] >= a[i]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                //替换
                f[r] = a[i];
            }
        }
        System.out.println(cnt);
    }
}
