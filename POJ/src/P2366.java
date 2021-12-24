import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P2366 {
    public static void main(String[] args) {
        Set<Integer> ans=new HashSet<Integer>();
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        for (int i = 0; i < n; i++) {
            ans.add(input.nextInt());
        }
        boolean flag=false;
        int m=input.nextInt();
        for(int i = 0; i < m; i++){
            int b=input.nextInt();
            if(ans.contains(10000-b)) {
                flag = true;
                break;
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
