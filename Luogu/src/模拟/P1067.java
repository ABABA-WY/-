package 模拟;

import java.util.Scanner;

public class P1067 {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ans = new int[101];
        for (int i = 0; i <= n; i++) {
            ans[i] = scanner.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n ; i > 1; i--) {
            if (ans[n - i] != 0) {
                if (ans[n - i] > 0)
                    sb.append('+');
                sb.append(ans[n - i]).append("x^").append(i);
            }
        }
        if (ans[n - 1] != 0) {
            if (ans[n - 1] > 0)
                sb.append('+');
            sb.append(ans[n-1]).append("x");
        }
        if(ans[n]!=0){
            if(ans[n]>0)
                sb.append('+');
            sb.append(ans[n]);
        }
        System.out.println(sb.toString());
    }*/
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ans = new int[101];
        for (int i = 0; i <= n; i++) {
            ans[i] = scanner.nextInt();
        }
        String s = "";
        s+=String.valueOf(ans[0])+"x^"+String.valueOf(n);
        for (int i = n-1 ; i > 1; i--) {
            if (ans[n - i] != 0) {
                if (ans[n - i] > 0)
                    s+="+";
                if(ans[n - i]!=1||ans[n - i]!=-1)
                    s=s+String.valueOf(ans[n - i])+"x^"+String.valueOf(i);

            }
        }
        if (ans[n - 1] != 0) {
            if (ans[n - 1] > 0)
                s+="+";
            s=s+String.valueOf(ans[n - 1])+"x";
        }
        if(ans[n]!=0){
            if(ans[n]>0)
                s+="+";
            s=s+String.valueOf(ans[n ]);
        }
        System.out.println(s);
    }*/
}
