package 栈和队列;

import java.util.Scanner;

public class 单调栈 {
    private static final int N = 100010;

    public static void main(String[] args) {
        int top = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ans = new int[N];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            while (top > 0 && ans[top] >= x) top--;
            if (top > 0) System.out.print(ans[top] + " ");
            else System.out.print(-1 + " ");
            ans[++top] = x;
        }
    }
}
