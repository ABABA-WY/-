package 排序;

import java.util.Scanner;

public class 归并排序 {
    private static int[] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        merge_sort(array, 0, n - 1);
        for (int i = 0; i < n; i++)
            System.out.print(array[i] + " ");
    }

    public static void merge_sort(int[] array, int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        merge_sort(array, l, mid);
        merge_sort(array, mid + 1, r);
        int[] ans = new int[array.length];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (array[i] < array[j]) ans[k++] = array[i++];
            else ans[k++] = array[j++];
        }
        while (i <= mid) ans[k++] = array[i++];
        while (j <= r) ans[k++] = array[j++];
        for (i = l, j = 0; i <= r; i++, j++) {
            array[i] = ans[j];
        }
    }
}
