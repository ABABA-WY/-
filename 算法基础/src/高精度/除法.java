package 高精度;

import java.util.Scanner;
import java.util.Vector;


public class 除法 {
    static int r = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A;
        Vector<Integer> a = new Vector<>();
        A = sc.next();
        int b = sc.nextInt();
        for (int i = A.length() - 1; i >= 0; i--) a.add(A.charAt(i) - '0');
        Vector<Integer> c = div(a, b);
        for (int i = 0; i < c.size(); i++)
            System.out.println(c.get(i));
        System.out.println(r);
    }

    //商是c余数是r
    public static Vector<Integer> div(Vector<Integer> a, int b) {
        Vector<Integer> c = new Vector<>();
        for (int i = a.size() - 1; i >= 0; i--) {
            r = r * 10 + a.get(i);
            c.add(r / b);
            r %= b;
        }
        while (c.size() > 0 && c.get(0) == 0) c.remove(0);
        return c;
    }
}
