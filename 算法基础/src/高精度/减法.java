package 高精度;

import java.util.Scanner;
import java.util.Vector;

public class 减法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A, B;
        Vector<Integer> a = new Vector<>();
        Vector<Integer> b = new Vector<>();
        A = sc.next();
        B = sc.next();
        for (int i = A.length() - 1; i >= 0; i--) a.add(A.charAt(i) - '0');
        for (int i = B.length() - 1; i >= 0; i--) b.add(B.charAt(i) - '0');
        Vector<Integer> c;
        if (cmp(a, b)) {
            c = sub(a, b);
            for (int i = c.size() - 1; i >= 0; i--)
                System.out.print(c.get(i));
        } else {
            c = sub(b, a);
            System.out.print('-');
            for (int i = c.size() - 1; i >= 0; i--)
                System.out.print(c.get(i));
        }

    }

    public static Vector<Integer> sub(Vector<Integer> a, Vector<Integer> b) {
        Vector<Integer> c = new Vector<>();
        int t = 0;//借位
        //t=a当前值减去b当前值减去借位
        for (int i = 0; i < a.size(); i++) {
            t = a.get(i) - t;
            if (i < b.size()) t -= b.get(i);
            c.add((t + 10) % 10);//t>0时为t,小于0时为t+10
            if (t >= 0) t = 0;
            else t = 1;
        }
        while (c.size() > 0 && c.get(c.size() - 1) == 0) c.remove(c.size() - 1);//去掉前导0
        return c;
    }

    public static boolean cmp(Vector<Integer> a, Vector<Integer> b) {//判断大小
        if (a.size() != b.size()) return a.size() > b.size();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b.get(i))
                return a.get(i) > b.get(i);
        }
        return true;
    }
}
