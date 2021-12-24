package 贪心;

import java.util.*;

public class 区间选点 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = input.nextInt();
            int r = input.nextInt();
            ans.add(new int[]{l, r});
        }
        Collections.sort(ans, (a, b) -> {
            return a[1] - b[1];
        });
        int pre = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (ans.get(i)[0] > pre) {
                res++;
                pre = ans.get(i)[1];
            }
        }
        System.out.println(res);
    }
}
