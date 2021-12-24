import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P3040 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //int[] map = new int[51];
        int[] money = {1, 5, 10, 50};
        while (input.hasNext()) {
            int n = input.nextInt();
            int c = input.nextInt();
            int res = 0;
            while (n-- > 0) {
                int a = input.nextInt();
                int b = input.nextInt();
                if (a >= c) {
                    res += b;
                    continue;
                }
                map.put(a, b);
            }
            while (true) {
                int x = c;
                //找到大的先减再说
                for (int i = 3; i >= 0; i--) {
                    while (map.containsKey(money[i]) && map.get(money[i]) > 0 && x >= money[i]) {
                        x -= money[i];
                        map.put(money[i], map.get(money[i]) - 1);
                    }
                }
                //大的不够减减小的
                if (x > 0) {
                    for (int i = 0; i < 4; i++) {
                        //找到可以减的数
                        if (map.containsKey(money[i]) && map.get(money[i]) > 0 && x <= money[i]) {
                            x -= money[i];
                            map.put(money[i], map.get(money[i]) - 1);
                            break;
                        }
                    }
                }
                //小的还找不到直接退出
                if (x > 0) break;
                res++;
            }
            System.out.println(res);
        }
    }
}