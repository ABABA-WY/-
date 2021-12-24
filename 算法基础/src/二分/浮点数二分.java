package 二分;

import java.util.Scanner;

public class 浮点数二分 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double l = 0;
        double r = x;
        while (r - l > 1e-4) {
            double mid = (l + r) / 2;
            if (mid * mid >= x) r = mid;
            else l = mid;
        }
        System.out.println(l);
    }
}
