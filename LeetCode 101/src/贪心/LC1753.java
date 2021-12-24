package 贪心;

import java.util.Scanner;

public class LC1753 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(new LC1753().maximumScore(a,b,c));
    }
    public int maximumScore(int a, int b, int c) {
        int sum=a+b+c;
        a=Math.min(Math.min(a,b),c);
        c=Math.max(Math.max(a,b),c);
        b=sum-a-c;
        int count =0;
        if(a+b==c){
            return c;
        }
        while(a!=0&&b!=0){
            if(a+b==c){
                return count+c;
            }
            else if(a+b>c){
                count++;
                a--;
                b--;
            }
            else{
                b--;
                c--;
                count++;
            }
        }
        if(a>0||b > 0){
            a=a>0?a:b;
        }
        count+=Math.min(a,c);
        return count;
    }
}
