package 高精度;

import java.util.Scanner;
import java.util.Vector;

public class 加法 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A, B;
        Vector<Integer> a = new Vector<>();
        Vector<Integer> b = new Vector<>();
        A = sc.next();
        B = sc.next();
        for (int i = A.length() - 1; i >= 0; i--) a.add(A.charAt(i) - '0');
        for (int i = B.length() - 1; i >= 0; i--) b.add(B.charAt(i) - '0');
        Vector<Integer> c = add(a, b);
        for (int i = c.size() - 1; i >= 0; i--)
            System.out.print(c.get(i));
    }

    public static Vector<Integer> add(Vector<Integer> a, Vector<Integer> b) {
        Vector<Integer> c = new Vector<>();
        if (a.size() < b.size())//简化计算
            return add(b, a);
        int t = 0;//进位
        for (int i = 0; i < a.size(); i++) {
            t += a.get(i);
            if (i < b.size()) t += b.get(i);
            c.add(t % 10);
            t /= 10;
        }
        return c;
    }
}
