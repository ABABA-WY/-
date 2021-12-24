import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CSP_202104_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m=input.nextInt();
        int L = input.nextInt();
        Map<Integer,Integer> ans=new HashMap<Integer, Integer>();
        for(int i=1;i<=n; i++){
            for (int j = 1; j <= m; j++) {
                int x = input.nextInt();
                ans.put(x, ans.getOrDefault(x,0)+1);
            }
        }
        for(int i=0;i<L;i++){
            System.out.print(ans.getOrDefault(i, 0) + " ");
        }
    }
}
