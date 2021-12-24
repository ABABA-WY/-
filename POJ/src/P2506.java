
import java.util.Scanner;


public class P2506 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] ans=new String[260];
        ans[1]="1";
        ans[2] = "3";
        while (input.hasNext()) {
            int n = input.nextInt();
            for(int i=3;i <= n; i++){
                ans[i]=addStrings(ans[i-1],mul2(ans[i-2]));
            }
            System.out.println(ans[n]);
        }
    }
    public static String addStrings(String num1, String num2) {
        StringBuffer ans=new StringBuffer();
        int add=0;
        for(int i=num1.length()-1,j = num2.length() - 1;i>=0||j >= 0||add!=0; i--,j--){
            int x=i>=0?num1.charAt(i)-'0':0;
            int y=j>=0?num2.charAt(j)-'0':0;
            int result=x+y+add;
            ans.append(result%10);
            add=result/10;
        }
        ans.reverse();
        return ans.toString();
    }
    public static String mul2(String s){
        int n=s.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry=0;
        for(int i=n;i>=0;i--){
            int u=s.charAt(i)-'0';
            sb.append((u*2+carry)%10);
            carry=(u*2+carry)/10;
        }
        if(carry == 1)
            sb.append(carry);
        return sb.reverse().toString();
    }

}
