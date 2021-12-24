import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1700 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        while (T-- > 0) {
            int n = input.nextInt();
            if (n == 0) {
                System.out.println(0);
                continue;
            }
            int[] people = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                people[i] = input.nextInt();
            }
            Arrays.sort(people);
            int time = 0;
            while (n > 3) {
                time += Math.min(people[1] * 2 + people[n] + people[n - 1], people[1] + people[2] * 2 + people[n]);
                n -= 2;
            }
            if (n == 3) {
                time += people[1] + people[2] + people[3];
            }
            else
                time+=people[n];
            System.out.println(time);
        }

    }
}
