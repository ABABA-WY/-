import java.util.Scanner;

public class P1003 {
    public static void main(String[] args) {
        int[] a, b, g, k;
        int n;
        int x, y;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        a = new int[n + 1];
        b = new int[n + 1];
        g = new int[n + 1];
        k = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = input.nextInt();
            b[i] = input.nextInt();
            g[i] = input.nextInt();
            k[i] = input.nextInt();
        }
        x = input.nextInt();
        y = input.nextInt();
        int res = -1;
        for (int i = 1; i <= n; i++) {
            if (a[i] <= x && a[i] + g[i] >= x && b[i] <= y && b[i] + k[i] >= y) {
                res = i;
            }
        }
        System.out.println(res);
    }
}
