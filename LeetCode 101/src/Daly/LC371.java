package Daly;

import java.util.Scanner;

public class LC371 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a= cin.nextInt();
        int b = cin.nextInt();

    }
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
