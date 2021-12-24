package Competition;

import java.util.Scanner;

public class AAMDeviation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            int a1 = input.nextInt();
            int a2 = input.nextInt();
            int a3 = input.nextInt();
            int res=a1 + a3 - a2 * 2;
            if (Math.abs(a1 + a3 +1 -(a2-1) * 2)<Math.abs(res))
                res=a1 + a3 +1 -(a2-1) * 2;
            if(Math.abs(a1 + a3 -1 -(a2+1) * 2)<Math.abs(res))
                res = a1 + a3 -1 -(a2+1) * 2;
            System.out.println(res);
        }
    }
}
