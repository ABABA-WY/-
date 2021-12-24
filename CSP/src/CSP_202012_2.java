import java.util.*;

public class CSP_202012_2 {
    public static void main(String[] args) {
        List<int[]> ans = new ArrayList<int[]>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ans.add(new int[]{-1, -1});
        for (int i = 1; i <= n; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            ans.add(new int[]{a, b});
        }
        Collections.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });

        //前i个数0或1的数量
        int[] sum1 = new int[n + 2];
        int[] sum2 = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            int b = ans.get(i)[1];
            sum1[i] = sum1[i - 1];
            if (b == 0)
                sum1[i]++;
        }
        for (int i = n; i >= 1; i--) {
            int b = ans.get(i)[1];
            sum2[i] = sum2[i + 1];
            if (b == 1)
                sum2[i]++;
        }
        int max = 0;
        int res = -1;
        for (int i = 1; i <= n; i++) {
            int a = ans.get(i)[0];
            int b = ans.get(i)[1];
            //右边为1
            int now = sum1[i - 1] + sum2[i];
            if (now >= max) {
                max = now;
                res = a;
            }
        }
        System.out.println(res);
    }
}
