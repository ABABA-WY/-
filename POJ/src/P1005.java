import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1005 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> ans = new ArrayList<Integer>();
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            double a = input.nextDouble();
            double b = input.nextDouble();
            ans.add(time(a, b));

        }
        for (int i = 1; i <= ans.size(); i++) {
            System.out.println("Property " + i + ": This property will begin eroding in year " + ans.get(i - 1) + ".");
        }
        System.out.println("END OF OUTPUT.");
    }

    public static int time(double a, double b) {
        double c = Math.sqrt(a * a + b * b);
        int cnt = 0;
        for (int i = 0; ; i += 50) {
            double x = Math.sqrt(2 * i / Math.PI);
            if (x >= c)
                return cnt;
            cnt++;
        }
    }
}

