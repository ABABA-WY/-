package 排序;

import java.util.Arrays;
import java.util.Scanner;

public class 快排 {
    private static int[] q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        quick_sort(q, 0, n - 1);
        for (int i = 0; i < n; i++)
            System.out.print(q[i] + " ");
    }

    public static void quick_sort(int[] q, int l, int r) {
        if (l >= r)
            return;
        int x = q[(l + r) / 2];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (q[i] < x);
            do {
                j--;
            } while (q[j] > x);
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quick_sort(q, l, j);
        quick_sort(q, j + 1, r);
    }
}
