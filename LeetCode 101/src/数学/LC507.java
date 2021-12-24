package 数学;

import java.util.Scanner;

public class LC507 {
    public static void main(String[] args) {
        int num= new Scanner(System.in).nextInt();
        System.out.println(new LC507().checkPerfectNumber(num));
    }
    public boolean checkPerfectNumber(int num) {
        int sum=1;
        if(num==1)
            return false;
        for (int i = 2; i*i <= num; i++) {
            if(num%i==0){
                sum+=i;
                if(i*i!=num){
                    sum+=num/i;
                }
            }
        }
        return sum==num;
    }
}
